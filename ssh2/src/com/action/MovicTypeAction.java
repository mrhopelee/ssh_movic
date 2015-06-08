package com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicType;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicTypeServer;

public class MovicTypeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	MovicTypeServer movictypeserver;
	MovicType movictype;
	HttpServletRequest request = null;
	HttpSession hs = null;

	public String insertMovicType() {
		MovicType newmovictype;
		movictype.setMtOid(null);
		try {
			newmovictype = movictypeserver
					.insertMovicTypeService(movictype);
		} catch (Exception e) {
			System.out.println(e+"today123123");
			newmovictype = null;
		}

		if (newmovictype != null) {
			return "success";
		} else {
			addFieldError("type", "已存在此类型");
			return "input";
		}
	}

	public void validateInsertMovicType() {
		this.clearFieldErrors();
		if ((movictype.getType()).equals("")) {
			addFieldError("type", "类型不能为空");
		}
		super.validate();
	}

	public String movictypeSetSession() {
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("movictypelist");
		String whereSql = "from MovicType as mt order by mt.type desc";
		hs.setAttribute("movictypelist",
				movictypeserver.searchMovicTypeService(whereSql));
		return "success";
	}

	public MovicTypeServer getMovictypeserver() {
		return movictypeserver;
	}

	public void setMovictypeserver(MovicTypeServer movictypeserver) {
		this.movictypeserver = movictypeserver;
	}

	public MovicType getMovictype() {
		return movictype;
	}

	public void setMovictype(MovicType movictype) {
		this.movictype = movictype;
	}

}
