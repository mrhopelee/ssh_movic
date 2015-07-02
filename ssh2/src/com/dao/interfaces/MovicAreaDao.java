package com.dao.interfaces;

import java.util.List;
import com.bean.MovicArea;

public interface MovicAreaDao {
	public MovicArea insertMovicAreaDao(MovicArea movicarea);

	public MovicArea updateMovicAreaDao(MovicArea movicarea);

	public void deleteMovicAreaDao(MovicArea movicarea);

	public List<MovicArea> searchMovicAreaDao(String whereSql);
}
