package com.action;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.UserInfo;
import com.bean.UserType;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.UserManageService;

/*
 * @author HuangLongChang
 */
public class UserManageAction extends ActionSupport {
	private Integer userOid;
	private String userName;
	private String userPassword;
	private String rePassword;

	private String userDisplayName;
	private String userSex;
	private String userLogo;
	private String userEmail;
	private String type;

	private UserType userType;
	private UserInfo user;

	@Resource
	private UserManageService userManageService;

	
	//=================================================================================================================
	public void test() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//System.out.printf("userOid=======" + userOid);
		System.out.printf("进入UserManageAction Test方法");
		user = userManageService.getUserById(21);
		if (user == null) {
			System.out.println("数据为空");
		}
		request.getSession(true).setAttribute("user", user);//
	}
	
	public String updateUserMessage() {
		System.out.println("=============================");
		System.out.println("进入用户更新个人信息Action");
		if (userSex.equals("1")) {
			userSex= "男";
		} else {
			userSex= "女";
		}
		boolean i = false;
		i=userManageService.updateUserMessage(userName,userDisplayName,userSex,userEmail);
		 if (i==true) {
				System.out.println("修改个人信息成功");
			}
		return "success";

	}

	public String updateUserPassword() {

		System.out.println("=============================");
		System.out.println("进入更新密码Action");
		boolean i = false;
		 i=userManageService.updateUserPassword(userName,userPassword);
		 if (i == true) {
				System.out.println("修改密码成功");
			}
		return "success";

	}

	public String updateType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.printf("userOid=======" + userOid);
		System.out.printf("进入UserManageAction updateType方法");
		user = userManageService.getUserById(userOid);
		if (user == null) {
			System.out.println("数据为空");
		}
		request.getSession(true).setAttribute("updateTypeUser", user);//
		// 将登录用户存储至Session中
		return "success";

	}

	public String updateTypePage() {
		System.out.printf("userOid=======" + userOid);
		System.out.printf("进入UserManageAction updateTypePage处理方法");
		if (userManageService.editUserType(userName, Integer.parseInt(type)) == true) {
			System.out.println("修改权限成功");
		}
		return "success";
	}

	public String deleteUser() {
		System.out.printf("进入UserManageAction updateType方法");
		System.out.printf("userOid=======" + userOid);
		boolean i = false;
		i = userManageService.deleteUserById(userOid);

		if (i == true) {
			System.out.println("删除成功");
		}

		return "success";
	}

	public String allUser() {
		HttpServletRequest request = ServletActionContext.getRequest();

		System.out.printf("进入UserManageAction allUser方法");
		ArrayList<UserInfo> allUser = (ArrayList<UserInfo>) userManageService
				.AllUser();
		if (allUser == null) {
			System.out.println("数据为空");
		}
		request.getSession(true).setAttribute("allUser", allUser);// 将登录用户存储至Session中
		return "success";
	}
	
	
	
	/*-------------------------------------------------------------------------------------
	*/
	

	public UserManageService getUserManageService() {
		return userManageService;
	}

	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}

	public Integer getUserOid() {
		return userOid;
	}

	public void setUserOid(Integer userOid) {
		this.userOid = userOid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserLogo() {
		return userLogo;
	}

	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	
	
	/*-------------------------------------------------------------------------------------
	*/
	
	
	
	
	public void validateUpdateTypePage() {

		System.out.println("进入修改用户权限校验方法");
		this.clearErrors();
		if (type.trim().equals("")) {
			this.addFieldError("type", "Not null");

		}
		if (!(type.trim().equals("1")) && !(type.trim().equals("2"))
				&& !(type.trim().equals("3")) && !(type.trim().equals("4"))) {
			this.addFieldError("type", "In(1~4)Num");

		}

	}
	
	

	public void validateUpdateUserMessage() {

		System.out.println("进入修改用户信息校验方法");
		this.clearErrors();
		/*if (!(userDisplayName.trim().equals(""))
				&& !Pattern.matches("\\w{5,12}", userDisplayName.trim())) {
			this.addFieldError("userDisplayName", "您输入用户名必须是字母和数字，且长度必须是5到12位之间！");
		}*/
		// 如果密码不为空，且不匹配长度为4～25的字母和数字组成的字符串
		if (!userEmail.trim()
				.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			this.addFieldError("userEmail", "邮箱不是一个合法邮箱！");
		}
	}
	
	
	
	public void validateUpdateUserPassword() {

		System.out.println("进入修改用户密码校验方法");
		this.clearErrors();
		if (userPassword.trim().equals("")) {
			this.addFieldError("password", "密码不能为空");

		}
		if (rePassword.trim().equals("")) {
			this.addFieldError("rePassword", "重复密码不能为空");

		}
		// 如果密码不为空，且不匹配长度为4～25的字母和数字组成的字符串。
		if (!(userPassword.trim().equals(""))
				&& !Pattern.matches("\\w{5,15}", userPassword.trim())) {
			this.addFieldError("password", "您输入密码必须是字母和数字，且长度必须是5到15之间！");
		}
		if (!(rePassword.trim().equals(""))
				&& !Pattern.matches("\\w{5,15}", rePassword.trim())) {
			this.addFieldError("rePassword", "您输入密码必须是字母和数字，且长度必须是5到15之间！");
		}

		if (!(userPassword.trim().equals(rePassword.trim()))) {
			this.addFieldError("rePassword", "两次输入的密码不一致");
		}

	}
	
	/*-------------------------------------------------------------------------------------
	*/
	
	
}
