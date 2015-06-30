package com.server.interfaces;
/**
 *@authar 陈浩贤
 *
 **/

public interface SubmitCommentsServiceInter {

	void submitComments(int nowMoiveId, int nowUserId, int score,
			String comments_text);

	boolean checkUser(int nowUserId,int movicOid);

	void submitExecptScore(int nowMoiveId, int nowUserId, int score,
			String comments_text);

}
