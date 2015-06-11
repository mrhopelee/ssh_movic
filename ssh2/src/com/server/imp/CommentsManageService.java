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

	@Override
	public List<MovicComments> selectList() {
		// TODO Auto-generated method stub
		return commentsManageDao.selectList();
	}
	

	@Override
	public void delectComments(Integer mcOid) {
		commentsManageDao.deleteComments(mcOid);
		
	}


	public CommentsManageDaoInter getCommentsManageDao() {
		return commentsManageDao;
	}

	public void setCommentsManageDao(CommentsManageDaoInter commentsManageDao) {
		this.commentsManageDao = commentsManageDao;
	}

	
	
}
