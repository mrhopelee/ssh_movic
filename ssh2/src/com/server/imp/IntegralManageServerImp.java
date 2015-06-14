package com.server.imp;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.UserInfo;
import com.dao.interfaces.IntegralManageDao;
import com.server.interfaces.IntegralManageService;

/*
 * @author HuangLongChang
 */
@Transactional
public class IntegralManageServerImp implements IntegralManageService{
	@Resource
	private IntegralManageDao integralManageDao;

	@Override
	public boolean siginBoard(UserInfo user) {
		// TODO Auto-generated method stub
		return integralManageDao.signBoard(user);
	}

	@Override
	public boolean checkSiginBoard(UserInfo user) {
		// TODO Auto-generated method stub
		return integralManageDao.checkSiginBoard(user);
	}

	@Override
	public boolean addIntegral(UserInfo user, int integral) {
		// TODO Auto-generated method stub
		return integralManageDao.addIntegral(user,integral);
	}
	
	
	
}
