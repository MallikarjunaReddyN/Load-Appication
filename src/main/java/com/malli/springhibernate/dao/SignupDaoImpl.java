package com.malli.springhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.malli.springhibernate.model.SignupInfo;
@Repository
public class SignupDaoImpl implements SignupDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void addUser(SignupInfo signupInfo) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(signupInfo);
	}

}
