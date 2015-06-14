package com.server.imp;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.UserInfo;
import com.dao.interfaces.UserDao;
import com.server.interfaces.UserServer;

@Transactional
public class UserServerImp implements UserServer {

	@Resource
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public boolean checkUser(UserInfo user) {
		
		return userDao.checkUser(user);
	}


	@Override
	public UserInfo getUserInfo(String userName) {
		
		return userDao.getUserInfo(userName);
	}


	@Override
	public boolean updateUserLogo(UserInfo user) {
		
		return userDao.updateUserLogo(user);
	}


	//添加用户的同时 添加一条用户积分记录
	public int rigisterUser(UserInfo user) {
		
		return userDao.rigisterUser(user);
		
	}


	
	public UserInfo getUser(int userid) {
		
		return userDao.getUser(userid);
	}


	@Override
	public boolean addUserIntegral(UserInfo user) {
		
		return userDao.addUserIntegral(user);
	}


	

}
