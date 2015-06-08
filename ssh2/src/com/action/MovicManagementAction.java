package com.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicManagementServer;

public class MovicManagementAction extends ActionSupport {
	/*该类将要完成有管电影的管理
	 * 1.电影添加
	 * 2.电影修改
	 * 3.电影删除
	 * 作者：梁泽民
	 * */
	@Resource
	private MovicManagementServer movicManagementServer;

	public MovicManagementServer getMovicManagementServer() {
		return movicManagementServer;
	}

	public void setMovicManagementServer(MovicManagementServer movicManagementServer) {
		this.movicManagementServer = movicManagementServer;
	}
	
	public String goToAddMovicPage()
	{
		//该函数用来跳转到电影添加页面
		/*
		 * 1.首先要获取电影类型列表
		 * 2.接着获取电影地区列表
		 * 3.将该列表传到页面上
		 * */
		System.out.println("获取 电影类型 电影地区");
		
		return "success";
		
	}
	

}
