package com.server.interfaces;

import com.bean.UserRetrievePassword;

public interface UserRetrievePasswordServer {
	
	//该方法用来判断用户找回密码表中是否存在这条记录 以及是否过时 以及是否使用过
	public String checkEmailAndVerificationCode(String userEmail,String verificationCode);
	//检查是否符合找回密码的条件 并返回用户id
	public int findBackUserOid(String userEmail,String verificationCode);
	//返回找回记录的id
	public int findBackUrpOid(String userEmail,String verificationCode);
	//完成密码找回
	public void finish(int urpOid);
	
	//添加或更新该用户的找回密码记录
	public boolean alertURP(int userOid,String value);

}
