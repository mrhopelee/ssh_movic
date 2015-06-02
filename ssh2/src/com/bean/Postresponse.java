package com.bean;

import java.sql.Timestamp;

/**
 * Postresponse entity. @author MyEclipse Persistence Tools
 */

public class Postresponse implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Post post;
	private Userinfo userinfo;
	private Timestamp responsedate;
	private String responseinfo;

	// Constructors

	/** default constructor */
	public Postresponse() {
	}

	/** minimal constructor */
	public Postresponse(Timestamp responsedate, String responseinfo) {
		this.responsedate = responsedate;
		this.responseinfo = responseinfo;
	}

	/** full constructor */
	public Postresponse(Post post, Userinfo userinfo, Timestamp responsedate,
			String responseinfo) {
		this.post = post;
		this.userinfo = userinfo;
		this.responsedate = responsedate;
		this.responseinfo = responseinfo;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Timestamp getResponsedate() {
		return this.responsedate;
	}

	public void setResponsedate(Timestamp responsedate) {
		this.responsedate = responsedate;
	}

	public String getResponseinfo() {
		return this.responseinfo;
	}

	public void setResponseinfo(String responseinfo) {
		this.responseinfo = responseinfo;
	}

}