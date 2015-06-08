package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.bean.MovicArea;
import com.bean.MovicInfo;
import com.bean.MovicType;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicManagementServer;

public class MovicManagementAction extends ActionSupport {
	/*这个类完成一下工作
	 * 1.添加电影 并 添加电影类型和电影地区记录
	 * */
	private List<MovicType> movicType;
	private List<MovicArea> movicArea;
	private MovicInfo movic;
	
	private int []mt=new int[3];//传值过来的电影类型
	private int []ma=new int[2];//传值过来的电影地区
	private int []score=new int[2];//传值过来的电影评分
	
	@Resource
	private MovicManagementServer movicManagementServer;

	public MovicManagementServer getMovicManagementServer() {
		return movicManagementServer;
	}

	public void setMovicManagementServer(MovicManagementServer movicManagementServer) {
		this.movicManagementServer = movicManagementServer;
	}
	
	
	
	public List<MovicType> getMovicType() {
		return movicType;
	}

	public void setMovicType(List<MovicType> movicType) {
		this.movicType = movicType;
	}

	public List<MovicArea> getMovicArea() {
		return movicArea;
	}

	public void setMovicArea(List<MovicArea> movicArea) {
		this.movicArea = movicArea;
	}
	
	
	
	public MovicInfo getMovic() {
		return movic;
	}

	public void setMovic(MovicInfo movic) {
		this.movic = movic;
	}

	public int[] getMt() {
		return mt;
	}

	public void setMt(int[] mt) {
		this.mt = mt;
	}

	public int[] getMa() {
		return ma;
	}

	public void setMa(int[] ma) {
		this.ma = ma;
	}
	

	public int[] getScore() {
		return score;
	}

	public void setScore(int[] score) {
		this.score = score;
	}

	public String goToAddMovicPage()
	{
		//获取电影类型 和电影地区 并传到添加电影页面上
		
		movicType= movicManagementServer.getMovicType();
		movicArea= movicManagementServer.getMovicArea();
		return "success";
		
	}
	
	public String addMovic()
	{
		//1.保存电影信息记录 并 返回电影id
		//2.添加电影类型记录
		//3.添加电影地区记录
		/*System.out.println(movic.getMovicName());
		System.out.println(movic.getMovicActor());
		System.out.println(movic.getMovicDirector());
		System.out.println(movic.getMovicIntroduction());
		System.out.println(movic.getMovicPlayDate());
		
		System.out.println(mt[0]);
		System.out.println(mt[1]);
		System.out.println(mt[2]);
		System.out.println(ma[0]);
		System.out.println(ma[1]);*/
		
		movic.setMovicImdbScore(new Double(score[0]+"."+score[1]));
		//System.out.println(movic.getMovicImdbScore());
		int movic_oid=movicManagementServer.addMovic(movic);
		
		
		return "success";
	}
	

}
