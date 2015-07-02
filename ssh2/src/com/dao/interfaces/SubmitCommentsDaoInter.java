package com.dao.interfaces;

import com.bean.MovicComments;
import com.bean.UserScoreMovic;

/**
 *@authar 陈浩贤
 *
 **/

public interface SubmitCommentsDaoInter {

	boolean checkUser(int nowUserId,int movicOid);


	void addComments(MovicComments mComments);


	void addScore(UserScoreMovic uScore);


	
	
	

}
