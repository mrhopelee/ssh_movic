package com.server.interfaces;

import com.bean.UserInfo;

/*
 * @author HuangLongChang
 */
public interface IntegralManageService {

public	boolean siginBoard(UserInfo user);

public	boolean checkSiginBoard(UserInfo user);	

public	boolean addIntegral(UserInfo user,int integral);   
}
