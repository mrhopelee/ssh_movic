package com.ajax.action;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class MyUser {
	private String name;
	private String password;
	private List l=new ArrayList<String>();
	
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
	


	public List getL() {
		return l;
	}

	public void setL(List l) {
		this.l = l;
	}

	public MyUser()
	{
		
	}

}
