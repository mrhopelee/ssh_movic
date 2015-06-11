package com.dao.interfaces;

import java.util.List;

import com.bean.MovicComments;

/**
 *@authar 陈浩贤
 *
 **/

public interface CommentsManageDaoInter {

	public List<MovicComments> selectList();

	public void deleteComments(Integer mcOid);
}
