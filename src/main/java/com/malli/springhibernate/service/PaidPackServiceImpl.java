package com.malli.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malli.springhibernate.dao.PaidPackDao;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
@Service
public class PaidPackServiceImpl implements PaidPackService {
	@Autowired
	private PaidPackDao paidPackDao;
		@Transactional
		public List<PaidPacksInfo> getPaidPacks() {
			List<PaidPacksInfo> packSoldInfos= paidPackDao.getPaidPacks();
			return packSoldInfos;
		}
		@Transactional
		public List<PaidPacksInfo> getPaidPacksByName(String theName) {
			List<PaidPacksInfo> packPaidInfosByName = paidPackDao.getSoldPacksByName(theName);
			return packPaidInfosByName;
		}
}
