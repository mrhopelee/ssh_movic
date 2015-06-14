package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.IntegralManageService;
import com.server.interfaces.UserManageService;

/*
 * @author HuangLongChang
 */
public class IntegralManageAction extends ActionSupport {

	@Resource
	private UserManageService userManageService;

	@Resource
	private IntegralManageService integralManageService;

	private String userName;
	private String userScore;
	
	

	public String upgradeToVip(){
		System.out.println("=============================");
		System.out.println("进入积分管理页面Action-----升级会员");
		boolean i = false;
		UserInfo user = new UserInfo();
		user = userManageService.getUserByName(userName);
		
		if (userManageService.editUserType(userName,2) == true) {
			System.out.println("修改权限成功");
		}
	
		if (integralManageService.addIntegral(user,-999)== true) {
			System.out.println("恭喜你，，积分---999点");
		}
		//更新httpsession 中的user信息
		HttpSession session= ServletActionContext.getRequest().getSession();
		user = userManageService.getUserByName(userName);
		session.setAttribute("user",user);
		
		return "success";
		
	}
	
	public void validateUpgradeToVip(){
		System.out.println("进入修改用户升级VIP校验方法");
		this.clearErrors();
		int i=Integer.parseInt(userScore);
		if (i<999) {
			this.addFieldError("score", "积分够999分才可升级为尊贵会员喔亲!");
		}
		UserInfo user = new UserInfo();
		user = userManageService.getUserByName(userName);

		if(user.getUserType().getValue()==2){
			this.addFieldError("score", "您已经是尊贵会员了喔亲!");
			}
		
	}
	
	public String signBoard() {
		System.out.println("=============================");
		System.out.println("进入积分管理页面Action-----每日签到");
		boolean i = false;
		UserInfo user = new UserInfo();
		user = userManageService.getUserByName(userName);
		i = integralManageService.checkSiginBoard(user);
		if (i == true) {
			System.out.println("今天有资格签到");
			i = integralManageService.siginBoard(user);
			if (i == true) {
				i=integralManageService.addIntegral(user,10);
				System.out.println("恭喜你，签到成功，积分增加10点");
				//更新httpsession 中的user信息
				HttpSession session= ServletActionContext.getRequest().getSession();
				user = userManageService.getUserByName(userName);
				session.setAttribute("user",user);
			}
			return "success";
		} 
		else {
			return "error";
		}
	}

	public IntegralManageService getIntegralManageService() {
		return integralManageService;
	}

	public void setIntegralManageService(
			IntegralManageService integralManageService) {
		this.integralManageService = integralManageService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public UserManageService getUserManageService() {
		return userManageService;
	}


	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}


	public String getUserScore() {
		return userScore;
	}


	public void setUserScore(String userScore) {
		this.userScore = userScore;
	}


}
