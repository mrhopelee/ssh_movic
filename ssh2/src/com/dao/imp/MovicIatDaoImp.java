package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.Paging;
import com.dao.interfaces.MovicIatDao;

public class MovicIatDaoImp implements MovicIatDao {
	@Resource
	private SessionFactory sessionFactory;

	public int getMovicPaging(String whereSql) {
		return sessionFactory.getCurrentSession().createQuery(whereSql).list()
				.size();
		/*return sessionFactory.getCurrentSession().createSQLQuery(whereSql).list()
				.size();*/
	}

	public List<?> searchMovicInfoDao(String whereSql, Paging paging) {

			int begin = (paging.getPageNow() - 1) * paging.getPageSize();
			int end = paging.getPageSize();
			
			 return sessionFactory.getCurrentSession()
			 .createQuery(whereSql).setFirstResult(begin).setMaxResults(end)
			 .list();
		 
		/*return sessionFactory.getCurrentSession().createSQLQuery(whereSql)
				.addEntity(MovicInfo.class).setFirstResult(begin)
				.setMaxResults(end).list();*/
	}

	public List<?> searchIndexMovicInfoDao(String whereSql) {
		return sessionFactory.getCurrentSession()
				 .createQuery(whereSql).setFirstResult(0).setMaxResults(6)
				 .list();
	}

}
