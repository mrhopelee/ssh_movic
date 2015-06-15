package com.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicComments;
import com.bean.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.CommentsManageServiceInter;

/**
 *@authar �º���
 *
 **/

public class CommentsManageAction extends ActionSupport {
	
	
    private int id;
	private MovicComments mComments;
	@Resource
	private CommentsManageServiceInter commentsManageService;
	
	
	public CommentsManageServiceInter getCommentsManageService() {
		return commentsManageService;
	}


	public void setCommentsManageService(
			CommentsManageServiceInter commentsManageService) {
		this.commentsManageService = commentsManageService;
	}
	public MovicComments getmComments() {
		return mComments;
	}

	public void setmComments(MovicComments mComments) {
		this.mComments = mComments;
	}
	
	

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<MovicComments> clist = commentsManageService.selectList();
		request.setAttribute("clist", clist);
		return "clist";
	}
	
	public String delComments(){
		
		//System.out.println(id);
		commentsManageService.delectComments(id);
		return SUCCESS;
	}
	
	public String getUserComments(){
		HttpServletRequest request = ServletActionContext.getRequest();
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");  //获取当前用户
		List<MovicComments> uCommList = commentsManageService.getComments(user.getUserOid());    //获取当前用户的评论
		request.setAttribute("uCommList", uCommList);
		return "ok";
	}
	
	public String delUserComments(){
		HttpServletRequest request = ServletActionContext.getRequest();
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");  //获取当前用户
		commentsManageService.delCommentsByUser(user.getUserOid());
		return "delete";
	}

	
	
	

	
}
