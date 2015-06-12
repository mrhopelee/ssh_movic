package com.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	
}
