package com.malli.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malli.springhibernate.dao.SoldPacksDao;
import com.malli.springhibernate.model.SoldPacksInfo;
@Service
public class SoldPacksServiceImpl implements SoldPacksService {
	@Autowired
	private SoldPacksDao soldPacksDao;
	@Transactional
	public List<SoldPacksInfo> getSoldPacks() {
		List<SoldPacksInfo> packSoldInfos= soldPacksDao.getSoldPacks();
		return packSoldInfos;
	}
	@Transactional
	public List<SoldPacksInfo> getSoldPacksByName(String theName) {
		List<SoldPacksInfo> packSoldInfosByName = soldPacksDao.getSoldPacksByName(theName);
		return packSoldInfosByName;
	}

}
