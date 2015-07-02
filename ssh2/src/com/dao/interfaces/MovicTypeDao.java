package com.dao.interfaces;

import java.util.List;

import com.bean.MovicType;

public interface MovicTypeDao {
	public MovicType insertMovicTypeDao(MovicType movictype);

	public MovicType updateMovicTypeDao(MovicType movictype);

	public void deleteMovicTypeDao(MovicType movictype);

	public List<MovicType> searchMovicTypeDao(String whereSql);
}
