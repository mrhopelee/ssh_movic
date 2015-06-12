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

	public String moviciatAllSetSession() {
		String whereSql = "from MovicInfo order by movicPlayDate desc";
		return moviciatSetSession(whereSql);
	}
	
	public String moviciatMixSetSession(){
		String whereSql = "from MovicInfo order by movicPlayDate desc";
		return moviciatSetSession(whereSql);
		/*select MovicInfo.movic_name, MovicInfo.movic_play_date, MovicInfo.movic_director
		From MovicInfo,MovicBeloneArea,MovicBeloneType,MovicType,MovicArea
		where MovicBeloneArea.movic_oid=MovicInfo.movic_oid 
			and MovicBeloneArea.area_oid=MovicArea.area_oid
			and MovicBeloneType.movic_oid=MovicInfo.movic_oid
			and MovicBeloneType.type_oid=MovicType.mt_oid
			and MovicType.type like '奇幻'
			and MovicArea.area_name like '%'
			group by MovicInfo.movic_name, MovicInfo.movic_play_date, MovicInfo.movic_director
			order by MovicInfo.movic_play_date desc*/
	}

	public String moviciatSetSession(String whereSql) {
		Paging newpaging = getMovicPaging(whereSql);
		List<MovicInfo> mi = (List<MovicInfo>) movicIatServer
				.searchMovicInfoService(whereSql, newpaging);
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
