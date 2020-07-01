package com.malli.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malli.springhibernate.dao.LoadDao;
import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
@Service
public class LoadServiceImpl implements LoadService {
	@Autowired
	private LoadDao loadDao;
	@Transactional
	public List<LoadInfo> getLoads() {
		List<LoadInfo> loadInfos= loadDao.getLoads();
		return loadInfos;
	}
	
	@Transactional
	public void addLoad(LoadInfo addLoad) {
		
		loadDao.addLoad(addLoad);
	}
	
	@Transactional
	public void addSoldpack(SoldPacksInfo addSold) {
		
		loadDao.addSold(addSold);
	}
	
	@Transactional
	public void addPaid(PaidPacksInfo addPaid) {
		
		loadDao.addPaid(addPaid);
	}
	
	@Transactional
	public List<LoadInfo> getLoadsByName(String theName) {
		List<LoadInfo> loadsByName = loadDao.getLoadsByName(theName);
		return loadsByName;
	}

}
