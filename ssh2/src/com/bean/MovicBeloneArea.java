package com.bean;

/**
 * MovicBeloneArea entity. @author MyEclipse Persistence Tools
 */

public class MovicBeloneArea implements java.io.Serializable {

	// Fields

	private Integer mbaOid;
	private MovicInfo movicInfo;
	private MovicArea movicArea;

	// Constructors

	/** default constructor */
	public MovicBeloneArea() {
	}

	/** full constructor */
	public MovicBeloneArea(MovicInfo movicInfo, MovicArea movicArea) {
		this.movicInfo = movicInfo;
		this.movicArea = movicArea;
	}

	// Property accessors

	public Integer getMbaOid() {
		return this.mbaOid;
	}

	public void setMbaOid(Integer mbaOid) {
		this.mbaOid = mbaOid;
	}

	public MovicInfo getMovicInfo() {
		return this.movicInfo;
	}

	public void setMovicInfo(MovicInfo movicInfo) {
		this.movicInfo = movicInfo;
	}

	public MovicArea getMovicArea() {
		return this.movicArea;
	}

	public void setMovicArea(MovicArea movicArea) {
		this.movicArea = movicArea;
	}

}