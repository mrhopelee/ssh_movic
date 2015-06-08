package com.dao.interfaces;

import com.bean.MovicInfo;

public interface MovicManagementDao {
	public boolean addMovic(MovicInfo movic);//添加电影信息
	public boolean deleteMovicByOid(int movicOid);//删除电影根据电影oid
	public boolean updateMovic(MovicInfo movic);//更新电影信息
}
