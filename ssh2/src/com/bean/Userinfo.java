package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Usertype usertype;
	private String username;
	private String displayname;
	private String userpassword;
	private Set postresponses = new HashSet(0);
	private Set posts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String username, String displayname, String userpassword) {
		this.username = username;
		this.displayname = displayname;
		this.userpassword = userpassword;
	}

	/** full constructor */
	public Userinfo(Usertype usertype, String username, String displayname,
			String userpassword, Set postresponses, Set posts) {
		this.usertype = usertype;
		this.username = username;
		this.displayname = displayname;
		this.userpassword = userpassword;
		this.postresponses = postresponses;
		this.posts = posts;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Usertype getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Set getPostresponses() {
		return this.postresponses;
	}

	public void setPostresponses(Set postresponses) {
		this.postresponses = postresponses;
	}

	public Set getPosts() {
		return this.posts;
	}

	public void setPosts(Set posts) {
		this.posts = posts;
	}

}