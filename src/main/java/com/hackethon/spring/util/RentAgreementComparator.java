package com.hackethon.spring.util;

import java.util.Comparator;

import com.hackethon.spring.entity.RentAgreement;

public class RentAgreementComparator implements Comparator<RentAgreement> {

	@Override
	public int compare(RentAgreement o1, RentAgreement o2) {
		return Integer.valueOf(String.valueOf(o1.getId())) - Integer.valueOf(String.valueOf(o2.getId()));
	}

}
