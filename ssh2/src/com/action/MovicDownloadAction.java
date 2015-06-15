package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bean.MovicDownload;
import com.bean.MovicInfo;
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
		//上传的不是种子文件 则报错 
		if(!uploadContentType.equals("application/octet-stream"))
		{
			addFieldError("upload", "文件类型必须为种子文件");
			this.showMovicDownload();
		}
	
		
	}
	
	

}
