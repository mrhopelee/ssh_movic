package com.dao.interfaces;

import java.util.List;

import com.bean.MovicDownload;

public interface MovicDownloadDao {
	public List getMovicDownloadByMovicOid(int movicOid);//根据电影id获取电影下载列表
	public boolean addMovicDownload(MovicDownload md);
	public MovicDownload getMovicDownloadByOid(int mdOid);//获取电影下载记录
	public boolean deleteMovicDownloadByOid(int mdOid);
}
