package com.server.interfaces;

import java.util.List;

import com.bean.MovicComments;

/**
 *@authar 陈浩贤
 *
 **/

public interface CommentsManageServiceInter {
	
	public List<MovicComments> selectList();

	public void delectComments(Integer mcOid);

	public List<MovicComments> getComments(Integer userOid);

	public void delCommentsByUser(Integer userOid);

}
