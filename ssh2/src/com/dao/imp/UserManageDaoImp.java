package com.dao.imp;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bean.UserInfo;
import com.bean.UserType;
import com.dao.interfaces.UserManageDao;

/*
 * @author HuangLongChang
 */
public class UserManageDaoImp implements UserManageDao {

	@Resource
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean editUserType(String name, int type) {
		// TODO Auto-generated method stub
		System.out.println("进入UserManageDao-editUserType方法");
		try {
			UserInfo user = getUserByName(name);
			System.out
					.println("-----当前type=" + user.getUserType().getRemarks());
			user.getUserType().setValue(type);
			switch (type) {
			case 1:
				user.getUserType().setRemarks("普通用户");
				break;
			case 2:
				user.getUserType().setRemarks("会员用户");
				break;
			case 3:
				user.getUserType().setRemarks("普通管理员");
				break;
			case 4:
				user.getUserType().setRemarks("高级管理员");
				break;

			}
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			System.out.println("更新数据出错：" + e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserPassword(String userName, String userPassword) {
		// TODO Auto-generated method stub
		System.out.println("进入UserManageDao-updateUserPassword方法");
		try {
			UserInfo user = getUserByName(userName);
			user.setUserPassword(userPassword);
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			System.out.println("更新密码出错：" + e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserMessage(String userName, String userDisplayName,
			String userSex, String userEmail) {
		// TODO Auto-generated method stub
		System.out.println("进入UserManageDao-updateUserMessage方法");
		try {
			UserInfo user = getUserByName(userName);
			user.setUserDisplayName(userDisplayName);
			user.setUserEmail(userEmail);
			user.setUserSex(userSex);
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			System.out.println("更新个人信息出错：" + e);
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		System.out.println("进入删除用户DAO");
		try {
			UserInfo user = (UserInfo) sessionFactory.getCurrentSession().load(
					UserInfo.class, userId);
			sessionFactory.getCurrentSession().delete(user);
		} catch (Exception e) {
			System.out.println("删除数据出错：" + e);
			return false;
		}

		return true;
	}

	@Override
	public ArrayList AllUser() {
		// TODO Auto-generated method stub
		System.out.println("进入UserManageDao-AllUser方法");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserInfo");
		if (query.list() != null) {
			System.out.println("进入UserManageDao-AllUser方法，	结果不为空");
		}
		return (ArrayList<UserInfo>) query.list();

	}

	
	@Override
	public UserInfo getUserByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("进入UserManageDao-getUserByName方法");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserInfo where userName='" + name + "'");
		if (query.uniqueResult() != null) {
			System.out.println("调用根据用户Name查用户，有结果");
			UserInfo user = (UserInfo) query.uniqueResult();
			return user;
		} else
			return null;
	}

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		System.out.println("进入UserManageDao-getUserById方法");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserInfo where userOid='" + id + "'");
		if (query.uniqueResult() != null) {
			System.out.println("调用根据用户id查用户，有结果");
			UserInfo user = (UserInfo) query.uniqueResult();
			return user;
		} else
			return null;
	}

	

}
