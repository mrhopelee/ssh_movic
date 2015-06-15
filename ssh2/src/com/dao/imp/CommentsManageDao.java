package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.MovicComments;
import com.dao.interfaces.CommentsManageDaoInter;

/**
 *@authar 陈浩贤
 *
 **/

public class CommentsManageDao implements CommentsManageDaoInter {
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<MovicComments> selectList() {
		List<MovicComments> clist = null;
		String hql = "from MovicComments";
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			clist = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clist;
	}
	
	@Override
	public void deleteComments(Integer mcOid) {
		try {
			MovicComments movieComments = (MovicComments) sessionFactory.getCurrentSession().load(MovicComments.class,mcOid);
			sessionFactory.getCurrentSession().delete(movieComments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<MovicComments> selectUserCommentsByUserId(Integer userOid) {
		List<MovicComments> userCommList = null;
		String hql = "from MovicComments where userInfo.userOid="+userOid;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			userCommList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	@Override
	public void delCommentsByUserId(Integer userOid) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			MovicComments mComments = (MovicComments) session.load(MovicComments.class, userOid);
			session.delete(mComments);
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
