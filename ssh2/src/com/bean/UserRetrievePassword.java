package com.bean;

import java.sql.Timestamp;

/**
 * UserRetrievePassword entity. @author MyEclipse Persistence Tools
 */

public class UserRetrievePassword implements java.io.Serializable {

	// Fields

	private Integer urpOid;
	private UserInfo userInfo;
	private Timestamp checkDate;
	private String verificationCode;
	private Boolean isCheck;

	// Constructors

	/** default constructor */
	public UserRetrievePassword() {
	}

	/** full constructor */
	public UserRetrievePassword(UserInfo userInfo, Timestamp checkDate,
			String verificationCode, Boolean isCheck) {
		this.userInfo = userInfo;
		this.checkDate = checkDate;
		this.verificationCode = verificationCode;
		this.isCheck = isCheck;
	}

	// Property accessors

	public Integer getUrpOid() {
		return this.urpOid;
	}

	public void setUrpOid(Integer urpOid) {
		this.urpOid = urpOid;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Timestamp getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	public String getVerificationCode() {
		return this.verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Boolean getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

}