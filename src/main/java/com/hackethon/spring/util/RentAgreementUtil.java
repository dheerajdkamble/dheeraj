package com.hackethon.spring.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RentAgreementUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.dateFormat);
	
	public static String formatDate(Date date) {
		return sdf.format(date);
	}
}
