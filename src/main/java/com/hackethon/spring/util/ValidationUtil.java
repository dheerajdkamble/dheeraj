package com.hackethon.spring.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.hackethon.spring.model.User;

public class ValidationUtil {
	public static boolean isValid = false;

	public static List<String> validate(User user) {
		List<String> message = new ArrayList<String>();
		if (user != null) {
			if (user.getFirstName() != null && user.getFirstName().isEmpty()) {
				message.add("Firstname should not be empty.");
			} else if (!user.getFirstName().matches("[A-Z][a-z]")) {
				message.add("Firstname is invalid.");
			}
			if (user.getLastName() != null && user.getLastName().isEmpty()) {
				message.add("Lastname should not be empty.");
			} else if (!user.getLastName().matches("[A-Z][a-z]")) {
				message.add("Lastname is invalid.");
			}

//			if (user.get != null && user.getMiddleName().isEmpty()) {
//				message.add("MiddleName should not be empty.");
//			} else if (!user.getMiddleName().matches("[A-Z][a-z]")) {
//				message.add("MiddleName is invalid.");
//			}

//			if (user.getMobileNumber() == 0) {
//				message.add("Invalid mobile number");
//			} else {
//				String mobile = String.valueOf(user.getMobileNumber());
//				if (!mobile.matches("\\d")) {
//					message.add("Invalid mobile number.");
//				}
//			}

			if (StringUtils.isEmpty(user.getAadharNumber())) {
				message.add("Invalid mobile number");
			} else {
				// String mobile = String.valueOf(user.getAadharNumber());
				if (!user.getAadharNumber().matches("\\d")) {
					message.add("Invalid adhar number.");
				}
			}
//			if (StringUtils.isEmpty(user.getDistrict())) {
//				message.add("Invalid district");
//			} else {
//				if (!user.getDistrict().matches("[A-Z][a-z]")) {
//					message.add("Invalid district.");
//				}
//			}
			if (user.getState().isEmpty()) {
				message.add("Invalid state");
			} else {
				// String mobile = String.valueOf(user.getAadharNumber());
				if (!user.getState().matches("[A-Z][a-z]")) {
					message.add("Invalid state.");
				}
			}
			if (user.getStreet().isEmpty()) {
				message.add("Invalid street");
			} else {
				// String mobile = String.valueOf(user.getAadharNumber());
				if (!user.getStreet().matches("[A-Z][a-z]")) {
					message.add("Invalid street.");
				}
			}
			if (user.getEmail().isEmpty()) {
				message.add("Invalid email");
			} else {
				// String mobile = String.valueOf(user.getAadharNumber());
				if (!user.getEmail().matches(
						"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
					message.add("Invalid email.");
				}
			}
			if (String.valueOf(user.getDateOfBirth()).isEmpty()) {
				message.add("Invalid date of birth");
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String dob = String.valueOf(user.getDateOfBirth());
				try {
					sdf.parse(dob);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					message.add("Invalid date of birth");
				}
			}
			isValid = true;
		}
		return message;
	}
}
