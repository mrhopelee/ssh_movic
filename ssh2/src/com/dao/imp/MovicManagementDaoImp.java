package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicInfo;
import com.dao.interfaces.MovicManagementDao;

public class MovicManagementDaoImp implements MovicManagementDao {

	
	
	@Resource
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public int addMovic(MovicInfo movic) {
		
		try
		{
			sessionFactory.getCurrentSession().save(movic);
		}
		catch(Exception e)
		{
			return 0;
		}
		//获取添加电影信息后的电影oid 值
		
		MovicInfo mid= (MovicInfo) sessionFactory.getCurrentSession().createQuery("from MovicInfo where movicName=?").setString(0,movic.getMovicName()).uniqueResult();
		
		return mid.getMovicOid();
	}


	public boolean deleteMovicByOid(int movicOid) {
	
		return false;
	}


	public boolean updateMovic(MovicInfo movic) {
	
		return false;
	}


	
	public List getMovicType() {

		
		return sessionFactory.getCurrentSession().createQuery("from MovicType").list();
	}


	@Override
	public List getMovicArea() {
		
		return sessionFactory.getCurrentSession().createQuery("from MovicArea").list();
	}



	public boolean addMovicType(int movic_oid, int type_oid) {
		
		return false;
	}


	
	public boolean addMovicArea(int movic_oid, int type_oid) {
		
		return false;
	}
	

}
