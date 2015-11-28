package com.hackethon.spring.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int userID;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date DateOfBirth;
	private String gender;
	private boolean isPPUpload;
	private boolean isPanUpload;
	private boolean isDLUpload;
	private String email;
	private int mobileNumber;
	private String street;
	private String subDistrit;
	private String district;
	private String state;
	private int pincode;
	private String aadharNumber;

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isPPUpload() {
		return isPPUpload;
	}

	public void setPPUpload(boolean isPPUpload) {
		this.isPPUpload = isPPUpload;
	}

	public boolean isPanUpload() {
		return isPanUpload;
	}

	public void setPanUpload(boolean isPanUpload) {
		this.isPanUpload = isPanUpload;
	}

	public boolean isDLUpload() {
		return isDLUpload;
	}

	public void setDLUpload(boolean isDLUpload) {
		this.isDLUpload = isDLUpload;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getUserID() {
		return userID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSubDistrit() {
		return subDistrit;
	}

	public void setSubDistrit(String subDistrit) {
		this.subDistrit = subDistrit;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
