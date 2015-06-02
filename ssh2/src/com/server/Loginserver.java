package com.server;

import java.util.List;

import javax.annotation.Resource;




import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Userinfo;

public class Loginserver implements Server {
	@Resource
	private SessionFactory sessionFactory;
//<property name="sessionFactory" ref="sessionFactory"></property>
	//<context:annotation-config ></context:annotation-config>
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//
	public String check() {
		List<Userinfo> l;
	
		l=sessionFactory.openSession().createQuery("from Userinfo").list();
		
		for(Userinfo u:l)
		{
			System.out.println(u.getDisplayname());
			
		}
		System.out.println("ok");
		return "success";
	}


	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

}
