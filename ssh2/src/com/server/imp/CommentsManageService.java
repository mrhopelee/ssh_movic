package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicComments;
import com.dao.interfaces.CommentsManageDaoInter;
import com.server.interfaces.CommentsManageServiceInter;

/**
 *@authar 陈浩贤
 *
 **/

@Transactional
public class CommentsManageService implements CommentsManageServiceInter {
	
	@Resource
	private CommentsManageDaoInter commentsManageDao;

	
	
	/**
	 * 查找所有评论
	 * @return List
	 */
	@Override
	public List<MovicComments> selectList() {
		// TODO Auto-generated method stub
		return commentsManageDao.selectList();
	}
	

	@Override
	public void delectComments(Integer mcOid) {
		commentsManageDao.deleteComments(mcOid);
		
	}

	
	/**
	 * 查找当前用户评论
	 * @return List
	 */
	@Override
	public List<MovicComments> getComments(Integer userOid) {
		
		return commentsManageDao.selectUserCommentsByUserId(userOid);
	}


	/**
	 * 用户删除自己的评论
	 * 
	 */
	@Override
	public void delCommentsByUser(Integer userOid) {
		commentsManageDao.delCommentsByUserId(userOid);
		
	}



	public CommentsManageDaoInter getCommentsManageDao() {
		return commentsManageDao;
	}

	public void setCommentsManageDao(CommentsManageDaoInter commentsManageDao) {
		this.commentsManageDao = commentsManageDao;
	}



	

	
	
	
}
