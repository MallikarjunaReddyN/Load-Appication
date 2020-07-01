package com.malli.springhibernate.dao;

import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;

public interface UpdateAndDeleteDao {

	LoadInfo updateLoad(int loadId);

	void deleteLoad(int loadId);

	SoldPacksInfo updateSold(int soldId);

	void deleteSold(int soldId);

	PaidPacksInfo updatePaid(int paidId);

	void deletePaid(int paidId);

}
