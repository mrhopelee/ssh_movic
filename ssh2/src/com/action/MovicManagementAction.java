package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.bean.MovicArea;
import com.bean.MovicInfo;
import com.bean.MovicType;
import com.bean.Paging;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicManagementServer;

public class MovicManagementAction extends ActionSupport {
	/*这个类完成一下工作
	 * 1.添加电影 并 添加电影类型和电影地区记录
	 * 
	 * 
	 * */
	private List<MovicInfo> movicInfo;//这是用来保存获取的所有电影信息
	private List<MovicType> movicType;
	private List<MovicArea> movicArea;
	private MovicInfo movic;
	
	private int []mt=new int[3];//传值过来的电影类型
	private int []ma=new int[2];//传值过来的电影地区
	private int []score=new int[2];//传值过来的电影评分
	
	private Paging paging;
	
	@Resource
	private MovicManagementServer movicManagementServer;

	
	public List<MovicInfo> getMovicInfo() {
		return movicInfo;
	}

	public void setMovicInfo(List<MovicInfo> movicInfo) {
		this.movicInfo = movicInfo;
	}

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

	
	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
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
		//4.添加电影访问记录
		
		//设置电影评分 设置电影海报
		movic.setMovicImdbScore(new Double(score[0]+"."+score[1]));
		movic.setMovicPost("null");
		
		int movic_oid=movicManagementServer.addMovic(movic);
		
		if(movic_oid==0)
		{
			addFieldError("movic_name", "电影名已存在");
			return "input";
		}
		movic_oid=movicManagementServer.searchMovicOidByMovicName(movic.getMovicName());
		
		
		int i;
		for(i=0;i<3;i++)
		{
			if(mt[i]>=0)
			{
				movicManagementServer.addMovicType(movic_oid, mt[i]);
			}
		}
		
		for(i=0;i<2;i++)
		{
			if(ma[i]>=0)
			{
				movicManagementServer.addMovicArea(movic_oid,ma[i]);
			}
		}
		movicManagementServer.addMovicVister(movic_oid);
	
		return "success";
	}
	
	//该方法用来获取分页信息
	private void getMovicPaging()
	{
		paging.setRowCount(movicManagementServer.getMovicPaging());
		paging.setPageSize(10);//设置一页有多少条记录
		paging.sumPageCount();
		paging.checkPageNow();
		
	}
	
	//该方法用来获取所有电影的信息
	public String getAllMovic()
	{
		getMovicPaging();
		//System.out.println(paging.getPageCount()+" "+paging.getRowCount());
		
		movicInfo=movicManagementServer.getAllMovic(paging);
		//System.out.println(movicInfo.size());
		
		return "success";
	}
	
	public String deleteMovic()
	{
		System.out.println("movic_id="+movic.getMovicOid());
		movicManagementServer.deleteMovic(movic);
		this.getAllMovic();
		return "success";
	}
	

}
