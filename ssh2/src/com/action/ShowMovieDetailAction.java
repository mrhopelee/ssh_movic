package com.action;






import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicComments;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.FindCommentsServiceInter;

/**
 *@authar �º���
 *
 **/

public class ShowMovieDetailAction extends ActionSupport {
	
	
	
	
	//ʵ������۵�List����
	List<MovicComments> list = null;
	@Resource
	private FindCommentsServiceInter findCommentsService;
	private MovicComments mComments;
	

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String movieOid = request.getParameter("movicOid");
		int id = Integer.parseInt(movieOid);
		//HttpServletRequest request = ServletActionContext.getRequest();
		list = findCommentsService.findPartComments(id);
		request.setAttribute("partCommentsList", list);
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

	
	

}
