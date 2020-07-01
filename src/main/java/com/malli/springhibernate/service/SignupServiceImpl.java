package com.malli.springhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malli.springhibernate.dao.SignupDao;
import com.malli.springhibernate.model.SignupInfo;
@Service
public class SignupServiceImpl implements SignupService {
	
	@Autowired
	private SignupDao signupDao;
	@Transactional
	public void addUser(SignupInfo signupInfo) {
		signupDao.addUser(signupInfo);
	}

}
