package com.bean;

/**
 * MovicBeloneType entity. @author MyEclipse Persistence Tools
 */

public class MovicBeloneType implements java.io.Serializable {

	// Fields

	private Integer mbtOid;
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

	public Integer getMbtOid() {
		return this.mbtOid;
	}

	public void setMbtOid(Integer mbtOid) {
		this.mbtOid = mbtOid;
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