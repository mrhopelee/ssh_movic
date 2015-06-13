package com.dao.interfaces;

import java.util.List;

import com.bean.MovicPicture;

public interface MovicPictureDao {
	public List showMovicPicture(int movicOid);//获取电影图片列表
	public boolean addMovicPicture(MovicPicture mp);//保存电影图片对像
	public boolean deletePicture(MovicPicture mp);//删除电影图片
}
