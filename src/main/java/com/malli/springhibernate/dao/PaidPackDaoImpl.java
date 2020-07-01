package com.malli.springhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
@Repository
public class PaidPackDaoImpl implements PaidPackDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public List<PaidPacksInfo> getPaidPacks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<PaidPacksInfo> query = currentSession.createQuery("from PaidPacksInfo", PaidPacksInfo.class);
		List<PaidPacksInfo> loadInfos = query.getResultList();
		return loadInfos;
	}
	public List<PaidPacksInfo> getSoldPacksByName(String theName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<PaidPacksInfo> theQuery = null;
		if(theName!=null && theName.trim().length()>0)
		{
			theQuery= currentSession.createQuery("from PaidPacksInfo where personname like :theSearchName", PaidPacksInfo.class);
			theQuery.setParameter("theSearchName","%"+ theName+"%");
		}
		else
		{
			theQuery = currentSession.createQuery("from PaidPacksInfo", PaidPacksInfo.class);
		}
		
		List<PaidPacksInfo> solds = theQuery.getResultList();
		return solds;
	}

}
