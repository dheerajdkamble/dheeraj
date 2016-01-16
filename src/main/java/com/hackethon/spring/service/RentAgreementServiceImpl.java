package com.hackethon.spring.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackethon.spring.dao.RentAgreementDao;
import com.hackethon.spring.entity.RentAgreement;

@Service
@Transactional
public class RentAgreementServiceImpl implements RentAgreementService, Serializable {

	@Autowired
	private RentAgreementDao rentAgreementDao;
	
	@Override
	public List<RentAgreement> getRentAgreementList() {
		return rentAgreementDao.getRentAgreementList();
	}

	@Override
	public void addNewAgreement(RentAgreement rentAgreement) {
		rentAgreementDao.addNewAgreement(rentAgreement);
	}
	
	@Override
	public List<RentAgreement> getExpiringAgreements() {
		return rentAgreementDao.getExpiringAgreements();
	}
	
	public void setRentAgreementDao(RentAgreementDao rentAgreementDao) {
		this.rentAgreementDao = rentAgreementDao;
	}

	@Override
	public void remove(RentAgreement removeRentAgreement) {
		rentAgreementDao.remove(removeRentAgreement);		
	}

}
