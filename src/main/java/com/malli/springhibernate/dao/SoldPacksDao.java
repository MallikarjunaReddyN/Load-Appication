package com.malli.springhibernate.dao;

import java.util.List;

import com.malli.springhibernate.model.SoldPacksInfo;

public interface SoldPacksDao {

	List<SoldPacksInfo> getSoldPacks();

	List<SoldPacksInfo> getSoldPacksByName(String theName);

}
