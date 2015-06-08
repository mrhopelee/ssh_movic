package com.dao.interfaces;

import java.util.List;

import com.bean.MovicInfo;

public interface MovicManagementDao {
	public int addMovic(MovicInfo movic);
	public boolean deleteMovicByOid(int movicOid);
	public boolean updateMovic(MovicInfo movic);
	public List getMovicType();
	public List getMovicArea();
	public boolean addMovicType(int movic_oid,int type_oid);//添加电影类型记录
	public boolean addMovicArea(int movic_oid,int area_oid);//添加电影地区记录
	public int searchMovicOidByMovicName(String movic_name);
}
