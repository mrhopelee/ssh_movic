package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Userinfo;
import com.opensymphony.xwork2.ActionSupport;
import com.server.Loginserver;
import com.server.Server;



public class login extends ActionSupport {
	private String name;
	private String password;
	
	@Resource
	private Server loginserver;


	


	public Server getLoginserver() {
		return loginserver;
	}


	public void setLoginserver(Server loginserver) {
		this.loginserver = loginserver;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String check()
	{

		loginserver.check();
		
		System.out.println(name+" "+password+" ");
		
		return "success";
	}



}
