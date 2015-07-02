package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.dao.interfaces.CountUserByScoreDaoInter;

/**
 *@authar 陈浩贤
 *
 **/

public class CountUserByScoreDao implements CountUserByScoreDaoInter {
	
	@Resource
	private SessionFactory sessionFactory;
	

	@Override
	public int countUserByScore(int id, int i) {
		int num = 0;
		String hql = "select count(usmOid) from UserScoreMovic where movicInfo.movicOid="+id+"and score="+i;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			long temp = (Long) query.uniqueResult();
			num = (int) temp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
