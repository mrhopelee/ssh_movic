package com.dao.imp;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bean.UserInfo;
import com.bean.UserIntegral;
import com.bean.UserSignIn;
import com.dao.interfaces.IntegralManageDao;
import com.server.interfaces.UserManageService;

/*
 * @author HuangLongChang
 */
public class IntegralManageDaoImp implements IntegralManageDao {

	@Resource
	private SessionFactory sessionFactory;
	
	
	@Override
	public UserIntegral getUserIntegralByUser(UserInfo user) {
		// TODO Auto-generated method stub
		System.out.println("进入IntegralManageDaoImp-getUserIntegralByUser方法");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserIntegral where userInfo=?");
		query.setParameter(0, user);
		if (query.list().size()!=0) {
			System.out.println("调用根据用户查积分条目，有结果");
			UserIntegral userIntegral = (UserIntegral) query.uniqueResult();
			return userIntegral;
		} else
			return null;
	}

	@Override
	public boolean addIntegral(UserInfo user, int integral) {
		// TODO Auto-generated method stub
		System.out.println("进入IntegralManageDaoImp-addIntegral方法");
		
		System.out.println(user.getUserOid());
		System.out.println(integral);
		try {
		UserIntegral ui=getUserIntegralByUser(user);
		ui.setUserInfo(user);
		ui.setUserScore(ui.getUserScore()+integral);
		System.out.println(ui.getUserScore());
		System.out.println(ui.getUserInfo().getUserName());
	/*	if(getUserIntegralByUser(user)!=null){
			sessionFactory.getCurrentSession().update(ui);
			
		}
		else{
			sessionFactory.getCurrentSession().save(ui);
		}*/
		sessionFactory.getCurrentSession().update(ui);
		} catch (Exception e) {
			System.out.println("积分增加失败：" + e);
			return false;
		}
		System.out.println("积分增加成功：" );
		return true;
	}

	
	@Override
	public boolean signBoard(UserInfo user) {

		// TODO Auto-generated method stub
		System.out.println("进入IntegralManageDaoImp-signBoard方法");
		try {
			UserSignIn usi = new UserSignIn();
			usi.setUserInfo(user);
			usi.setSigninDate(new Date());
			sessionFactory.getCurrentSession().save(usi);
			
		} catch (Exception e) {
			System.out.println("签到失败：" + e);
			return false;
		}
		return true;

	}

	@Override
	public boolean checkSiginBoard(UserInfo user) {
		// TODO Auto-generated method stub
		System.out.println("进入IntegralManageDaoImp-checkSiginBoard方法");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserSignIn where userInfo.userOid=? and signinDate=?");
		query.setInteger(0, user.getUserOid());
		Date date = new Date();
		query.setDate(1, date);
		// System.out.println(query.list().size());

		if (query.list().size() != 0) {
			System.out.println("调用根据用户查签到表，有结果");
			return false;
		} else {
			System.out.println("调用根据用户查签到表，没有结果");
			return true;
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
