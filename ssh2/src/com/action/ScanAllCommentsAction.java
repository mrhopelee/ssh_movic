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
	private int pageNo = 1;   //页码
	private int pageSize = 6; // 每页显示评论数
	private int pageCount ;    //总页数


	@Override
	public String execute() throws Exception {
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		int nowMovieId = (int)request.getSession().getAttribute("nowMovieId");
		//获得总页数
		pageCount = findCommentsService.getPageCount(nowMovieId,pageSize);
		//
		List<MovicComments> allList = findCommentsService.selectListByMovieId(nowMovieId,pageNo,pageSize,pageCount);
		
		
		/**
		 * 
		List<MovicComments> allList = findCommentsService.selectAllComments(nowMovieId);	
		*/
		request.setAttribute("allList", allList);

		//request.setAttribute("nowMovieId", id);
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
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
