package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicInfo;
import com.bean.Paging;
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



	public boolean addMovicArea(int movic_oid, int area_oid) {
		
		return movicManagementDao.addMovicArea(movic_oid, area_oid);
	}



	public int searchMovicOidByMovicName(String movic_name) {
		
		return movicManagementDao.searchMovicOidByMovicName(movic_name);
	}



	public boolean addMovicVister(int movic_oid) {
		
		return movicManagementDao.addMovicVister(movic_oid);
	}


	//获取所有电影信息 并分页
	public List getAllMovic(Paging p) {
		// TODO Auto-generated method stub
		               
		return movicManagementDao.getAllMovic(p);
	}


	//获取分页信息
	public int getMovicPaging() {
		// TODO Auto-generated method stub
		return movicManagementDao.getMovicPaging();
	}



	public boolean deleteMovic(MovicInfo movic) {
		
		return movicManagementDao.deleteMovic(movic);
	}

	
	
}
