package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicDownload;
import com.bean.UserIntegral;
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

	
	public boolean isUserCanDownLoad(int userOid) {
		/*1.获取用户积分
		 * 2.判断用户是否拥有足够的积分
		 * 3.扣除用户积分
		 * */
		int cut=10;//扣掉的积分
		UserIntegral ui= movicDownloadDao.getUserIntegral(userOid);
		if(ui.getUserScore()<cut)
		{
			return false;
		}
		movicDownloadDao.updateUserIntegral(ui.getUintegralOid(), cut);
		return true;
	}
	

}
