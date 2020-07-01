package com.malli.springhibernate.service;

import com.malli.springhibernate.model.ForgotInfo;

public interface LoginService {

	public boolean findUser(String username, String password);
	public void updatepassword(ForgotInfo forgotInfo);
}
