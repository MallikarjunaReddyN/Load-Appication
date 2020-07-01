package com.malli.springhibernate.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
@Repository
public class LoadDaoImpl implements LoadDao {

	@Autowired
	private SessionFactory sessionFactory;
	public List<LoadInfo> getLoads() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<LoadInfo> query = currentSession.createQuery("from LoadInfo", LoadInfo.class);
		List<LoadInfo> loadInfos = query.getResultList();
		return loadInfos;
	}
	public void addLoad(LoadInfo addLoad) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(addLoad);
	}
	public void addSold(SoldPacksInfo addSold) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(addSold);
	}
	public void addPaid(PaidPacksInfo addPaid) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(addPaid);
	}
	public List<LoadInfo> getLoadsByName(String theName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<LoadInfo> theQuery = null;
		if(theName!=null && theName.trim().length()>0)
		{
			theQuery= currentSession.createQuery("from LoadInfo where loadname like :theSearchName", LoadInfo.class);
			theQuery.setParameter("theSearchName","%"+ theName+"%");
		}
		else
		{
			theQuery = currentSession.createQuery("from LoadInfo", LoadInfo.class);
		}
		
		List<LoadInfo> loads = theQuery.getResultList();
		return loads;
	}
}
