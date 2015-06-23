package com.ajax.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyMovicInfo {
	private Integer movicOid;
	private String movicName;
	private String movicActor;
	private String movicDirector;
	private Double movicImdbScore;
	private String movicPlayDate;
	private String movicIntroduction;
	private String movicPost;
	private int movicVisiterNumbers;
	
	private List movicBeloneTypes = new ArrayList<String>();
	private List movicBeloneAreas = new ArrayList<String>();
	public Integer getMovicOid() {
		return movicOid;
	}
	public void setMovicOid(Integer movicOid) {
		this.movicOid = movicOid;
	}
	public String getMovicName() {
		return movicName;
	}
	public void setMovicName(String movicName) {
		this.movicName = movicName;
	}
	public String getMovicActor() {
		return movicActor;
	}
	public void setMovicActor(String movicActor) {
		this.movicActor = movicActor;
	}
	public String getMovicDirector() {
		return movicDirector;
	}
	public void setMovicDirector(String movicDirector) {
		this.movicDirector = movicDirector;
	}
	public Double getMovicImdbScore() {
		return movicImdbScore;
	}
	public void setMovicImdbScore(Double movicImdbScore) {
		this.movicImdbScore = movicImdbScore;
	}
	public String getMovicPlayDate() {
		return movicPlayDate;
	}
	public void setMovicPlayDate(String movicPlayDate) {
		this.movicPlayDate = movicPlayDate;
	}
	public String getMovicIntroduction() {
		return movicIntroduction;
	}
	public void setMovicIntroduction(String movicIntroduction) {
		this.movicIntroduction = movicIntroduction;
	}
	public String getMovicPost() {
		return movicPost;
	}
	public void setMovicPost(String movicPost) {
		this.movicPost = movicPost;
	}
	public int getMovicVisiterNumbers() {
		return movicVisiterNumbers;
	}
	public void setMovicVisiterNumbers(int movicVisiterNumbers) {
		this.movicVisiterNumbers = movicVisiterNumbers;
	}
	public List getMovicBeloneTypes() {
		return movicBeloneTypes;
	}
	public void setMovicBeloneTypes(List movicBeloneTypes) {
		this.movicBeloneTypes = movicBeloneTypes;
	}
	public List getMovicBeloneAreas() {
		return movicBeloneAreas;
	}
	public void setMovicBeloneAreas(List movicBeloneAreas) {
		this.movicBeloneAreas = movicBeloneAreas;
	}
	
	


}
