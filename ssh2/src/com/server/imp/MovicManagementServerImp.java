package com.server.imp;

import javax.annotation.Resource;

import com.bean.MovicInfo;
import com.dao.interfaces.MovicManagementDao;
import com.server.interfaces.MovicManagementServer;

public class MovicManagementServerImp implements MovicManagementServer {

	@Resource
	private MovicManagementDao movicManagementDao;

	public boolean addMovic(MovicInfo movic) {
		
		return false;
	}

	
	public boolean deleteMovicByOid(int movicOid) {
	
		return false;
	}


	public boolean updateMovic(MovicInfo movic) {
	
		return false;
	}

	
	
}
