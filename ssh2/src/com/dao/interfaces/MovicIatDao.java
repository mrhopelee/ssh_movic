package com.dao.interfaces;

import java.util.List;

import com.bean.Paging;

public interface MovicIatDao {
	public int getMovicPaging(String whereSql);// 获取分页信息

	public List<?> searchMovicInfoDao(String whereSql, Paging paging);
}
