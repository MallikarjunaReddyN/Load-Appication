package com.malli.springhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malli.springhibernate.dao.UpdateAndDeleteDao;
import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
@Service
public class UpdateAndDeleteServiceImpl implements UpdateAndDeleteService {

	@Autowired
	private UpdateAndDeleteDao updateAndDeleteDao;
	@Transactional
	public LoadInfo updateLoad(int loadId) {

		return updateAndDeleteDao.updateLoad(loadId);
	}
	
	@Transactional
	public void deleteLoad(int loadId) {
		
		updateAndDeleteDao.deleteLoad(loadId);
	}
	
	@Transactional
	public SoldPacksInfo updateSold(int soldId) {
		
		return updateAndDeleteDao.updateSold(soldId);
	}

	@Transactional
	public void deleteSold(int soldId) {

		updateAndDeleteDao.deleteSold(soldId);
	}

	@Transactional
	public PaidPacksInfo updatePaid(int paidId) {

		return updateAndDeleteDao.updatePaid(paidId);
	}

	@Transactional
	public void deletePaid(int paidId) {

		updateAndDeleteDao.deletePaid(paidId);
	}

}
