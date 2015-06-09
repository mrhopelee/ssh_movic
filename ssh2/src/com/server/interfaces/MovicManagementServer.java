package com.server.interfaces;

import java.util.List;

import com.bean.MovicInfo;
import com.bean.Paging;

public interface MovicManagementServer {
	public int addMovic(MovicInfo movic);//添加电影
	public boolean deleteMovicByOid(int movicOid);//删除电影
	public boolean updateMovic(MovicInfo movic);//更新电影
	public List getMovicType();//获取电影类型
	public List getMovicArea();//获取电影地区
	public boolean addMovicType(int movic_oid,int type_oid);//添加电影类型记录
	public boolean addMovicArea(int movic_oid,int area_oid);//添加电影地区记录
	public int searchMovicOidByMovicName(String movic_name);
	public boolean addMovicVister(int movic_oid);//添加一条电影访问次数记录
	public List getAllMovic(Paging p);//根据分页类获取分页内容
	public int getMovicPaging();//获取分页信息
	public boolean deleteMovic(MovicInfo movic);
}
