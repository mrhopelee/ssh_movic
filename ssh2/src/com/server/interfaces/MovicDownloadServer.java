package com.server.interfaces;

import java.util.List;

import com.bean.MovicDownload;

public interface MovicDownloadServer {
	public List getMovicDownloadByMovicOid(int movicOid);//根据电影id获取电影下载列表
	public boolean addMovicDownload(MovicDownload md);
	public MovicDownload getMovicDownloadByOid(int mdOid);
	public boolean deleteMovicDownloadByOid(int mdOid);
	public boolean isUserCanDownLoad(int userOid);//判断用户是否拥有足够的积分下载电影
}
