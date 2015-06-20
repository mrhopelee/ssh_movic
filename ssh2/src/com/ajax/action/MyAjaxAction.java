package com.ajax.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bean.MovicBeloneArea;
import com.bean.MovicBeloneType;
import com.bean.MovicInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicManagementServer;

public class MyAjaxAction extends ActionSupport {
	private String result;//结果返回
	@Resource
	private MovicManagementServer movicManagementServer;
	private int movicOid;
	
	
	
	public MovicManagementServer getMovicManagementServer() {
		return movicManagementServer;
	}


	public void setMovicManagementServer(MovicManagementServer movicManagementServer) {
		this.movicManagementServer = movicManagementServer;
	}


	public int getMovicOid() {
		return movicOid;
	}


	public void setMovicOid(int movicOid) {
		this.movicOid = movicOid;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getinfo()
	{
		//数据集合必须new出来
		MovicInfo m=movicManagementServer.getMovicByOid(movicOid);
		//自定义电影类型 集合使用list
		//持久化对象转换为自定义对象
		MyMovicInfo movic=new MyMovicInfo();
		movic.setMovicOid(movicOid);
		movic.setMovicName(m.getMovicName());
		movic.setMovicActor(m.getMovicActor());
		movic.setMovicDirector(m.getMovicDirector());
		movic.setMovicIntroduction(m.getMovicIntroduction());
		movic.setMovicPost(m.getMovicPost());
		movic.setMovicImdbScore(m.getMovicImdbScore());
		
		Date playdate=m.getMovicPlayDate();
		movic.setMovicPlayDate((playdate.getYear()+1900)+"-"+(playdate.getMonth()+1)+"-"+playdate.getDate());
		
		Iterator it=m.getMovicBeloneAreas().iterator();
		
		while(it.hasNext())
		{
			MovicBeloneArea mba=(MovicBeloneArea) it.next();
			movic.getMovicBeloneAreas().add(mba.getMovicArea().getAreaName());
		}
		
		it=m.getMovicBeloneTypes().iterator();
		while(it.hasNext())
		{
			MovicBeloneType mbt=(MovicBeloneType) it.next();
			movic.getMovicBeloneTypes().add(mbt.getMovicType().getType());
		}
		
		
		
		
		
		System.out.println("对象转换");
		System.out.println(result);
		result=JSONObject.fromObject(movic).toString();
		return "success";
	}

}
