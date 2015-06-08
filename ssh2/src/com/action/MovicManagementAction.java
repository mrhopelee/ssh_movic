package com.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicManagementServer;

public class MovicManagementAction extends ActionSupport {
	/*该类将要完成有管电影的管理
	 * 1.电影地区添加/删除
	 * 2.电影类型添加/删除
	 * 3.电影添加
	 * 4.电影修改
	 * 5.电影删除
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
	

}
