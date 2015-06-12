package com.server.interfaces;

import com.bean.UserInfo;

public interface UserServer {
	public boolean checkUser(UserInfo user);//验证用户是否存在 密码是否正确
	public UserInfo getUserInfo(String userName);//获取用户信息
	public boolean updateUserLogo(UserInfo user);//更新用户头像
	
}
