package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicArea;
import com.dao.interfaces.MovicAreaDao;

public class MovicAreaDaoImp implements MovicAreaDao {
	@Resource
	private SessionFactory sessionFactory;

	public MovicArea insertMovicAreaDao(MovicArea movicarea) {
		sessionFactory.getCurrentSession().persist(movicarea);
		return movicarea;
	}

	public MovicArea updateMovicAreaDao(MovicArea movicarea) {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().merge(movicarea);
		return movicarea;
	}

	public void deleteMovicAreaDao(MovicArea movicarea) {
		sessionFactory.getCurrentSession().delete(movicarea);
	}

	@SuppressWarnings("unchecked")
	public List<MovicArea> searchMovicAreaDao(String whereSql) {

		return (List<MovicArea>) sessionFactory.getCurrentSession()
				.createQuery(whereSql).list();
	}

}
