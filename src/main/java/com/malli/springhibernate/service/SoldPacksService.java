package com.malli.springhibernate.service;

import java.util.List;

import com.malli.springhibernate.model.SoldPacksInfo;

public interface SoldPacksService {

	List<SoldPacksInfo> getSoldPacks();
	
	List<SoldPacksInfo> getSoldPacksByName(String theName);

}
