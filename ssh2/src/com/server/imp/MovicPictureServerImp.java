package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicPicture;
import com.dao.interfaces.MovicPictureDao;
import com.server.interfaces.MovicPictureServer;

@Transactional
public class MovicPictureServerImp implements MovicPictureServer {
	@Resource
	private MovicPictureDao movicPictureDao;


	public List showMovicPicture(int movicOid) {
		
		return movicPictureDao.showMovicPicture(movicOid);
	}


	
	public boolean addMovicPicture(MovicPicture mp) {
		
		return movicPictureDao.addMovicPicture(mp);
	}



	@Override
	public boolean deletePicture(MovicPicture mp) {
		
		return movicPictureDao.deletePicture(mp);
	}

}
