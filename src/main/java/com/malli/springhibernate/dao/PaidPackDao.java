package com.malli.springhibernate.dao;

import java.util.List;

import com.malli.springhibernate.model.PaidPacksInfo;

public interface PaidPackDao {

	List<PaidPacksInfo> getPaidPacks();

	List<PaidPacksInfo> getSoldPacksByName(String theName);

}
