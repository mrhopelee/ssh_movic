package com.dao.interfaces;

import com.bean.UserInfo;

public interface UserDao {
	public boolean checkUser(UserInfo user);
	public UserInfo getUserInfo(String userName);//获取用户信息
	public boolean updateUserLogo(UserInfo user);//更新用户头像
	public int rigisterUser(UserInfo user);//添加新用户 返回用户id
	public UserInfo getUser(int userid);//根据用户id获取用户信息
	public boolean addUserIntegral(UserInfo user);//添加用户积分记录
}
