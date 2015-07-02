package com.server.imp;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.UserRetrievePassword;
import com.dao.interfaces.UserRetrievePasswordDao;
import com.server.interfaces.UserRetrievePasswordServer;

@Transactional
public class UserRetrievePasswordServerImp implements
		UserRetrievePasswordServer {
	@Resource
	private UserRetrievePasswordDao userRetrievePasswordDao;

	//返回判断结果
	public String checkEmailAndVerificationCode(String userEmail,
			String verificationCode) {
		String result="ok";
		
		UserRetrievePassword urp= userRetrievePasswordDao.checkEmailAndVerificationCode(userEmail, verificationCode);
		//result=urp.getCheckDate().toString()+"  "+urp.getVerificationCode()+" "+urp.getIsCheck();
		
		if(urp==null)
		{
			result="null";
			return result;
		}
		
		if(urp.getIsCheck()==true)
		{
			//已经验证了
			result="false";
		}
		Timestamp nowtime=new Timestamp(new Date().getTime());
		if(urp.getCheckDate().before(nowtime))
		{
			//在现在之前 验证失败 时间失效
			result="out of time";
		}
		
		
		return result;
	}

	@Override
	public int findBackUserOid(String userEmail, String verificationCode) {
		UserRetrievePassword urp= userRetrievePasswordDao.checkEmailAndVerificationCode(userEmail, verificationCode);
		//根据返回来的记录 进行合法性判断 若合法则返回用户编号 方便接下来修改用户密码
		if(urp==null)
		{
			return -1;
		}
		
		if(urp.getIsCheck()==true)
		{
			//已经验证了
			return -1;
		}
		Timestamp nowtime=new Timestamp(new Date().getTime());
		if(urp.getCheckDate().before(nowtime))
		{
			//在现在之前 验证失败 时间失效
			return -1;
		}
		
		
		
		return urp.getUserInfo().getUserOid();
	}

	public int findBackUrpOid(String userEmail, String verificationCode) {
		//返回记录的编号 方便后续修改
		UserRetrievePassword urp= userRetrievePasswordDao.checkEmailAndVerificationCode(userEmail, verificationCode);
		return urp.getUrpOid();
	}

	
	public void finish(int urpOid) {
		userRetrievePasswordDao.finish(urpOid);
		
	}

	@Override
	public boolean alertURP(int userOid,String value) {
		
		return userRetrievePasswordDao.alertURP(userOid,value);
	}

	
	

}
