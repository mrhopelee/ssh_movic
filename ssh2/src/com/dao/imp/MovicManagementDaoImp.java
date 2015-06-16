package com.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bean.MovicArea;
import com.bean.MovicBeloneArea;
import com.bean.MovicBeloneType;
import com.bean.MovicInfo;
import com.bean.MovicType;
import com.bean.MovicVisiterNumber;
import com.bean.Paging;
import com.dao.interfaces.MovicManagementDao;

public class MovicManagementDaoImp implements MovicManagementDao {

	
	
	@Resource
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public int addMovic(MovicInfo movic) {
		
		try
		{
			sessionFactory.getCurrentSession().save(movic);
		}
		catch(Exception e)
		{
			return 0;
		}
		//获取添加电影信息后的电影oid 值
		
		//MovicInfo mid= (MovicInfo) sessionFactory.getCurrentSession().createQuery("from MovicInfo where movicName=?").setString(0,movic.getMovicName()).uniqueResult();
		
		return 1;//mid.getMovicOid();
	}


	public boolean deleteMovicByOid(int movicOid) {
	
		return false;
	}


	public boolean updateMovic(MovicInfo movic) {
		sessionFactory.getCurrentSession().saveOrUpdate(movic);
	
		return true;
	}


	
	public List getMovicType() {

		
		return sessionFactory.getCurrentSession().createQuery("from MovicType order by mtOid").list();
	}


	@Override
	public List getMovicArea() {
		
		return sessionFactory.getCurrentSession().createQuery("from MovicArea order by areaOid").list();
	}



	public boolean addMovicType(int movic_oid, int type_oid) {
		
		
		MovicBeloneType mbt=new MovicBeloneType();
		
		MovicInfo mi=new MovicInfo();
		mi.setMovicOid(movic_oid);
		
		MovicType mt=new MovicType();
		mt.setMtOid(type_oid);
		
		mbt.setMovicInfo(mi);
		mbt.setMovicType(mt);
		
		sessionFactory.getCurrentSession().save(mbt);
		
		
		return true;
	}


	
	public boolean addMovicArea(int movic_oid, int area_oid) {
		MovicInfo mi=new MovicInfo();
		mi.setMovicOid(movic_oid);
		
		MovicArea ma=new MovicArea();
		ma.setAreaOid(area_oid);
		
		MovicBeloneArea mba=new MovicBeloneArea();
		mba.setMovicArea(ma);
		mba.setMovicInfo(mi);
		sessionFactory.getCurrentSession().save(mba);
		return true;
	}



	public int searchMovicOidByMovicName(String movic_name) {
		sessionFactory.getCurrentSession().flush();
	MovicInfo mid= (MovicInfo) sessionFactory.getCurrentSession().createQuery("from MovicInfo where movicName=?").setString(0,movic_name).list().get(0);
	return mid.getMovicOid();
	}



	public boolean addMovicVister(int movic_oid) {
		MovicVisiterNumber mvn=new MovicVisiterNumber();
		MovicInfo mi=new MovicInfo();
		mi.setMovicOid(movic_oid);
		
		mvn.setMovicInfo(mi);
		mvn.setVisiterNumber(0);
		
		sessionFactory.getCurrentSession().save(mvn);
		
		return true;
	}



	public List getAllMovic(Paging p) {
		int begin=(p.getPageNow()-1)*p.getPageSize();
		int end=p.getPageSize();
		//System.out.println("begin"+begin+"  end"+end);
		
		return sessionFactory.getCurrentSession().createQuery("from MovicInfo order by movicOid").setFirstResult(begin).setMaxResults(end).list();
	}



	public int getMovicPaging() {
	
	
		return sessionFactory.getCurrentSession().createQuery("from MovicInfo").list().size();

		
	}



	public boolean deleteMovic(MovicInfo movic) {
		
		MovicInfo m=(MovicInfo) sessionFactory.getCurrentSession().load(MovicInfo.class, movic.getMovicOid());
		sessionFactory.getCurrentSession().delete(m);
		return true;
	}



	public MovicInfo getMovicByOid(int movicOid) {
		
		return (MovicInfo) sessionFactory.getCurrentSession().createQuery("from MovicInfo where movicOid=?").setInteger(0, movicOid).uniqueResult();
	}


	@Override
	public boolean updateMovicTypesByMovicOid(int movicOid, int[] types) {
		
		List<MovicBeloneType> l=sessionFactory.getCurrentSession().createQuery("from MovicBeloneType where movicInfo.movicOid=?").setInteger(0,movicOid).list();
		int i;
		for(i=0;i<3;i++)
		{
			MovicBeloneType mbt=l.get(i);
			MovicType mt=new MovicType();
			mt.setMtOid(types[i]);
			mbt.setMovicType(mt);
			
			sessionFactory.getCurrentSession().saveOrUpdate(mbt);
		}
		
		
		return true;
	}


	@Override
	public boolean updateMovicAreasByMovicOid(int movicOid, int[] areas) {
		
		List<MovicBeloneArea> l=sessionFactory.getCurrentSession().createQuery("from MovicBeloneArea where movicInfo.movicOid=?").setInteger(0,movicOid).list();
		int i;
		for(i=0;i<2;i++)
		{
			MovicBeloneArea mba=l.get(i);
			
			MovicArea ma=new MovicArea();
			ma.setAreaOid(areas[i]);
			mba.setMovicArea(ma);
			
			sessionFactory.getCurrentSession().saveOrUpdate(mba);
		}
		
		return true;
	}



	public boolean updateMovicPost(MovicInfo movic) {
		MovicInfo m=(MovicInfo) sessionFactory.getCurrentSession().get(MovicInfo.class, movic.getMovicOid());
		m.setMovicPost(movic.getMovicPost());
		
		sessionFactory.getCurrentSession().saveOrUpdate(m);
		
		return false;
	}



	public boolean addMovicVisiterNumber(int movicOid) {
		MovicVisiterNumber mvn=(MovicVisiterNumber) sessionFactory.getCurrentSession().createQuery("from MovicVisiterNumber where movicInfo.movicOid=?").setInteger(0,movicOid).uniqueResult();
		mvn=(MovicVisiterNumber) sessionFactory.getCurrentSession().load(MovicVisiterNumber.class ,mvn.getMvnOid());
		mvn.setVisiterNumber(mvn.getVisiterNumber()+1);
		return true;
	}
	

}
