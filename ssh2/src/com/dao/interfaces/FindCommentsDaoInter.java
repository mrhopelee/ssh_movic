package com.dao.interfaces;

import java.util.List;

import com.bean.MovicComments;

/**
 *@authar �º���
 *
 **/

public interface FindCommentsDaoInter {
	
	public List<MovicComments> findPartComments(int id);

	public List<MovicComments> selectAllComments(Integer id);

	public int getPageCount(int nowMovieId, int pageSize);

	public List<MovicComments> selectListByMovieId(int nowMovieId, int pageNo,
			int pageSize);

}
