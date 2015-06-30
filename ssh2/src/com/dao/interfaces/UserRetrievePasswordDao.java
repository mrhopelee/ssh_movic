package com.dao.interfaces;

import com.bean.UserRetrievePassword;

public interface UserRetrievePasswordDao {
	//该方法获取用户验证记录
	public UserRetrievePassword checkEmailAndVerificationCode(String userEmail,String verificationCode);
	//返回符合条件的记录
	public UserRetrievePassword findBackUserOid(String userEmail,String verificationCode);
	//完成密码找回
	public void finish(int urpOid);
	//添加或更新该用户的找回密码记录
	public boolean alertURP(int userOid,String value);
}
