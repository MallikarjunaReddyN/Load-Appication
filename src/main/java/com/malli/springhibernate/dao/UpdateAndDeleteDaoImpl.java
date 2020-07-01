package com.malli.springhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.malli.springhibernate.model.LoadInfo;
import com.malli.springhibernate.model.PaidPacksInfo;
import com.malli.springhibernate.model.SoldPacksInfo;
@Repository
public class UpdateAndDeleteDaoImpl implements UpdateAndDeleteDao {

	@Autowired
	private SessionFactory sessionFactory;
	public LoadInfo updateLoad(int loadId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		LoadInfo loadInfo = currentSession.get(LoadInfo.class, loadId);
		return loadInfo;
	}
	public void deleteLoad(int loadId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from LoadInfo where loadid=:id");
		query.setParameter("id", loadId);
		query.executeUpdate();
	}
	public SoldPacksInfo updateSold(int soldId) {

		Session currentSession = sessionFactory.getCurrentSession();
		SoldPacksInfo soldInfo = currentSession.get(SoldPacksInfo.class, soldId);
		return soldInfo;
	}
	public void deleteSold(int soldId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from SoldPacksInfo where id=:id");
		query.setParameter("id", soldId);
		query.executeUpdate();
		
	}
	public PaidPacksInfo updatePaid(int paidId) {

		Session currentSession = sessionFactory.getCurrentSession();
		PaidPacksInfo paidInfo = currentSession.get(PaidPacksInfo.class, paidId);
		return paidInfo;
		
	}
	public void deletePaid(int paidId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from PaidPacksInfo where id=:id");
		query.setParameter("id", paidId);
		query.executeUpdate();
		
	}

}
