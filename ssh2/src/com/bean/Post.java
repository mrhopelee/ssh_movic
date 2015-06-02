package com.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Post entity. @author MyEclipse Persistence Tools
 */

public class Post implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Userinfo userinfo;
	private String posttitle;
	private String postinfo;
	private Timestamp posttime;
	private Integer renum;
	private Set postresponses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** minimal constructor */
	public Post(String posttitle, Timestamp posttime) {
		this.posttitle = posttitle;
		this.posttime = posttime;
	}

	/** full constructor */
	public Post(Userinfo userinfo, String posttitle, String postinfo,
			Timestamp posttime, Integer renum, Set postresponses) {
		this.userinfo = userinfo;
		this.posttitle = posttitle;
		this.postinfo = postinfo;
		this.posttime = posttime;
		this.renum = renum;
		this.postresponses = postresponses;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getPosttitle() {
		return this.posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostinfo() {
		return this.postinfo;
	}

	public void setPostinfo(String postinfo) {
		this.postinfo = postinfo;
	}

	public Timestamp getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Timestamp posttime) {
		this.posttime = posttime;
	}

	public Integer getRenum() {
		return this.renum;
	}

	public void setRenum(Integer renum) {
		this.renum = renum;
	}

	public Set getPostresponses() {
		return this.postresponses;
	}

	public void setPostresponses(Set postresponses) {
		this.postresponses = postresponses;
	}

}