package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicDownload;
import com.dao.interfaces.MovicDownloadDao;

public class MovicDownloadDaoImp implements MovicDownloadDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public List getMovicDownloadByMovicOid(int movicOid) {
		
		return sessionFactory.getCurrentSession().createQuery("from MovicDownload where movicInfo.movicOid=?").setInteger(0,movicOid).list();
	}

	
	public boolean addMovicDownload(MovicDownload md) {
		
		  sessionFactory.getCurrentSession().save(md);
		  return true;
	}


	public MovicDownload getMovicDownloadByOid(int mdOid) {
	
		return (MovicDownload) sessionFactory.getCurrentSession().load(MovicDownload.class, mdOid);
	}

	
	public boolean deleteMovicDownloadByOid(int mdOid) {
		
		MovicDownload md=(MovicDownload) sessionFactory.getCurrentSession().load(MovicDownload.class, mdOid);
		sessionFactory.getCurrentSession().delete(md);
		
		return  true;
	}
	
	

}
