package com.bean;

import java.util.Date;

/**
 * UserSignIn entity. @author MyEclipse Persistence Tools
 */

public class UserSignIn implements java.io.Serializable {

	// Fields

	private Integer usOid;
	private UserInfo userInfo;
	private Date signinDate;

	// Constructors

	/** default constructor */
	public UserSignIn() {
	}

	/** full constructor */
	public UserSignIn(UserInfo userInfo, Date signinDate) {
		this.userInfo = userInfo;
		this.signinDate = signinDate;
	}

	// Property accessors

	public Integer getUsOid() {
		return this.usOid;
	}

	public void setUsOid(Integer usOid) {
		this.usOid = usOid;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Date getSigninDate() {
		return this.signinDate;
	}

	public void setSigninDate(Date signinDate) {
		this.signinDate = signinDate;
	}

}