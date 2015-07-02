package com.server.interfaces;

import java.util.List;
import com.bean.MovicArea;

public interface MovicAreaServer {
	public MovicArea insertMovicAreaService(MovicArea movicarea);

	public MovicArea updateMovicAreaService(MovicArea movicarea);

	public void deleteMovicAreaService(MovicArea movicarea);

	public List<MovicArea> searchMovicAreaService(String whereSql);

}
