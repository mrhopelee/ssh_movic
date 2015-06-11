package com.server.interfaces;

import java.util.List;

import com.bean.MovicComments;

/**
 *@authar Ёб╨фом
 *
 **/

public interface FindCommentsServiceInter {
	public List<MovicComments> findPartComments(int id);

}
