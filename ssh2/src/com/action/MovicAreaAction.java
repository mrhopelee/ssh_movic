package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicArea;
import com.opensymphony.xwork2.ActionSupport;
import com.server.interfaces.MovicAreaServer;

public class MovicAreaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private MovicAreaServer movicareaServer;
	private MovicArea movicarea;
	private String updateArea;
	private HttpServletRequest request = null;
	private HttpSession hs = null;
	private MovicArea newmovicarea = null;

	/*
	 * 增加地区验证，增加地区
	 */
	public void validateInsertMovicArea() {
		this.clearFieldErrors();
		if ((movicarea.getAreaName()).equals("")) {
			addFieldError("insertma", "validate request: 地区不能为空");
		}
		super.validate();
	}

	public String insertMovicArea() {

		movicarea.setAreaOid(null);
		try {
			newmovicarea = movicareaServer.insertMovicAreaService(movicarea);
		} catch (Exception e) {
			System.out.println(e);
			addFieldError("insertma", "无法添加，已存在此地区");
			newmovicarea = null;
		} finally {
			movicarea = null;
		}

		if (newmovicarea != null) {
			return "success";
		} else {
			return "input";
		}
	}

	/*
	 * 删除地区
	 */
	public String deleteMovicArea() {
		System.out.println("deleteMovicArea");
		try {
			String whereSql = "from MovicArea as ma where ma.areaName=" + "'"
					+ movicarea.getAreaName() + "'";
			List<MovicArea> list = (List<MovicArea>) movicareaServer
					.searchMovicAreaService(whereSql);
			movicarea = list.get(0);
			movicareaServer.deleteMovicAreaService(movicarea);
		} catch (Exception e) {
			System.out.println(e + "deleteMovicType function");
			addFieldError("deletema", "删除失败");
			return "error";
		} finally {
			movicarea = null;
		}
		return "success";
	}

	/*
	 * 修改地区验证，修改地区
	 */
	@SuppressWarnings("unchecked")
	public void validateUpdateMovicArea() {
		this.clearFieldErrors();
		if (movicarea.getAreaName().endsWith(" ")) {
			addFieldError("updatema", "validate request: 请选择地区");
		} else if (updateArea.equals("")) {
			addFieldError("updatema", "validate request: 请输入地区");
		} else {
			request = ServletActionContext.getRequest();
			hs = request.getSession(true);
			List<MovicArea> list = (List<MovicArea>) hs
					.getAttribute("movicarealist");
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i).getAreaName()).equals(updateArea)) {
					addFieldError("updatema", "validate request: 无法修改，已存在此地区");
				}
			}
		}
		super.validate();
	}

	public String updateMovicArea() {
		try {
			String whereSql = "from MovicArea as ma where ma.areaName=" + "'"
					+ movicarea.getAreaName() + "'";
			List<MovicArea> list = (List<MovicArea>) movicareaServer
					.searchMovicAreaService(whereSql);
			movicarea.setAreaOid(list.get(0).getAreaOid());
			movicarea.setAreaName(updateArea);
			newmovicarea = movicareaServer.updateMovicAreaService(movicarea);
		} catch (Exception e) {
			System.out.println(e);
			addFieldError("insertma", "无法添加，已存在此地区");
			newmovicarea = null;
		} finally {
			movicarea = null;
		}
		if (newmovicarea != null) {
			return "success";
		} else {
			return "error";
		}
	}

	/*
	 * 获取所有地区
	 */
	public String movicareaSetSession() {
		// System.out.println("area");
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("movicarealist");
		String whereSql = "from MovicArea as ma order by ma.areaName desc";
		hs.setAttribute("movicarealist",
				movicareaServer.searchMovicAreaService(whereSql));
		return "success";
	}

	public String getUpdateArea() {
		return updateArea;
	}

	public void setUpdateArea(String updateArea) {
		this.updateArea = updateArea;
	}

	public MovicAreaServer getMovicareaServer() {
		return movicareaServer;
	}

	public void setMovicareaServer(MovicAreaServer movicareaServer) {
		this.movicareaServer = movicareaServer;
	}

	public MovicArea getMovicarea() {
		return movicarea;
	}

	public void setMovicarea(MovicArea movicarea) {
		this.movicarea = movicarea;
	}

}
