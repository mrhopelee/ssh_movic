package com.server.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicComments;
import com.dao.interfaces.FindCommentsDaoInter;
import com.server.interfaces.FindCommentsServiceInter;

/**
 *@authar �º���
 *
 **/
@Transactional
public class FindCommentsService implements FindCommentsServiceInter {
	@Resource
	private FindCommentsDaoInter findCommentsDao;



	public FindCommentsDaoInter getFindCommentsDao() {
		return findCommentsDao;
	}



	public void setFindCommentsDao(FindCommentsDaoInter findCommentsDao) {
		this.findCommentsDao = findCommentsDao;
	}



	@Override
	public List<MovicComments> findPartComments(int id) {
		// TODO Auto-generated method stub
		return findCommentsDao.findPartComments(id);
	}



	@Override
	public List<MovicComments> selectAllComments(Integer id) {
		// TODO Auto-generated method stub
		return findCommentsDao.selectAllComments(id);
	}



	@Override
	public int getPageCount(int nowMovieId, int pageSize) {
		
		return findCommentsDao.getPageCount(nowMovieId,pageSize);
	}



	@Override
	public List<MovicComments> selectListByMovieId(int nowMovieId, int pageNo,
			int pageSize, int pageCount) {
		if(pageNo<1){
			pageNo = 1;	
		}
		else if(pageNo>pageCount){
			pageNo = pageCount;	
		}
		
		return findCommentsDao.selectListByMovieId(nowMovieId,pageNo,pageSize);
	}

}
