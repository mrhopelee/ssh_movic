package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicDownload;
import com.bean.UserIntegral;
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


	public UserIntegral getUserIntegral(int userOid) {
		
		
		return (UserIntegral) sessionFactory.getCurrentSession().createQuery("from UserIntegral where userInfo.userOid=?").setInteger(0,userOid).uniqueResult();
	}

	
	public boolean updateUserIntegral(int uiOid, int cut) {
		UserIntegral ui=(UserIntegral) sessionFactory.getCurrentSession().load(UserIntegral.class,uiOid);
		ui.setUserScore(ui.getUserScore()-cut);
		//积分减去
		return false;
	}
	
	

}
