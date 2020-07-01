package com.malli.springhibernate.service;

import java.util.List;

import com.malli.springhibernate.model.PaidPacksInfo;

public interface PaidPackService {

	List<PaidPacksInfo> getPaidPacks();

	List<PaidPacksInfo> getPaidPacksByName(String theName);
	
}
