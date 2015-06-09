package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * MovicType entity. @author MyEclipse Persistence Tools
 */

public class MovicType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer mtOid;
	private String type;
	private Set<?> movicBeloneTypes = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public MovicType() {
	}

	/** minimal constructor */
	public MovicType(String type) {
		this.type = type;
	}

	/** full constructor */
	public MovicType(String type, Set<?> movicBeloneTypes) {
		this.type = type;
		this.movicBeloneTypes = movicBeloneTypes;
	}

	// Property accessors

	public Integer getMtOid() {
		return this.mtOid;
	}

	public void setMtOid(Integer mtOid) {
		this.mtOid = mtOid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<?> getMovicBeloneTypes() {
		return this.movicBeloneTypes;
	}

	public void setMovicBeloneTypes(Set<?> movicBeloneTypes) {
		this.movicBeloneTypes = movicBeloneTypes;
	}

}