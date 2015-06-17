package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bean.MovicDownload;
import com.bean.MovicInfo;
import com.bean.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicDownloadServer;

public class MovicDownloadAction extends ActionSupport{
	
	private List<MovicDownload> mdl;
	@Resource
	private MovicDownloadServer movicDownloadServer;
	private int movicOid;
	private int mdOid;
	
	private File upload;  
	private String uploadContentType;  
	private String uploadFileName;
	private int isok;

	private String fileName;  

	 
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIsok() {
		return isok;
	}
	public void setIsok(int isok) {
		this.isok = isok;
	}
	public List<MovicDownload> getMdl() {
		return mdl;
	}
	public void setMdl(List<MovicDownload> mdl) {
		this.mdl = mdl;
	}
	public MovicDownloadServer getMovicDownloadServer() {
		return movicDownloadServer;
	}
	public void setMovicDownloadServer(MovicDownloadServer movicDownloadServer) {
		this.movicDownloadServer = movicDownloadServer;
	}
	public int getMovicOid() {
		return movicOid;
	}
	public void setMovicOid(int movicOid) {
		this.movicOid = movicOid;
	}
	
	
	public int getMdOid() {
		return mdOid;
	}
	public void setMdOid(int mdOid) {
		this.mdOid = mdOid;
	}
	
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	//获取该电影所有的下载文件
	public String showMovicDownload()
	{
		mdl=movicDownloadServer.getMovicDownloadByMovicOid(movicOid);
		
		return "success";
		
	}
	public String movicDownloadDelete()
	{
		
		//1.首先获取这条电影下载记录
		//2.删除电影下载记录
		//3.删除对应文件
		MovicDownload md= movicDownloadServer.getMovicDownloadByOid(mdOid);
		System.out.println(md.getFilePath()+"  "+md.getMdOid());
		
		deleteFile(md.getFilePath());
		movicDownloadServer.deleteMovicDownloadByOid(mdOid);
		
		
		
		this.showMovicDownload();
		return "success";
	}
	private boolean deleteFile(String fileName){
		String re=ServletActionContext.getServletContext().getRealPath("");
		System.out.println("删除文件路径："+re+fileName);
		File file=new File(re+fileName);  
        if(file.exists()){  
            return file.delete();  
        }  
        return false;  
    }
	
	public String movicFileUpload()
	{
		String path = ServletActionContext.getServletContext().getRealPath("/movic_download/"+movicOid); 
		
		File file = new File(path);
		
		if(!file.exists())//生成文件夹
		{
			file.mkdirs();
		}
	
		//获取上传文件
		try {
			
			FileUtils.copyFile(upload, new File(file,uploadFileName));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//添加一条电影文件下载记录
		MovicDownload md=new MovicDownload();
		MovicInfo mi=new MovicInfo();
		mi.setMovicOid(movicOid);
		md.setMovicInfo(mi);
		md.setFilePath("movic_download/"+movicOid+"/"+uploadFileName);
		movicDownloadServer.addMovicDownload(md);

		this.showMovicDownload();
		
		return "success";
	}

	
	public void validateMovicFileUpload() {
		//上传的不是种子文件 则报错 application/zip application/x-rar-compressed
		System.out.println(uploadContentType+"文件类型");
		if(!uploadContentType.equals("application/octet-stream"))
		{
			addFieldError("upload", "文件类型必须为zip/rar文件");
			this.showMovicDownload();
		}
	
		
	}
	public String showDownloadList()
	{
		mdl=movicDownloadServer.getMovicDownloadByMovicOid(movicOid);
		isok=1;
		return "success";
		
		
	}
	public void validateShowDownloadList()
	{
		if(ServletActionContext.getRequest().getSession().getAttribute("user")==null)
		{
			ServletActionContext.getRequest().setAttribute("movicOid",movicOid);
			isok=0;
			addFieldError("a","您没有登录，无法下载电影");
		}
		else
		{
			UserInfo u=(UserInfo) ServletActionContext.getRequest().getSession().getAttribute("user");
			if(u.getUserType().getValue()<2)
			{
				ServletActionContext.getRequest().setAttribute("movicOid",movicOid);
				isok=0;
				addFieldError("b","您不是会员，无法下载电影");
			}
		}

		
	}
	public String downLoadFile()
	{
		//获取用户信息
		UserInfo user=(UserInfo) ServletActionContext.getRequest().getSession().getAttribute("user");
		//获取用户积分 如果积分少于10则不允许下载
		if(!movicDownloadServer.isUserCanDownLoad(user.getUserOid()))
		{
			addFieldError("s","你没有足够的积分进行扣除");
			return "input";
		}
		else
		{
			  fileName= "/"+movicDownloadServer.getMovicDownloadByOid(mdOid).getFilePath();
			
			return "success";
		}
		
	}
	
	

}
