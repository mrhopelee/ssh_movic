package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicInfo;
import com.bean.Paging;
import com.dao.interfaces.MovicIatDao;

public class MovicIatDaoImp implements MovicIatDao {
	@Resource
	private SessionFactory sessionFactory;

	public int getMovicPaging(String whereSql) {
		return sessionFactory.getCurrentSession().createQuery(whereSql).list()
				.size();
	}

	@SuppressWarnings("unchecked")
	public List<MovicInfo> searchMovicInfoDao(String whereSql, Paging paging) {
		int begin = (paging.getPageNow() - 1) * paging.getPageSize();
		int end = paging.getPageSize();
		return (List<MovicInfo>) sessionFactory.getCurrentSession()
				.createQuery(whereSql).setFirstResult(begin).setMaxResults(end)
				.list();
	}

}
