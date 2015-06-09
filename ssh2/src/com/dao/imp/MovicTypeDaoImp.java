package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicType;
import com.dao.interfaces.MovicTypeDao;

/**
 * 
 * @author lihao
 *
 */
public class MovicTypeDaoImp implements MovicTypeDao {
	@Resource
	private SessionFactory sessionFactory;

	public MovicType insertMovicTypeDao(MovicType movictype) {
		/* try { */
		sessionFactory.getCurrentSession().persist(movictype);
		/*
		 * } catch (Exception e) { System.out.println(e+"fuck"); return null; }
		 */
		return movictype;
	}

	public MovicType updateMovicTypeDao(MovicType movictype) {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().merge(movictype);
		return movictype;
	}

	public void deleteMovicTypeDao(MovicType movictype) {
		sessionFactory.getCurrentSession().delete(movictype);
	}

	@SuppressWarnings("unchecked")
	public List<MovicType> searchMovicTypeDao(String whereSql) {

		return (List<MovicType>) sessionFactory.getCurrentSession()
				.createQuery(whereSql).list();
	}

}
