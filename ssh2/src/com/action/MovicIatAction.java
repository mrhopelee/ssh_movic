package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.MovicArea;
import com.bean.MovicInfo;
import com.bean.MovicType;
import com.bean.Paging;
import com.server.interfaces.MovicIatServer;

public class MovicIatAction {
	@Resource
	private MovicIatServer movicIatServer;
	private MovicInfo movicinfo;
	private MovicArea movicarea;
	private MovicType movictype;
	private Paging paging;
	private HttpServletRequest request = null;
	private HttpSession hs = null;

	public Paging getMovicPaging(String whereSql) {
		int count = movicIatServer.getMovicPaging(whereSql);
		if (paging == null) {
			paging = new Paging();
		}

		paging.setRowCount(count);
		paging.setPageSize(5);// 设置一页有多少条记录
		paging.sumPageCount();
		paging.checkPageNow();

		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("moviciatpaging");
		hs.setAttribute("moviciatpaging", paging);
		return paging;
	}

	/*
	 * public String moviciatAllSetSession() { String whereSql =
	 * "SELECT mi.movicOid, mi.movicName, mi.movicImdbScore, mi.movicPlayDate, mi.movicPost "
	 * + "FROM MovicInfo as mi ORDER BY mi.movicPlayDate desc"; return
	 * moviciatSetSession(whereSql); }
	 */
	public String moviciatsetAT() {
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		if (movicarea == null) {
			movicarea = new MovicArea();
		}
		if (movicarea.getAreaName() == null
				|| movicarea.getAreaName().equals("不限")) {
			movicarea.setAreaName("");
			hs.removeAttribute("mastr");
			hs.setAttribute("mastr", movicarea.getAreaName());
		}
		if (hs.getAttribute("mastr").equals(movicarea.getAreaName())) {
		} else {
			hs.removeAttribute("mastr");
			hs.setAttribute("mastr", movicarea.getAreaName());
		}

		if (movictype == null) {
			movictype = new MovicType();
		}
		if (movictype.getType() == null || movictype.getType().equals("不限")) {
			movictype.setType("");
			hs.removeAttribute("mtstr");
			hs.setAttribute("mtstr", movictype.getType());
		}
		if (hs.getAttribute("mtstr").equals(movictype.getType())) {
		} else {
			hs.removeAttribute("mtstr");
			hs.setAttribute("mtstr", movictype.getType());
		}
		/*
		 * System.out.println(hs.getAttribute("mastr").toString() + " and " +
		 * hs.getAttribute("mtstr").toString());
		 */

		return "success";
	}

	public String moviciatMixSetSession() {
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		if (hs.getAttribute("mtstr") == null) {
			hs.setAttribute("mtstr", "");
		}
		if (hs.getAttribute("mastr") == null) {
			hs.setAttribute("mastr", "");
		}

		String whereSql = "SELECT mi.movicOid, mi.movicName, mi.movicImdbScore, mi.movicPlayDate, mi.movicPost"
				+ " FROM MovicInfo as mi,"
				+ " MovicBeloneArea as mba,"
				+ " MovicBeloneType as mbt,"
				+ " MovicArea as ma,"
				+ " MovicType as mt"
				+ " WHERE mba.movicInfo.movicOid  = mi.movicOid"
				+ " AND mba.movicArea.areaOid = ma.areaOid"
				+ " AND mbt.movicInfo.movicOid = mi.movicOid"
				+ " AND mbt.movicType.mtOid = mt.mtOid"
				+ " AND mt.type LIKE "
				+ "'%"
				+ hs.getAttribute("mtstr").toString()
				+ "%'"
				+ " AND ma.areaName LIKE "
				+ "'%"
				+ hs.getAttribute("mastr").toString()
				+ "%'"
				+ " GROUP BY mi.movicOid, mi.movicName, mi.movicImdbScore, mi.movicPlayDate, mi.movicPost"
				+ " ORDER BY mi.movicPlayDate desc";

		return moviciatSetSession(whereSql);

	}

	public String moviciatSetSession(String whereSql) {
		Paging newpaging = getMovicPaging(whereSql);
		List<MovicInfo> mi;
		if (newpaging.getPageCount() > 0) {
			mi = (List<MovicInfo>) movicIatServer
					.searchMovicInfoService(whereSql, newpaging);
		} else {
			mi = null;
		}
		/* System.out.println(mi.get(0).getMovicImdbScore()); */
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("moviciatlist");
		hs.setAttribute("moviciatlist", mi);
		if (hs.getAttribute("moviciatlist") != null) {
			return "success";
		} else {
			return "error";
		}
	}

	public MovicIatServer getMovicIatServer() {
		return movicIatServer;
	}

	public void setMovicIatServer(MovicIatServer movicIatServer) {
		this.movicIatServer = movicIatServer;
	}

	public MovicInfo getMovicinfo() {
		return movicinfo;
	}

	public void setMovicinfo(MovicInfo movicinfo) {
		this.movicinfo = movicinfo;
	}

	public MovicArea getMovicarea() {
		return movicarea;
	}

	public void setMovicarea(MovicArea movicarea) {
		this.movicarea = movicarea;
	}

	public MovicType getMovictype() {
		return movictype;
	}

	public void setMovictype(MovicType movictype) {
		this.movictype = movictype;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
