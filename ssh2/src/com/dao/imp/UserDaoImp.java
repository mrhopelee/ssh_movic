package com.dao.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.UserInfo;
import com.bean.UserIntegral;
import com.bean.UserType;
import com.dao.interfaces.UserDao;

public class UserDaoImp implements UserDao {

	@Resource
	private SessionFactory sessionFactory;
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}




	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	public boolean checkUser(UserInfo user) {
		
		UserInfo u=(UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where userName=? and userPassword=?").setString(0, user.getUserName()).setString(1, user.getUserPassword()).uniqueResult();
		if(u==null)
		{
			return false;
		}
		return true;
	}





	public UserInfo getUserInfo(String userName) {
		
		UserInfo u=(UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo where userName=?").setString(0, userName).uniqueResult();
		
		return u;
	}




	@Override
	public boolean updateUserLogo(UserInfo user) {
		UserInfo u=(UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class, user.getUserOid());
		u.setUserLogo(user.getUserLogo());
		
		return false;
	}




	public int rigisterUser(UserInfo user) {
		
			UserType ut=new UserType();
			ut.setUtOid(0);
			user.setUserType(ut);
			int i=(int) sessionFactory.getCurrentSession().save(user);
			return i;
		
	}




	public boolean addUserIntegral(UserInfo user) {
		
		try
		{
		UserIntegral ui=new UserIntegral() ;
		ui.setUserScore(0);
		ui.setUserInfo(user);
		sessionFactory.getCurrentSession().save(ui);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
			
	}

	public UserInfo getUser(int userid) {
	
		return (UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class,userid);
	}

}
