package com.malli.springhibernate.dao;

import java.util.List;

import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;

public interface LoadDao {

	public List<LoadInfo> getLoads();

	public void addLoad(LoadInfo addLoad);

	public void addSold(SoldPacksInfo addSold);

	public void addPaid(PaidPacksInfo addPaid);

	public List<LoadInfo> getLoadsByName(String theName);
}
