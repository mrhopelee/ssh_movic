package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * UserType entity. @author MyEclipse Persistence Tools
 */

public class UserType implements java.io.Serializable {

	// Fields

	private Integer utOid;
	private Integer value;
	private String remarks;
	private Set userInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserType() {
	}

	/** full constructor */
	public UserType(Integer value, String remarks, Set userInfos) {
		this.value = value;
		this.remarks = remarks;
		this.userInfos = userInfos;
	}

	// Property accessors

	public Integer getUtOid() {
		return this.utOid;
	}

	public void setUtOid(Integer utOid) {
		this.utOid = utOid;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

}