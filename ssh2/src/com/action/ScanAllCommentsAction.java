package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.jni.Mmap;

import com.bean.MovicComments;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.FindCommentsServiceInter;

/**
 *@authar 陈浩贤
 *
 **/

public class ScanAllCommentsAction extends ActionSupport {
	
	
	@Resource
	private FindCommentsServiceInter findCommentsService;
	
	private MovicComments mComments;
	private int id;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<MovicComments> allList = findCommentsService.selectAllComments(id);
		request.setAttribute("allList", allList);
		return SUCCESS ;
	}

	
	
	
	
	
	public FindCommentsServiceInter getFindCommentsService() {
		return findCommentsService;
	}

	public void setFindCommentsService(FindCommentsServiceInter findCommentsService) {
		this.findCommentsService = findCommentsService;
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
	
	

}
