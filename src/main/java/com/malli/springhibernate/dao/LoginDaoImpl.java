package com.malli.springhibernate.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.malli.springhibernate.model.ForgotInfo;
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean findUser(String userName, String password) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from LoginInfo as o where o.usrname=? and o.Password=?";
		Query query = currentSession.createQuery(SQL_QUERY);
		query.setParameter(0,userName);
		query.setParameter(1,password);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		return userFound;
	}
	
	public void updatepassword(ForgotInfo forgotInfo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("update LoginInfo set password=:password, reptpassword=:password where usrname=:username");
		query.setParameter("password", forgotInfo.getPassword());
		query.setParameter("password", forgotInfo.getConfirm());
		query.setParameter("username", forgotInfo.getUsername());
		query.executeUpdate();
	}

}
