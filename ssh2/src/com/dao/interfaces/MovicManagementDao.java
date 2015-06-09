package com.dao.interfaces;

import java.util.List;

import com.bean.MovicInfo;
import com.bean.Paging;

public interface MovicManagementDao {
	public int addMovic(MovicInfo movic);
	public boolean deleteMovicByOid(int movicOid);
	public boolean updateMovic(MovicInfo movic);
	public List getMovicType();
	public List getMovicArea();
	public boolean addMovicType(int movic_oid,int type_oid);//添加电影类型记录
	public boolean addMovicArea(int movic_oid,int area_oid);//添加电影地区记录
	public int searchMovicOidByMovicName(String movic_name);
	public boolean addMovicVister(int movic_oid);//添加一条电影访问次数记录
	public List getAllMovic(Paging p);
	public int getMovicPaging();//获取分页信息
	public boolean deleteMovic(MovicInfo movic);//删除电影
}
