package com.hackethon.spring.bb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.hackethon.spring.entity.RentAgreement;
import com.hackethon.spring.service.RentAgreementService;

@ManagedBean
@SessionScoped
public class UserBB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1049952560494748848L;

	private RentAgreement rentAgreement;

	private List<RentAgreement> rentAgreements;

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Autowired
	private RentAgreementService rentAgreementService;

	@PostConstruct
	public void init() {
		if (rentAgreements == null || rentAgreements.isEmpty()) {
			rentAgreements = rentAgreementService.getRentAgreementList();
		}
	}

	public String handleRecord() {
		if (!validateRecord()) {
			rentAgreementService.addNewAgreement(rentAgreement);
			rentAgreements = rentAgreementService.getRentAgreementList();
			rentAgreement = new RentAgreement();			
			FacesMessage msg = new FacesMessage("Record Saved successfully!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return null;
	}

	private boolean validateRecord() {
		boolean inValid = false;
		if (StringUtils.isEmpty(rentAgreement.getOwnerName())) {
			FacesMessage msg = new FacesMessage("Please enter owner name");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		if (StringUtils.isEmpty(rentAgreement.getRentedTo())) {
			FacesMessage msg = new FacesMessage("Please enter tenant name");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		if (rentAgreement.getAgreementFromDate() == null) {
			FacesMessage msg = new FacesMessage("Please enter agreement start date");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		if (rentAgreement.getAgreementToDate() == null) {
			FacesMessage msg = new FacesMessage("Please enter agreement end date");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		if (rentAgreement.getOwnerContactNumber() == 0) {
			FacesMessage msg = new FacesMessage("Please owner contact number");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		if (rentAgreement.getTenantContactNumber() == 0) {
			FacesMessage msg = new FacesMessage("Please tenant contact number");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		if (rentAgreement.getDeposit() == 0) {
			FacesMessage msg = new FacesMessage("Please valid deposit amount");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		if (rentAgreement.getRent() == 0) {
			FacesMessage msg = new FacesMessage("Please valid rent amount");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			inValid = true;
		}
		return inValid;
	}

	public void onRowEdit(RowEditEvent event) {
		RentAgreement rentAgreement = (RentAgreement) event.getObject();
		this.rentAgreement = rentAgreement;
		if (!validateRecord()) {
			rentAgreementService.addNewAgreement(rentAgreement);
			rentAgreements = rentAgreementService.getRentAgreementList();
			this.rentAgreement = new RentAgreement();
			FacesMessage msg = new FacesMessage("Record saved successfully!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public RentAgreement getRentAgreement() {
		if (rentAgreement == null) {
			rentAgreement = new RentAgreement();
		}
		return rentAgreement;
	}

	public void setRentAgreement(RentAgreement rentAgreement) {
		this.rentAgreement = rentAgreement;
	}

	public List<RentAgreement> getRentAgreements() {
		for (RentAgreement rentAgreement : rentAgreements) {
			System.out.println("Name : " + rentAgreement.getRentedTo());
			System.out.println("From : " + rentAgreement.getAgreementFromDate());
			System.out.println("To : " + rentAgreement.getAgreementToDate());
		}
		return rentAgreements;
	}

	public void setRentAgreements(List<RentAgreement> rentAgreements) {
		this.rentAgreements = rentAgreements;
	}

	public void setRentAgreementService(RentAgreementService rentAgreementService) {
		this.rentAgreementService = rentAgreementService;
	}

	public String reset() {
		rentAgreement = null;
		return null;
	}

	public String delete() {
		RentAgreement removeRentAgreement = rentAgreements.remove(getIndex());
		rentAgreementService.remove(removeRentAgreement);
		rentAgreements = rentAgreementService.getRentAgreementList();
		return null;
	}
}
