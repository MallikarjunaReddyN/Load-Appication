package com.malli.springhibernate.dao;

import com.malli.springhibernate.model.ForgotInfo;

public interface LoginDao {

	public boolean findUser(String username, String password);
	public void updatepassword(ForgotInfo forgotInfo);
}
