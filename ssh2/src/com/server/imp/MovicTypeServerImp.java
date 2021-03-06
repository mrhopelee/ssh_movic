/**
 * 
 */
package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicType;
import com.dao.interfaces.MovicTypeDao;
import com.server.interfaces.MovicTypeServer;

/**
 * 
 * @author lihao
 *
 */
@Transactional
public class MovicTypeServerImp implements MovicTypeServer {
	@Resource
	private MovicTypeDao movictypeDao;

	public MovicType insertMovicTypeService(MovicType movictype) {
		/* try { */

		/*
		 * } catch (Exception e) { System.out.println(e); return null; }
		 */
		return movictypeDao.insertMovicTypeDao(movictype);
	}

	public MovicType updateMovicTypeService(MovicType movictype) {

		return movictypeDao.updateMovicTypeDao(movictype);
	}

	public void deleteMovicTypeService(MovicType movictype) {
		movictypeDao.deleteMovicTypeDao(movictype);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<MovicType> searchMovicTypeService(String whereSql) {

		return movictypeDao.searchMovicTypeDao(whereSql);
	}

}
