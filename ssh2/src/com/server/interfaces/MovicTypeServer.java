package com.server.interfaces;

import java.util.List;

import com.bean.MovicType;

public interface MovicTypeServer {
	public MovicType insertMovicTypeService(MovicType movictype);

	public MovicType updateMovicTypeService(MovicType movictype);

	public void deleteMovicTypeService(MovicType movictype);

	public List<MovicType> searchMovicTypeService(String whereSql);
}