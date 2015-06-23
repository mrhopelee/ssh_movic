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

	@Override
	public int getPageCount(int nowMovieId, int pageSize) {
		int count = 0;
		int pageCount = 0;
		String hql = "select count(mcOid) from MovicComments where movicInfo.movicOid="+nowMovieId;
		
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			long temp = (Long) query.uniqueResult();
			count = (int) temp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(count%pageSize == 0){
			
			pageCount = count/pageSize;
		}else{
			pageCount = count/pageSize+1;
		}
		return pageCount;
	}

	@Override
	public List<MovicComments> selectListByMovieId(int nowMovieId, int pageNo,
			int pageSize) {
		List<MovicComments> list = null;
		String hql = "from MovicComments where movicInfo.movicOid="+nowMovieId+"order by commentsDate desc";
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult(pageSize*(pageNo-1));
			query.setMaxResults(pageSize);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
