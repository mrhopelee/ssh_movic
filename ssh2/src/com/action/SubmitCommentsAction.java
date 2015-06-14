package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicComments;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.SubmitCommentsServiceInter;

/**
 *@authar 陈浩贤
 *
 **/

public class SubmitCommentsAction extends ActionSupport {
	
	@Resource
	private SubmitCommentsServiceInter submitCommentsService;
	private int score;    //用户评分
	private String comments_text;   //用户评论内容
	private int nowMoiveId;    //当前电影ID
	private int nowUserId;      //当前用户ID
	

	


	@Override
	public String execute() throws Exception {
		//MovicComments mComments = new MovicComments();
		//HttpServletRequest request = ServletActionContext.getRequest();
		//nowMoiveId=(int) request.getSession().getAttribute("nowMoiveId"); 
		//nowUserId = (int) request.getSession().getAttribute("nowUserId");
		
		if(submitCommentsService.checkUser(nowUserId)) {
			submitCommentsService.submitExecptScore(nowMoiveId, nowUserId, score, comments_text);
		}else{
			submitCommentsService.submitComments(nowMoiveId, nowUserId, score, comments_text);		
		}
		return SUCCESS;		
	}




	public SubmitCommentsServiceInter getSubmitCommentsService() {
		return submitCommentsService;
	}
	public void setSubmitCommentsService(
			SubmitCommentsServiceInter submitCommentsService) {
		this.submitCommentsService = submitCommentsService;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComments_text() {
		return comments_text;
	}
	public void setComments_text(String comments_text) {
		this.comments_text = comments_text;
	}




	public int getNowMoiveId() {
		return nowMoiveId;
	}




	public void setNowMoiveId(int nowMoiveId) {
		this.nowMoiveId = nowMoiveId;
	}




	public int getNowUserId() {
		return nowUserId;
	}




	public void setNowUserId(int nowUserId) {
		this.nowUserId = nowUserId;
	}


}
