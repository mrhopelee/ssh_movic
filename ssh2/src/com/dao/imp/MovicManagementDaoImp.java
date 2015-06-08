package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicInfo;
import com.dao.interfaces.MovicManagementDao;

public class MovicManagementDaoImp implements MovicManagementDao {

	//该类是MovicManagementDao的实现类
	//作者梁泽民
	
	@Resource
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


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
