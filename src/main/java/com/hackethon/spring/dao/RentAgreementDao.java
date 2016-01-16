package com.hackethon.spring.dao;

import java.util.List;

import com.hackethon.spring.entity.RentAgreement;

public interface RentAgreementDao {

	List<RentAgreement> getRentAgreementList();

	void addNewAgreement(RentAgreement rentAgreement);

	List<RentAgreement> getExpiringAgreements();

	void remove(RentAgreement removeRentAgreement);

}
