package com.hackethon.spring.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hackethon.spring.entity.RentAgreement;
import com.hackethon.spring.util.RentAgreementComparator;

@Repository
@Transactional
public class RentAgreementDaoImpl implements RentAgreementDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1619391861184362153L;
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RentAgreement> getRentAgreementList() {
		List<RentAgreement> rentAgreements = new ArrayList<RentAgreement>();
		rentAgreements = sessionFactory.getCurrentSession().createCriteria(RentAgreement.class).list();
		rentAgreements.sort(new RentAgreementComparator());
		return rentAgreements;
	}

	@Override
	public void addNewAgreement(RentAgreement rentAgreement) {
		sessionFactory.getCurrentSession().merge(rentAgreement);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<RentAgreement> getExpiringAgreements() {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from hackethondb.rentagreement "
				+ "where datediff(current_timestamp(), agreementToDate) = 1;");
		return query.addEntity(RentAgreement.class).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void remove(RentAgreement removeRentAgreement) {
		RentAgreement rentAgreementAttached = (RentAgreement) sessionFactory.getCurrentSession().load(RentAgreement.class, removeRentAgreement.getId());
		sessionFactory.getCurrentSession().delete(rentAgreementAttached);
	}
}
