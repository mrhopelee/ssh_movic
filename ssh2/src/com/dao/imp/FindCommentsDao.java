package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bean.MovicComments;
import com.dao.interfaces.FindCommentsDaoInter;

/**
 *@authar �º���
 *
 **/

public class FindCommentsDao implements FindCommentsDaoInter {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<MovicComments> findPartComments(int id) {
		
		List<MovicComments> list = null;
		String hql = "from MovicComments where movicInfo.movicOid="+id+"order by mcOid";
		//String hql = "from MovicComments order by mcOid";
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(3);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<MovicComments> selectAllComments(Integer id) {
		List<MovicComments> allList = null;
		
		String hql = "from MovicComments where movicInfo.movicOid="+id+"order by mcOid";
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			allList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allList;
	}

}
