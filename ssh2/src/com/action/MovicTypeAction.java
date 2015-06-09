package com.action;

import java.util.List;

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
	String updateType;
	HttpServletRequest request = null;
	HttpSession hs = null;

	/*
	 * 
	 */
	public void validateInsertMovicType() {
		this.clearFieldErrors();
		if ((movictype.getType()).equals("")) {
			addFieldError("insertmt", "validate request: 类型不能为空");
		}
		super.validate();
	}

	public String insertMovicType() {
		MovicType newmovictype;
		movictype.setMtOid(null);
		try {
			newmovictype = movictypeserver.insertMovicTypeService(movictype);
		} catch (Exception e) {
			System.out.println(e + "insertMovicType function");
			addFieldError("insertmt", "无法添加，已存在此类型");
			newmovictype = null;
		} finally {
			movictype = null;
		}

		if (newmovictype != null) {
			return "success";
		} else {
			return "input";
		}
	}

	public String deleteMovicType() {
		try {
			String whereSql = "from MovicType as mt where mt.type=" + "'"
					+ movictype.getType() + "'";
			List<MovicType> list = (List<MovicType>) movictypeserver
					.searchMovicTypeService(whereSql);
			movictype.setMtOid(list.get(0).getMtOid());
			movictypeserver.deleteMovicTypeService(movictype);
		} catch (Exception e) {
			System.out.println(e + "updateMovicType function");
			addFieldError("deletemt", "删除失败");
			return "error";
		} finally {
			movictype = null;
		}
		return "success";
	}

	@SuppressWarnings("unchecked")
	public void validateUpdateMovicType() {
		this.clearFieldErrors();
		if (updateType.equals("")) {
			addFieldError("updatemt", "validate request: 请输入类型");
		} else {
			request = ServletActionContext.getRequest();
			hs = request.getSession(true);
			List<MovicType> list = (List<MovicType>) hs
					.getAttribute("movictypelist");
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i).getType()).equals(updateType)) {
					addFieldError("updatemt", "validate request: 无法修改，已存在此类型");
				}
			}
		}
		super.validate();
	}

	public String updateMovicType() {
		MovicType newmovictype;
		try {
			System.out.println(movictype.getType());
			String whereSql = "from MovicType as mt where mt.type=" + "'"
					+ movictype.getType() + "'";
			List<MovicType> list = (List<MovicType>) movictypeserver
					.searchMovicTypeService(whereSql);
			movictype.setMtOid(list.get(0).getMtOid());
			movictype.setType(updateType);
			newmovictype = movictypeserver.updateMovicTypeService(movictype);
		} catch (Exception e) {
			System.out.println(e + "updateMovicType function");
			addFieldError("updatemt", "更新失败");
			newmovictype = null;
		} finally {
			movictype = null;
		}
		if (newmovictype != null) {
			return "success";
		} else {
			return "input";
		}
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

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

}
