package com.dao.interfaces;

import java.util.ArrayList;

import com.bean.UserInfo;

/*
 * @author HuangLongChang
 */
public interface UserManageDao {

	public boolean deleteUserById(int userId);

	public ArrayList AllUser();

	public boolean editUserType(String name, int type);

	public UserInfo getUserByName(String name);

	public UserInfo getUserById(int id);

	public boolean updateUserPassword(String userName, String userPassword);

	public boolean updateUserMessage(String userName, String userDisplayName,
			String userSex, String userEmail);

}
