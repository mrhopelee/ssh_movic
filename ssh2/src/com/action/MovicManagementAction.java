package com.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicManagementServer;

public class MovicManagementAction extends ActionSupport {
	/*���ཫҪ����йܵ�Ӱ�Ĺ���
	 * 1.��Ӱ�������/ɾ��
	 * 2.��Ӱ�������/ɾ��
	 * 3.��Ӱ���
	 * 4.��Ӱ�޸�
	 * 5.��Ӱɾ��
	 * ���ߣ�������
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
