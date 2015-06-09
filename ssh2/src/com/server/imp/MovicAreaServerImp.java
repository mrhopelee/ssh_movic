package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicArea;
import com.dao.interfaces.MovicAreaDao;
import com.server.interfaces.MovicAreaServer;

@Transactional
public class MovicAreaServerImp implements MovicAreaServer {
	@Resource
	private MovicAreaDao movicareaDao;

	public MovicArea insertMovicAreaService(MovicArea movicarea) {

		return movicareaDao.insertMovicAreaDao(movicarea);
	}

	public MovicArea updateMovicAreaService(MovicArea movicarea) {

		return movicareaDao.updateMovicAreaDao(movicarea);
	}

	public void deleteMovicAreaService(MovicArea movicarea) {
		movicareaDao.deleteMovicAreaDao(movicarea);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<MovicArea> searchMovicAreaService(String whereSql) {

		return movicareaDao.searchMovicAreaDao(whereSql);
	}

}
