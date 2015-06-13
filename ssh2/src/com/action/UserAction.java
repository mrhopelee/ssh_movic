package com.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bean.MD5Util;
import com.bean.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.UserServer;

public class UserAction extends ActionSupport {
	
	
	private UserInfo user;
	@Resource
	private UserServer userServer;
	
	//文件上传的3个东西
	private File upload;  
	private String uploadContentType;  
	private String uploadFileName;  
	
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	
	
	public UserServer getUserServer() {
		return userServer;
	}

	public void setUserServer(UserServer userServer) {
		this.userServer = userServer;
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

	//验证用户是否存在 或者 用户密码是否正确
	public String userLogin()
	{
		//密码加密
		MD5Util md5=new MD5Util();
		user.setUserPassword(md5.getMD5(user.getUserPassword().getBytes()));
		
		UserInfo u;
		if(userServer.checkUser(user))
		{
			HttpSession session= ServletActionContext.getRequest().getSession();
		    u=userServer.getUserInfo(user.getUserName());
			session.setAttribute("user",u);	
		}
		else
		{
			addFieldError("u","用户不存在或密码不正确");
			return "input";
		}
		if(u.getUserType().getValue()<=2)
		{
			return "success";
		}
		else
		{
			return "admin";
		}
		
	}
	public String userLogout()
	{
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		
		return "success";
	}
	
	public String updateUserLogo()
	{
		System.out.println("更新用户头像"+user.getUserOid()+" "+user.getUserLogo());
		
		String path = ServletActionContext.getServletContext().getRealPath("/user_logo/"+user.getUserOid()); 
		
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
		
		delFile(user.getUserLogo());
		user.setUserLogo("user_logo/"+user.getUserOid()+"/"+uploadFileName);
		
		userServer.updateUserLogo(user);
		
		UserInfo u;
		HttpSession session= ServletActionContext.getRequest().getSession();
	    u=(UserInfo) session.getAttribute("user");
	    u.setUserLogo(user.getUserLogo());
	    
	    session.setAttribute("user",u);
	    
		
		return "success";
	}
	
	public void validateUpdateUserLogo() {
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
	
	//删除旧的海报
	private boolean delFile(String fileName){
		String re=ServletActionContext.getServletContext().getRealPath("");
		System.out.println("删除文件路径："+re+fileName);
		File file=new File(re+fileName);  
        if(file.exists()){  
            return file.delete();  
        }  
        return false;  
    } 
	
	public String userRigister()
	{
		//System.out.println(" "+user.getUserName()+" "+user.getUserPassword()+" "+user.getUserSex()+" "+user.getUserEmail()+" "+user.getUserDisplayName());
		MD5Util md5=new MD5Util();
		user.setUserPassword(md5.getMD5(user.getUserPassword().getBytes()));
		int userid=0;
		
		try
		{
		 userid=userServer.rigisterUser(user);
		}
		catch (Exception e)
		{
			addFieldError("username","用户名或昵称以存在");
			return "input";
		}
		
		
			
		
	
		user=userServer.getUser(userid);
		userServer.addUserIntegral(user);
		
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		
		return "success";
	}


	public void validateUserRigister() {
		//用户信息验证
		//用户名6-15位
		if(user.getUserName().length()<=5||user.getUserName().length()>=16)
		{
			addFieldError("username", "用户名长度必须为6-15位");
		}
		if(user.getUserPassword().length()<=5||user.getUserPassword().length()>=16)
		{
			addFieldError("userpassword", "密码长度必须为6-15位");
		}
		
		
		
		
		
	}
	
	
}
