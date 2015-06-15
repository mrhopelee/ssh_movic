package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicDownload;
import com.dao.interfaces.MovicDownloadDao;
import com.server.interfaces.MovicDownloadServer;
@Transactional
public class MovicDownloadServerImp implements MovicDownloadServer {
	@Resource
	private MovicDownloadDao movicDownloadDao;

	public MovicDownloadDao getMovicDownloadDao() {
		return movicDownloadDao;
	}

	public void setMovicDownloadDao(MovicDownloadDao movicDownloadDao) {
		this.movicDownloadDao = movicDownloadDao;
	}


	public List getMovicDownloadByMovicOid(int movicOid) {
		
		return movicDownloadDao.getMovicDownloadByMovicOid(movicOid);
	}


	public boolean addMovicDownload(MovicDownload md) {
		
		return movicDownloadDao.addMovicDownload(md);
	}

	
	public MovicDownload getMovicDownloadByOid(int mdOid) {
		
		return movicDownloadDao.getMovicDownloadByOid(mdOid);
	}


	public boolean deleteMovicDownloadByOid(int mdOid) {
		
		return movicDownloadDao.deleteMovicDownloadByOid(mdOid);
	}
	

}
