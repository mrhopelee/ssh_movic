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

}
