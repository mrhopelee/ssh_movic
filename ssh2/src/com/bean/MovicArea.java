package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * MovicArea entity. @author MyEclipse Persistence Tools
 */

public class MovicArea implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8726282777549035466L;
	/**
	 * 
	 */
	// Fields

	private Integer areaOid;
	private String areaName;
	private Set<?> movicBeloneAreas = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public MovicArea() {
	}

	/** minimal constructor */
	public MovicArea(String areaName) {
		this.areaName = areaName;
	}

	/** full constructor */
	public MovicArea(String areaName, Set<?> movicBeloneAreas) {
		this.areaName = areaName;
		this.movicBeloneAreas = movicBeloneAreas;
	}

	// Property accessors

	public Integer getAreaOid() {
		return this.areaOid;
	}

	public void setAreaOid(Integer areaOid) {
		this.areaOid = areaOid;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Set<?> getMovicBeloneAreas() {
		return this.movicBeloneAreas;
	}

	public void setMovicBeloneAreas(Set<?> movicBeloneAreas) {
		this.movicBeloneAreas = movicBeloneAreas;
	}

}