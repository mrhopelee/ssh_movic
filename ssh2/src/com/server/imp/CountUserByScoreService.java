package com.server.imp;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.interfaces.CountUserByScoreDaoInter;
import com.server.interfaces.CountUserByScoreServiceInter;

/**
 *@authar 陈浩贤
 *
 **/

@Transactional
public class CountUserByScoreService implements CountUserByScoreServiceInter {

	@Resource
	private CountUserByScoreDaoInter countUserByScoreDao;


	@Override
	public int countUserByScore(int id, int i) {
		
		return countUserByScoreDao.countUserByScore(id,i);
	}
	
	
	
	public CountUserByScoreDaoInter getCountUserByScoreDao() {
		return countUserByScoreDao;
	}
	public void setCountUserByScoreDao(CountUserByScoreDaoInter countUserByScoreDao) {
		this.countUserByScoreDao = countUserByScoreDao;
	}


}
