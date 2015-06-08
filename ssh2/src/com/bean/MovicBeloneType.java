package com.bean;

/**
 * MovicBeloneType entity. @author MyEclipse Persistence Tools
 */

public class MovicBeloneType implements java.io.Serializable {

	// Fields

	private Integer mbaOid;
	private MovicInfo movicInfo;
	private MovicType movicType;

	// Constructors

	/** default constructor */
	public MovicBeloneType() {
	}

	/** full constructor */
	public MovicBeloneType(MovicInfo movicInfo, MovicType movicType) {
		this.movicInfo = movicInfo;
		this.movicType = movicType;
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

	public MovicType getMovicType() {
		return this.movicType;
	}

	public void setMovicType(MovicType movicType) {
		this.movicType = movicType;
	}

}