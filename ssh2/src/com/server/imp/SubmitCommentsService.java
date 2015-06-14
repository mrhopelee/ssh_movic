package com.server.imp;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicComments;
import com.bean.MovicInfo;
import com.bean.UserInfo;
import com.bean.UserScoreMovic;
import com.dao.interfaces.SubmitCommentsDaoInter;
import com.server.interfaces.SubmitCommentsServiceInter;

/**
 *@authar 陈浩贤
 *
 **/
@Transactional
public class SubmitCommentsService implements SubmitCommentsServiceInter {
	
	@Resource
	private SubmitCommentsDaoInter submitCommentsDao;

	@Override
	public void submitComments(int nowMovieId, int nowUserId, int score,
			String comments_text) {
		
			MovicComments mComments = new MovicComments();
			MovicInfo movicInfo = new MovicInfo();
			UserInfo userInfo = new UserInfo();
			
			movicInfo.setMovicOid(nowMovieId);
			mComments.setMovicInfo(movicInfo);
			userInfo.setUserOid(nowUserId);		
			mComments.setUserInfo(userInfo);
			mComments.setCommentsDate(new Timestamp(System.currentTimeMillis()));
			mComments.setCommentsInfo(comments_text);
			submitCommentsDao.addComments(mComments);
			
			UserScoreMovic uScore = new UserScoreMovic();
			
			uScore.setMovicInfo(movicInfo);
			uScore.setUserInfo(userInfo);
			uScore.setScore((double) score);
			submitCommentsDao.addScore(uScore);

	}
	
	@Override
	public void submitExecptScore(int nowMoiveId, int nowUserId, int score,
			String comments_text) {

			MovicComments mComments = new MovicComments();
			MovicInfo movicInfo = new MovicInfo();
			UserInfo userInfo = new UserInfo();
			
			movicInfo.setMovicOid(nowMoiveId);
			mComments.setMovicInfo(movicInfo);
			userInfo.setUserOid(nowUserId);		
			mComments.setUserInfo(userInfo);
			mComments.setCommentsDate(new Timestamp(System.currentTimeMillis()));
			mComments.setCommentsInfo(comments_text);
			submitCommentsDao.addComments(mComments);

		
	}


	@Override
	public boolean checkUser(int nowUserId) {
		
		return submitCommentsDao.checkUser(nowUserId);
	}

	public SubmitCommentsDaoInter getSubmitCommentsDao() {
		return submitCommentsDao;
	}

	public void setSubmitCommentsDao(SubmitCommentsDaoInter submitCommentsDao) {
		this.submitCommentsDao = submitCommentsDao;
	}

	
	
}
