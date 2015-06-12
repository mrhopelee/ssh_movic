package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bean.MovicComments;
import com.dao.interfaces.FindCommentsDaoInter;

/**
 *@authar ³ÂºÆÏÍ
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
		String hql = "from MovicComments where movicInfo.movicOid="+id+"order by commentsDate";
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(5);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sessionFactory.close();
		}

		return list;
	}

}
