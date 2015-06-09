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
	
		return false;
	}


	
	public List getMovicType() {

		
		return sessionFactory.getCurrentSession().createQuery("from MovicType").list();
	}


	@Override
	public List getMovicArea() {
		
		return sessionFactory.getCurrentSession().createQuery("from MovicArea").list();
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
	

}
