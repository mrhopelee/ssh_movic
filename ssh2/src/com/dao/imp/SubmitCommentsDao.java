package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bean.MovicComments;
import com.bean.UserScoreMovic;
import com.dao.interfaces.SubmitCommentsDaoInter;

/**
 *@authar 陈浩贤
 *
 **/

public class SubmitCommentsDao implements SubmitCommentsDaoInter {
	@Resource
	private SessionFactory sessionFactory;
	
	

	@Override
	public boolean checkUser(int nowUserId,int movicOid) {
		//int count = 0;
		//String hql = "select count(usmOid) from UserScoreMovic where userInfo.userOid="+nowUserId;
		//List<UserScoreMovic> list = null;
		UserScoreMovic usm=null;
		try {
			//list = sessionFactory.getCurrentSession().createQuery(hql).list();
			Query query = sessionFactory.getCurrentSession().createQuery("from UserScoreMovic where userInfo.userOid=? and movicInfo.movicOid=?")
					.setInteger(0,nowUserId).setInteger(1, movicOid);
			
			 usm=(UserScoreMovic) query.uniqueResult();
			//long temp = (Long) query.uniqueResult();
			//count = (int) temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(usm!=null) return true;
		else			
			return false;
	}



	@Override
	public void addComments(MovicComments mComments) {
		try {
			sessionFactory.getCurrentSession().save(mComments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void addScore(UserScoreMovic uScore) {
		try {
			sessionFactory.getCurrentSession().save(uScore);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




}
