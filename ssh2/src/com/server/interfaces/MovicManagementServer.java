package com.server.interfaces;

import com.bean.MovicInfo;

public interface MovicManagementServer {
	public boolean addMovic(MovicInfo movic);//��ӵ�Ӱ��Ϣ
	public boolean deleteMovicByOid(int movicOid);//ɾ����Ӱ���ݵ�Ӱoid
	public boolean updateMovic(MovicInfo movic);//���µ�Ӱ��Ϣ

}
