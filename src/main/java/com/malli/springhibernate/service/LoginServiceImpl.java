package com.malli.springhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malli.springhibernate.dao.LoginDao;
import com.malli.springhibernate.model.ForgotInfo;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	@Transactional
	public boolean findUser(String username, String password) {
		boolean user = loginDao.findUser(username, password);
		return user;
	}
	@Transactional
	public void updatepassword(ForgotInfo forgotInfo) {
		
		loginDao.updatepassword(forgotInfo);
		
	}

}
