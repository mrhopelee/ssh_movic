package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bean.MovicInfo;
import com.bean.MovicPicture;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicPictureServer;

//该类是处理电影图册 的增加 删除 修改 
//1.获取指定电影的 图片集合
public class MovicPictureAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MovicPicture nowPicture;
	private int movicOid;
	private List<MovicPicture> movicPictureList;
	
	@Resource
	private MovicPictureServer movicPictureServer;
	
	//文件上传的3个东西
    private File upload;  
	private String uploadContentType;  
	private String uploadFileName; 
	
	public MovicPicture getNowPicture() {
		return nowPicture;
	}
	public void setNowPicture(MovicPicture nowPicture) {
		this.nowPicture = nowPicture;
	}
	public int getMovicOid() {
		return movicOid;
	}
	public void setMovicOid(int movicOid) {
		this.movicOid = movicOid;
	}
	public List<MovicPicture> getMovicPictureList() {
		return movicPictureList;
	}
	public void setMovicPictureList(List<MovicPicture> movicPictureList) {
		this.movicPictureList = movicPictureList;
	}
	
	public MovicPictureServer getMovicPictureServer() {
		return movicPictureServer;
	}
	public void setMovicPictureServer(MovicPictureServer movicPictureServer) {
		this.movicPictureServer = movicPictureServer;
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
	public String showMovicPicture()
	{
		//通过 该方法 获取指定的电影的海报
		movicPictureList=movicPictureServer.showMovicPicture(movicOid);
		
		return "success";
	}
	
	public String pictureUpload()
	{
		System.out.println("movicOid="+movicOid);
		//1.获取上传文件
		//2.保存电影图册记录
		String path = ServletActionContext.getServletContext().getRealPath("/movic_picture/"+movicOid); 
		
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
		
		
		MovicPicture mp=new MovicPicture();
		MovicInfo mi=new MovicInfo();
		mi.setMovicOid(movicOid);
		mp.setMovicInfo(mi);
		mp.setPicturePath("movic_picture/"+movicOid+"/"+uploadFileName);
		movicPictureServer.addMovicPicture(mp);
		
		showMovicPicture();
		return "success";
	}

	public void validatePostUpload() {
		try
		{
			if(!upload.exists()||upload==null)
			{
				addFieldError("upload","文件不能为空");
			}
			if(!checkFileTypes())
			{
				addFieldError("upload","该文件类型不是（jpg/jpeg/png/gif）类型");
			}
		}
		catch(Exception e)
		{
			addFieldError("upload","文件不能为空");
			showMovicPicture();
			
		}
		
		
	
	}
	public boolean checkFileTypes()
	{
		//image/pjpeg image/bmp image/gif image/x-png
		//image/jpeg image/bmp image/gif image/png
		String []filetype={"image/pjpeg","image/bmp","image/gif","image/jpeg","image/png","image/x-png"};
		
		
		for(String ft:filetype)
		{
			if(uploadContentType.equals(ft))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public String deletePicture()
	{
		
		
		movicPictureServer.deletePicture(nowPicture);
		deleteFile(nowPicture.getPicturePath());
		showMovicPicture();
		
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
	

	

}
