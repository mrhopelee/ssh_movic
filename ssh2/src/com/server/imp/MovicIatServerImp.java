package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicInfo;
import com.bean.Paging;
import com.dao.interfaces.MovicIatDao;
import com.server.interfaces.MovicIatServer;

@Transactional
public class MovicIatServerImp implements MovicIatServer {
	@Resource
	private MovicIatDao movicIatDao;

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public int getMovicPaging(String whereSql) {
		return movicIatDao.getMovicPaging(whereSql);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<MovicInfo> searchMovicInfoService(String whereSql, Paging paging) {
		return movicIatDao.searchMovicInfoDao(whereSql, paging);
	}

}
