package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicComments;
import com.bean.UserInfo;
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
	//private int nowUserId;      //当前用户ID
	

	


	@Override
	public String execute() throws Exception {
		//MovicComments mComments = new MovicComments();
		HttpServletRequest request = ServletActionContext.getRequest();
		//nowMoiveId=(int) request.getSession().getAttribute("nowMoiveId"); 
		//nowUserId = (int) request.getSession().getAttribute("nowUserId");
		if(request.getSession().getAttribute("user")==null){
			this.addFieldError("tt","请登录");
			return INPUT;
		}
		
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
		nowMoiveId=(int) request.getSession().getAttribute("nowMovieId");
		
		System.out.println("nowMoiveId="+nowMoiveId);
		
		if(submitCommentsService.checkUser(userInfo.getUserOid())) {
			submitCommentsService.submitExecptScore(nowMoiveId, userInfo.getUserOid(), score, comments_text);
		}else{
			submitCommentsService.submitComments(nowMoiveId, userInfo.getUserOid(), score, comments_text);		
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



}
