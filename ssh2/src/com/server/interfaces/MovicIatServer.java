package com.server.interfaces;

import java.util.List;

import com.bean.MovicInfo;
import com.bean.Paging;

public interface MovicIatServer {
	public String getWhereSql(String search, String type, String area,
			String sort);

	public int getMovicPaging(String whereSql);// 获取分页信息

	public List<MovicInfo> searchMovicInfoService(String whereSql, Paging paging);

}
