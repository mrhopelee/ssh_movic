package com.dao.interfaces;

import com.bean.UserInfo;
import com.bean.UserIntegral;

/*
 * @author HuangLongChang
 */
public interface IntegralManageDao {

public	boolean signBoard(UserInfo user);

public boolean checkSiginBoard(UserInfo user);

public boolean addIntegral(UserInfo user, int integral);

UserIntegral getUserIntegralByUser(UserInfo user);

}
