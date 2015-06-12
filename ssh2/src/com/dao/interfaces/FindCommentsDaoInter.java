package com.dao.interfaces;

import java.util.List;

import com.bean.MovicComments;

/**
 *@authar Ёб╨фом
 *
 **/

public interface FindCommentsDaoInter {
	
	public List<MovicComments> findPartComments(int id);

}
