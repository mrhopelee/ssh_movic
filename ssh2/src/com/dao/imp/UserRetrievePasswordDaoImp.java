package com.dao.imp;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.UserInfo;
import com.bean.UserRetrievePassword;
import com.dao.interfaces.UserRetrievePasswordDao;

public class UserRetrievePasswordDaoImp implements UserRetrievePasswordDao {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public UserRetrievePassword checkEmailAndVerificationCode(String userEmail,
			String verificationCode) {
		
		return (UserRetrievePassword) sessionFactory.getCurrentSession().createQuery("from UserRetrievePassword where "
				+ "userInfo.userEmail=? and verificationCode=? ").setString(0,userEmail).setString(1,verificationCode).uniqueResult();
		
		
	}

	
	public UserRetrievePassword findBackUserOid(String userEmail,
			String verificationCode) {

		return (UserRetrievePassword) sessionFactory.getCurrentSession().createQuery("from UserRetrievePassword where "
				+ "userInfo.userEmail=? and verificationCode=? ").setString(0,userEmail).setString(1,verificationCode).uniqueResult();
		
	}

	
	public void finish(int urpOid) {
		UserRetrievePassword urp=(UserRetrievePassword) sessionFactory.getCurrentSession().load(UserRetrievePassword.class, urpOid);
		urp.setIsCheck(true);
		
	}

	
	public boolean alertURP(int userOid,String value) {
		
		UserRetrievePassword urp=(UserRetrievePassword) sessionFactory.getCurrentSession().createQuery("from UserRetrievePassword where "
				+ "userInfo.userOid=?").setInteger(0,userOid).uniqueResult();
		
		if(urp==null)
		{
			UserInfo userinfo=new UserInfo();
			userinfo.setUserOid(userOid);
			Date now=new Date();
			now.setHours(now.getHours()+1);
			
			
			Timestamp checkDate=new Timestamp(now.getTime());
			
			
			urp=new UserRetrievePassword();
			urp.setUserInfo(userinfo);
			urp.setIsCheck(false);
			urp.setVerificationCode(value);
			urp.setCheckDate(checkDate);
			sessionFactory.getCurrentSession().save(urp);

		}
		else
		{
			UserInfo userinfo=new UserInfo();
			userinfo.setUserOid(userOid);
			Date now=new Date();
			now.setHours(now.getHours()+1);
			
			
			Timestamp checkDate=new Timestamp(now.getTime());
			urp.setUserInfo(userinfo);
			urp.setIsCheck(false);
			urp.setVerificationCode(value);
			urp.setCheckDate(checkDate);
		}
		
		
		return true;
	}
	

}
