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

	/*
	 * 分页 getMovicPaging()方法 根据whereSql执行查询，得到结果总数count
	 * 用结果总数count和setPageSize(int i)方法进行分页， 得到： 一共有paging.rowCount 部电影 每页
	 * paging.pageSize部 分有paging.pageCount 页 并初始化paging.pageNow(当前页)在第1 页（或第0页）
	 * 最后把paging对象存入httpsession
	 */
	public Paging getMovicPaging(String whereSql) {
		int count = movicIatServer.getMovicPaging(whereSql);
		if (paging == null) {
			paging = new Paging();
		}

		paging.setRowCount(count);
		paging.setPageSize(5);// 设置每页 paging.pageSize部 电影
		paging.sumPageCount();
		paging.checkPageNow();

		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("moviciatpaging");
		hs.setAttribute("moviciatpaging", paging);
		return paging;
	}

	/*
	 * 设置地区与类型 moviciatsetAT()方法 获取存入httpsession的movicarea对象和movictype对象
	 * 根据用户点击的连接设置对应的类型或地区
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

		return "success";
	}

	/*
	 * 设置whereSql moviciatMixSetSession()方法
	 * 获取存入httpsession的movicarea对象和movictype对象
	 * 动态改变whereSql语句，从而得到想要的查询结果(xx地区xx类型的电影) 后面还要增加按时间或按评分排序
	 */
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

	/*
	 * 分页，查询 moviciatSetSession() moviciatMixSetSession()方法传入whereSql语句
	 * 分页：getMovicPaging()方法得到paging 查询：根据paging与whereSql执行查询
	 */
	public String moviciatSetSession(String whereSql) {
		Paging newpaging = getMovicPaging(whereSql);
		List<MovicInfo> mi;
		if (newpaging.getPageCount() > 0) {
			mi = (List<MovicInfo>) movicIatServer.searchMovicInfoService(
					whereSql, newpaging);
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
