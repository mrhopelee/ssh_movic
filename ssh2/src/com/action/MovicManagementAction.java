package com.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicManagementServer;

public class MovicManagementAction extends ActionSupport {
	/*���ཫҪ����йܵ�Ӱ�Ĺ���
	 * 1.��Ӱ���
	 * 2.��Ӱ�޸�
	 * 3.��Ӱɾ��
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
	
	public String goToAddMovicPage()
	{
		//�ú���������ת����Ӱ���ҳ��
		/*
		 * 1.����Ҫ��ȡ��Ӱ�����б�
		 * 2.���Ż�ȡ��Ӱ�����б�
		 * 3.�����б���ҳ����
		 * */
		System.out.println("��ȡ ��Ӱ���� ��Ӱ����");
		
		return "success";
		
	}
	

}
