package com.hackethon.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hackethon.spring.util.RentAgreementUtil;

@Entity
@Table(name = "RENTAGREEMENT")
public class RentAgreement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5602156793181874867L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String ownerName;

	@Column
	private String rentedTo;

	@Column
	private Date agreementFromDate;
	
	private transient String agreementFromDateView;

	@Column
	private Date agreementToDate;
	
	private transient String agreementToDateView;

	@Column
	private String address;

	@Column
	private long ownerContactNumber;

	@Column
	private long tenantContactNumber;

	@Column
	private String ownerEmail;

	@Column
	private String tenantEmail;
	
	@Column
	private long deposit;
	
	@Column
	private long rent;
	
	@Column
	private String referrer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getRentedTo() {
		return rentedTo;
	}

	public void setRentedTo(String rentedTo) {
		this.rentedTo = rentedTo;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getOwnerContactNumber() {
		return ownerContactNumber;
	}

	public void setOwnerContactNumber(long ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}

	public long getTenantContactNumber() {
		return tenantContactNumber;
	}

	public void setTenantContactNumber(long tenantContactNumber) {
		this.tenantContactNumber = tenantContactNumber;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getTenantEmail() {
		return tenantEmail;
	}

	public void setTenantEmail(String tenantEmail) {
		this.tenantEmail = tenantEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getAgreementFromDate() {
		return agreementFromDate;
	}

	public void setAgreementFromDate(Date agreementFromDate) {
		this.agreementFromDate = agreementFromDate;
	}

	public Date getAgreementToDate() {
		return agreementToDate;
	}

	public void setAgreementToDate(Date agreementToDate) {
		this.agreementToDate = agreementToDate;
	}
	
	public long getDeposit() {
		return deposit;
	}

	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}

	public long getRent() {
		return rent;
	}

	public void setRent(long rent) {
		this.rent = rent;
	}
	
	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	
	public String getAgreementFromDateView() {
		if(agreementFromDate != null) {
			agreementFromDateView = RentAgreementUtil.formatDate(getAgreementFromDate());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>agreementFromDateView : " +agreementFromDateView);
		}
		return agreementFromDateView;
	}

	public void setAgreementFromDateView(String agreementFromDateView) {
		this.agreementFromDateView = agreementFromDateView;
	}

	public String getAgreementToDateView() {
		if(agreementToDate != null) {
			agreementToDateView = RentAgreementUtil.formatDate(getAgreementToDate());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>agreementToDateView : " +agreementToDateView);
		}
		return agreementToDateView;
	}

	public void setAgreementToDateView(String agreementToDateView) {
		this.agreementToDateView = agreementToDateView;
	}

	@Override
	public String toString() {
		return "RentAgreement [id=" + id + ", ownerName=" + ownerName + ", rentedTo=" + rentedTo
				+ ", agreementFromDate=" + agreementFromDate + ", agreementToDate=" + agreementToDate + ", address="
				+ address + ", ownerContactNumber=" + ownerContactNumber + ", tenantContactNumber="
				+ tenantContactNumber + ", ownerEmail=" + ownerEmail + ", tenantEmail=" + tenantEmail + ", deposit="
				+ deposit + ", rent=" + rent + ", referrer=" + referrer + "]";
	}	
}
