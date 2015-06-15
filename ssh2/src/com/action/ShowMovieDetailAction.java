package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicComments;
import com.bean.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.CountUserByScoreServiceInter;
import com.server.interfaces.FindCommentsServiceInter;


public class ShowMovieDetailAction extends ActionSupport {
	
	
	
	
	
	List<MovicComments> list = null;
	//记录评价为星星1到星星5各个级别的人数
	int[] score = new int[5];
	
	@Resource
	private FindCommentsServiceInter findCommentsService;   
	private MovicComments mComments;
	private int id;   //电影ID
	private int userId;   //用户ID
	@Resource 
	private CountUserByScoreServiceInter countUserByScoreService; 
	
	

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		//================显示3条评论  ---开始================
		
		
		list = findCommentsService.findPartComments(id);
		request.getSession().setAttribute("partCommentsList", list);
		request.getSession().setAttribute("nowMovieId", id);
		request.getSession().setAttribute("nowUserId", userId);
		//=================显示3条评论  ---结束===================
		
		
		//=================星星用户评价区 ----开始============
		for(int i=0; i<5;i++){

			score[i] = countUserByScoreService.countUserByScore(id,i+1);

		}
		
		request.getSession().setAttribute("userCountByScore", score);
		
		//=================星星用户评价区 ----结束============
		
		
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
