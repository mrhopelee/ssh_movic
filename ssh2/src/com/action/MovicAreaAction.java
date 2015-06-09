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
	MovicArea movicarea;
	String updateArea;
	HttpServletRequest request = null;
	HttpSession hs = null;
	MovicArea newmovicarea = null;

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

	public String deleteMovicArea() {
		try {
			String whereSql = "from MovicArea as ma where ma.areaName=" + "'"
					+ movicarea.getAreaName() + "'";
			List<MovicArea> list = (List<MovicArea>) movicareaServer
					.searchMovicAreaService(whereSql);
			movicarea.setAreaOid(list.get(0).getAreaOid());
			movicareaServer.deleteMovicAreaService(movicarea);
		} catch (Exception e) {
			System.out.println(e + "deleteMovicType function");
			addFieldError("deletemt", "删除失败");
			return "error";
		} finally {
			movicarea = null;
		}
		return "success";
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

	public String movicareaSetSession() {

		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("movictypelist");
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