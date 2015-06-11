package com.dao.imp;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bean.UserInfo;
import com.bean.UserType;
import com.dao.interfaces.UserManageDao;

/*
 * @author HuangLongChang
 */
public class UserManageDaoImp implements UserManageDao {

	@Resource
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean editUserType(String name, int type) {
		// TODO Auto-generated method stub
		System.out.println("����UserManageDao-editUserType����");
		try {
			UserInfo user = getUserByName(name);
			System.out
					.println("-----��ǰtype=" + user.getUserType().getRemarks());
			user.getUserType().setValue(type);
			switch (type) {
			case 1:
				user.getUserType().setRemarks("��ͨ�û�");
				break;
			case 2:
				user.getUserType().setRemarks("��Ա�û�");
				break;
			case 3:
				user.getUserType().setRemarks("��ͨ����Ա");
				break;
			case 4:
				user.getUserType().setRemarks("�߼�����Ա");
				break;

			}
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			System.out.println("�������ݳ���" + e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserPassword(String userName, String userPassword) {
		// TODO Auto-generated method stub
		System.out.println("����UserManageDao-updateUserPassword����");
		try {
			UserInfo user = getUserByName(userName);
			user.setUserPassword(userPassword);
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			System.out.println("�����������" + e);
			return false;
		}
		return true;
	}

	@Override
	public boolean updateUserMessage(String userName, String userDisplayName,
			String userSex, String userEmail) {
		// TODO Auto-generated method stub
		System.out.println("����UserManageDao-updateUserMessage����");
		try {
			UserInfo user = getUserByName(userName);
			user.setUserDisplayName(userDisplayName);
			user.setUserEmail(userEmail);
			user.setUserSex(userSex);
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			System.out.println("���¸�����Ϣ����" + e);
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		System.out.println("����ɾ���û�DAO");
		try {
			UserInfo user = (UserInfo) sessionFactory.getCurrentSession().load(
					UserInfo.class, userId);
			sessionFactory.getCurrentSession().delete(user);
		} catch (Exception e) {
			System.out.println("ɾ�����ݳ���" + e);
			return false;
		}

		return true;
	}

	@Override
	public ArrayList AllUser() {
		// TODO Auto-generated method stub
		System.out.println("����UserManageDao-AllUser����");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserInfo");
		if (query.list() != null) {
			System.out.println("����UserManageDao-AllUser������	�����Ϊ��");
		}
		return (ArrayList<UserInfo>) query.list();

	}

	
	@Override
	public UserInfo getUserByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("����UserManageDao-getUserByName����");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserInfo where userName='" + name + "'");
		if (query.uniqueResult() != null) {
			System.out.println("���ø����û�Name���û����н��");
			UserInfo user = (UserInfo) query.uniqueResult();
			return user;
		} else
			return null;
	}

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		System.out.println("����UserManageDao-getUserById����");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserInfo where userOid='" + id + "'");
		if (query.uniqueResult() != null) {
			System.out.println("���ø����û�id���û����н��");
			UserInfo user = (UserInfo) query.uniqueResult();
			return user;
		} else
			return null;
	}

	

}
