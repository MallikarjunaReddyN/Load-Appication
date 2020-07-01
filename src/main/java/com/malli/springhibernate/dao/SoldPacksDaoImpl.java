package com.malli.springhibernate.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.malli.springhibernate.model.SoldPacksInfo;
@Repository
public class SoldPacksDaoImpl implements SoldPacksDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public List<SoldPacksInfo> getSoldPacks() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SoldPacksInfo> query = currentSession.createQuery("from SoldPacksInfo", SoldPacksInfo.class);
		List<SoldPacksInfo> loadInfos = query.getResultList();
		return loadInfos;
	}
	public List<SoldPacksInfo> getSoldPacksByName(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SoldPacksInfo> theQuery = null;
		if(theSearchName!=null && theSearchName.trim().length()>0)
		{
			theQuery= currentSession.createQuery("from SoldPacksInfo where personname like :theSearchName", SoldPacksInfo.class);
			theQuery.setParameter("theSearchName","%"+ theSearchName+"%");
		}
		else
		{
			theQuery = currentSession.createQuery("from SoldPacksInfo", SoldPacksInfo.class);
		}
		
		List<SoldPacksInfo> solds = theQuery.getResultList();
		return solds;
	}

}
