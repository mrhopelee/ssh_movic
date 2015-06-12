package com.dao.interfaces;

import com.bean.UserInfo;

public interface UserDao {
	public boolean checkUser(UserInfo user);
	public UserInfo getUserInfo(String userName);//获取用户信息
}
