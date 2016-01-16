package com.hackethon.spring.service;

import java.util.List;

import com.hackethon.spring.entity.RentAgreement;

public interface RentAgreementService {

	List<RentAgreement> getRentAgreementList();

	void addNewAgreement(RentAgreement rentAgreement);

	List<RentAgreement> getExpiringAgreements();

	void remove(RentAgreement removeRentAgreement);

}
