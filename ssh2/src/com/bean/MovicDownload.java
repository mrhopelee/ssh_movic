package com.bean;

/**
 * MovicDownload entity. @author MyEclipse Persistence Tools
 */

public class MovicDownload implements java.io.Serializable {

	// Fields

	private Integer mdOid;
	private MovicInfo movicInfo;
	private String filePath;

	// Constructors

	/** default constructor */
	public MovicDownload() {
	}

	/** full constructor */
	public MovicDownload(MovicInfo movicInfo, String filePath) {
		this.movicInfo = movicInfo;
		this.filePath = filePath;
	}

	// Property accessors

	public Integer getMdOid() {
		return this.mdOid;
	}

	public void setMdOid(Integer mdOid) {
		this.mdOid = mdOid;
	}

	public MovicInfo getMovicInfo() {
		return this.movicInfo;
	}

	public void setMovicInfo(MovicInfo movicInfo) {
		this.movicInfo = movicInfo;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}