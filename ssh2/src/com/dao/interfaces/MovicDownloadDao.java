package com.dao.interfaces;

import java.util.List;

import com.bean.MovicDownload;
import com.bean.UserIntegral;

public interface MovicDownloadDao {
	public List getMovicDownloadByMovicOid(int movicOid);//根据电影id获取电影下载列表
	public boolean addMovicDownload(MovicDownload md);
	public MovicDownload getMovicDownloadByOid(int mdOid);//获取电影下载记录
	public boolean deleteMovicDownloadByOid(int mdOid);
	public UserIntegral getUserIntegral(int userOid);//获取用户积分
	public boolean updateUserIntegral(int uiOid,int cut);//扣除用户积分
}
