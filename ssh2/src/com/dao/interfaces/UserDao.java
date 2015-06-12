package com.dao.interfaces;

import com.bean.UserInfo;

public interface UserDao {
	public boolean checkUser(UserInfo user);
	public UserInfo getUserInfo(String userName);//获取用户信息
	public boolean updateUserLogo(UserInfo user);//更新用户头像
}
