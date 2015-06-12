package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicInfo;
import com.bean.MovicPicture;
import com.dao.interfaces.MovicPictureDao;

public class MovicPictureDaoImp implements MovicPictureDao {
	@Resource
	private SessionFactory sessionFactory;


	public List showMovicPicture(int movicOid) {
		/*
		 * private Integer mpOid;
	       private MovicInfo movicInfo;
	       private String picturePath;
	    */
		
		return sessionFactory.getCurrentSession().createQuery("from MovicPicture where  movicInfo.movicOid=?").setInteger(0,movicOid).list();
	}



	public boolean addMovicPicture(MovicPicture mp) {
		sessionFactory.getCurrentSession().save(mp);
		
		return true;
	}




	public boolean deletePicture(MovicPicture mp) {
		
		MovicPicture p=(MovicPicture) sessionFactory.getCurrentSession().load(MovicPicture.class,mp.getMpOid());
		sessionFactory.getCurrentSession().delete(p);
		return true;
	}

}
