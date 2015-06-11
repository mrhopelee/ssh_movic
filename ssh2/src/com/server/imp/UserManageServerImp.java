package com.server.imp;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bean.UserInfo;
import com.dao.interfaces.UserManageDao;
import com.server.interfaces.UserManageService;

/*
 * @author HuangLongChang
 */
@Transactional
public class UserManageServerImp implements UserManageService{

	@Resource
	private UserManageDao userManageDao;
	
	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return userManageDao.deleteUserById(userId);
	}
	
	@Override
	public ArrayList AllUser() {
		// TODO Auto-generated method stub
		return userManageDao.AllUser();
	}
	
	@Override
	public boolean editUserType(String name, int type) {
		// TODO Auto-generated method stub
		return userManageDao.editUserType(name,type);
	}

	@Override
	public UserInfo getUserByName(String name) {
		// TODO Auto-generated method stub
		return userManageDao.getUserByName(name);
	}

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		return userManageDao.getUserById(id);
	}

	@Override
	public  boolean updateUserPassword(String userName, String userPassword) {
		return userManageDao.updateUserPassword(userName,userPassword);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateUserMessage(String userName, String userDisplayName,
			String userSex, String userEmail) {
		// TODO Auto-generated method stub
		return userManageDao.updateUserMessage(userName,userDisplayName,userSex,userEmail);
	}





}
