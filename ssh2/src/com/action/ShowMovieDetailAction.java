package com.action;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicArea;
import com.bean.MovicBeloneArea;
import com.bean.MovicBeloneType;
import com.bean.MovicComments;
import com.bean.MovicInfo;
import com.bean.MovicType;
import com.bean.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.CountUserByScoreServiceInter;
import com.server.interfaces.FindCommentsServiceInter;
import com.server.interfaces.MovicManagementServer;


public class ShowMovieDetailAction extends ActionSupport {
	
	
	
	
	
	List<MovicComments> list = null;
	//记录评价为星星1到星星5各个级别的人数
	int[] score = new int[5];
	
	
	@Resource
	private FindCommentsServiceInter findCommentsService;   
	private MovicComments mComments;
	private int id;   //电影ID
	@Resource 
	private CountUserByScoreServiceInter countUserByScoreService; 
	@Resource
	private MovicManagementServer movicManagementServer;
	private MovicInfo movic;
	private List<MovicType> mt;
	private List<MovicArea> ma;
	

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		//================显示3条评论  ---开始================
		
		
		list = findCommentsService.findPartComments(id);
		request.getSession().setAttribute("partCommentsList", list);
		request.getSession().setAttribute("nowMovieId", id);
		//request.getSession().setAttribute("nowUserId", userId);
		//=================显示3条评论  ---结束===================
		
		
		//=================星星用户评价区 ----开始============
		for(int i=0; i<5;i++){

			score[i] = countUserByScoreService.countUserByScore(id,i+1);
			
		}
		
		request.getSession().setAttribute("userCountByScore", score);
		
		//=================星星用户评价区 ----结束============
		movicManagementServer.addMovicVisiterNumber(id);
		movic=movicManagementServer.getMovicByOid(id);
		//获取电影类型
		//电影访问量+1
		
		return SUCCESS;
		
	}
	
	
	
	public MovicComments getmComments() {
		return mComments;
	}
	public void setmComments(MovicComments mComments) {
		this.mComments = mComments;
	}
	public FindCommentsServiceInter getFindCommentsService() {
		return findCommentsService;
	}
	public void setFindCommentsService(FindCommentsServiceInter findCommentsService) {
		this.findCommentsService = findCommentsService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CountUserByScoreServiceInter getCountUserByScoreService() {
		return countUserByScoreService;
	}
	public void setCountUserByScoreService(
			CountUserByScoreServiceInter countUserByScoreService) {
		this.countUserByScoreService = countUserByScoreService;
	}



	public MovicManagementServer getMovicManagementServer() {
		return movicManagementServer;
	}



	public void setMovicManagementServer(MovicManagementServer movicManagementServer) {
		this.movicManagementServer = movicManagementServer;
	}



	public MovicInfo getMovic() {
		return movic;
	}



	public void setMovic(MovicInfo movic) {
		this.movic = movic;
	}



	public List<MovicType> getMt() {
		return mt;
	}



	public void setMt(List<MovicType> mt) {
		this.mt = mt;
	}



	public List<MovicArea> getMa() {
		return ma;
	}



	public void setMa(List<MovicArea> ma) {
		this.ma = ma;
	}
	
	

}
