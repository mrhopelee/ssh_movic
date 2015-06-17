package com.server.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.MovicInfo;
import com.bean.Paging;
import com.dao.interfaces.MovicIatDao;
import com.server.interfaces.MovicIatServer;

@Transactional
public class MovicIatServerImp implements MovicIatServer {
	@Resource
	private MovicIatDao movicIatDao;

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public String getWhereSql(String search, String type, String area,
			String sort) {
		String whereSql = "SELECT mi.movicOid, mi.movicName, mi.movicImdbScore, mi.movicPlayDate, mi.movicPost, mvn.visiterNumber"
				+ " FROM MovicInfo as mi,"
				+ " MovicBeloneArea as mba,"
				+ " MovicBeloneType as mbt,"
				+ " MovicArea as ma,"
				+ " MovicType as mt,"
				+ " MovicVisiterNumber as mvn"
				+ " WHERE mba.movicInfo.movicOid  = mi.movicOid"
				+ " AND mba.movicArea.areaOid = ma.areaOid"
				+ " AND mbt.movicInfo.movicOid = mi.movicOid"
				+ " AND mbt.movicType.mtOid = mt.mtOid"
				+ " AND mvn.movicInfo.movicOid = mi.movicOid"
				+ " AND mi.movicName LIKE "
				+ "'%"
				+ search
				+ "%'"
				+ " AND mt.type LIKE "
				+ "'%"
				+ type
				+ "%'"
				+ " AND ma.areaName LIKE "
				+ "'%"
				+ area
				+ "%'"
				+ " GROUP BY mi.movicOid, mi.movicName, mi.movicImdbScore, mi.movicPlayDate, mi.movicPost, mvn.visiterNumber"
				+ " ORDER BY " + sort + " desc";
		return whereSql;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public int getMovicPaging(String whereSql) {
		return movicIatDao.getMovicPaging(whereSql);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<MovicInfo> searchMovicInfoService(String whereSql, Paging paging) {
		List<?> list = movicIatDao.searchMovicInfoDao(whereSql, paging);
		List<MovicInfo> milist = new ArrayList<MovicInfo>();

		for (int i = 0; i < list.size(); i++) {
			Object[] o = (Object[]) list.get(i);
			// System.out.println(o[0].toString()+o[1].toString()+o[2].toString()+o[3].toString()+o[4].toString());
			MovicInfo m = new MovicInfo();
			m.setMovicOid(new Integer(o[0].toString()));
			m.setMovicName(o[1].toString());
			m.setMovicImdbScore(Double.valueOf(o[2].toString()));
			java.text.SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd ");
			try {
				m.setMovicPlayDate(formatter.parse(o[3].toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			m.setMovicPost(o[4].toString());
			/*m.setMovicVisiterNumbers(new Integer(o[4].toString());*/
			// System.out.println(m.getMovicOid()+m.getMovicName()+m.getMovicImdbScore()+m.getMovicPlayDate()+m.getMovicPost());
			milist.add(m);
		}

		return milist;
	}

}
