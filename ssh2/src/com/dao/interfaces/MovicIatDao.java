package com.dao.interfaces;

import java.util.List;

import com.bean.MovicInfo;
import com.bean.Paging;

public interface MovicIatDao {
	public int getMovicPaging(String whereSql);// 获取分页信息

	public List<MovicInfo> searchMovicInfoDao(String whereSql, Paging paging);
}
