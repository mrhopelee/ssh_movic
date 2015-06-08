package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicInfo;
import com.dao.interfaces.MovicManagementDao;
import com.server.interfaces.MovicManagementServer;

@Transactional
public class MovicManagementServerImp implements MovicManagementServer {

	@Resource
	private MovicManagementDao movicManagementDao;

	public int addMovic(MovicInfo movic) {
		
		return movicManagementDao.addMovic(movic);
	}

	
	public boolean deleteMovicByOid(int movicOid) {
	
		return false;
	}


	public boolean updateMovic(MovicInfo movic) {
	
		return false;
	}


	
	public List getMovicType() {
		//获取电影类型
		return movicManagementDao.getMovicType();
	}



	public List getMovicArea() {
		//获取电影地区
		return movicManagementDao.getMovicArea();
	}



	public boolean addMovicType(int movic_oid, int type_oid) {
		
		return movicManagementDao.addMovicType(movic_oid, type_oid);
	}



	public boolean addMovicArea(int movic_oid, int type_oid) {
		
		return movicManagementDao.addMovicType(movic_oid, type_oid);
	}

	
	
}
