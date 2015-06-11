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
		System.out.printf("����UserManageAction Test����");
		user = userManageService.getUserById(21);
		if (user == null) {
			System.out.println("����Ϊ��");
		}
		request.getSession(true).setAttribute("user", user);//
	}
	
	public String updateUserMessage() {
		System.out.println("=============================");
		System.out.println("�����û����¸�����ϢAction");
		if (userSex.equals("1")) {
			userSex= "��";
		} else {
			userSex= "Ů";
		}
		boolean i = false;
		i=userManageService.updateUserMessage(userName,userDisplayName,userSex,userEmail);
		 if (i==true) {
				System.out.println("�޸ĸ�����Ϣ�ɹ�");
			}
		return "success";

	}

	public String updateUserPassword() {

		System.out.println("=============================");
		System.out.println("�����������Action");
		boolean i = false;
		 i=userManageService.updateUserPassword(userName,userPassword);
		 if (i == true) {
				System.out.println("�޸�����ɹ�");
			}
		return "success";

	}

	public String updateType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.printf("userOid=======" + userOid);
		System.out.printf("����UserManageAction updateType����");
		user = userManageService.getUserById(userOid);
		if (user == null) {
			System.out.println("����Ϊ��");
		}
		request.getSession(true).setAttribute("updateTypeUser", user);//
		// ����¼�û��洢��Session��
		return "success";

	}

	public String updateTypePage() {
		System.out.printf("userOid=======" + userOid);
		System.out.printf("����UserManageAction updateTypePage������");
		if (userManageService.editUserType(userName, Integer.parseInt(type)) == true) {
			System.out.println("�޸�Ȩ�޳ɹ�");
		}
		return "success";
	}

	public String deleteUser() {
		System.out.printf("����UserManageAction updateType����");
		System.out.printf("userOid=======" + userOid);
		boolean i = false;
		i = userManageService.deleteUserById(userOid);

		if (i == true) {
			System.out.println("ɾ���ɹ�");
		}

		return "success";
	}

	public String allUser() {
		HttpServletRequest request = ServletActionContext.getRequest();

		System.out.printf("����UserManageAction allUser����");
		ArrayList<UserInfo> allUser = (ArrayList<UserInfo>) userManageService
				.AllUser();
		if (allUser == null) {
			System.out.println("����Ϊ��");
		}
		request.getSession(true).setAttribute("allUser", allUser);// ����¼�û��洢��Session��
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

		System.out.println("�����޸��û�Ȩ��У�鷽��");
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

		System.out.println("�����޸��û���ϢУ�鷽��");
		this.clearErrors();
		/*if (!(userDisplayName.trim().equals(""))
				&& !Pattern.matches("\\w{5,12}", userDisplayName.trim())) {
			this.addFieldError("userDisplayName", "�������û�����������ĸ�����֣��ҳ��ȱ�����5��12λ֮�䣡");
		}*/
		// ������벻Ϊ�գ��Ҳ�ƥ�䳤��Ϊ4��25����ĸ��������ɵ��ַ���
		if (!userEmail.trim()
				.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			this.addFieldError("userEmail", "���䲻��һ���Ϸ����䣡");
		}
	}
	
	
	
	public void validateUpdateUserPassword() {

		System.out.println("�����޸��û�����У�鷽��");
		this.clearErrors();
		if (userPassword.trim().equals("")) {
			this.addFieldError("password", "���벻��Ϊ��");

		}
		if (rePassword.trim().equals("")) {
			this.addFieldError("rePassword", "�ظ����벻��Ϊ��");

		}
		// ������벻Ϊ�գ��Ҳ�ƥ�䳤��Ϊ4��25����ĸ��������ɵ��ַ�����
		if (!(userPassword.trim().equals(""))
				&& !Pattern.matches("\\w{5,15}", userPassword.trim())) {
			this.addFieldError("password", "�����������������ĸ�����֣��ҳ��ȱ�����5��15֮�䣡");
		}
		if (!(rePassword.trim().equals(""))
				&& !Pattern.matches("\\w{5,15}", rePassword.trim())) {
			this.addFieldError("rePassword", "�����������������ĸ�����֣��ҳ��ȱ�����5��15֮�䣡");
		}

		if (!(userPassword.trim().equals(rePassword.trim()))) {
			this.addFieldError("rePassword", "������������벻һ��");
		}

	}
	
	/*-------------------------------------------------------------------------------------
	*/
	
	
}
