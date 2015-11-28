package com.hackethon.spring.bb;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import org.springframework.stereotype.Component;

import com.hackethon.spring.model.User;
import com.hackethon.spring.util.ValidationUtil;

@Component
@ManagedBean
@RequestScoped
public class UserBB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2659752014533452810L;

	private User user;

	private Part file;

	private String fileContent;

	private int idProofType;

	private String idProofId;

	private boolean uploadedSuccessful;

	private List<String> errors;

	public User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(int idProofType) {
		this.idProofType = idProofType;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public String getIdProofId() {
		return idProofId;
	}

	public void setIdProofId(String idProofId) {
		this.idProofId = idProofId;
	}

	public boolean isUploadedSuccessful() {
		return uploadedSuccessful;
	}

	public void setUploadedSuccessful(boolean uploadedSuccessful) {
		this.uploadedSuccessful = uploadedSuccessful;
	}

	public List<String> getErrors() {
		if (errors == null) {
			errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String upload() {
		uploadedSuccessful = false;
		File file;
		String fileName = null;
		if (idProofType == 1) {
			fileName = idProofId;
			System.out.println(fileName);
		} else if (idProofType == 2) {
			fileName = idProofId;
		} else if (idProofType == 3) {
			fileName = idProofId;
		}
		try {
			file = File.createTempFile(fileName, ".jpg", new File("C:\\Hackethon"));
			this.file.write(file.getAbsolutePath());
			uploadedSuccessful = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String submit() {
		System.out.println("submit method called");
		errors = ValidationUtil.validate(this.user);
		for (String string : errors) {
			System.out.println(string);
		}
		return null;
	}

	public String reset() {
		user = new User();
		errors = new ArrayList<String>();
		file = null;
		fileContent = null;
		uploadedSuccessful = false;
		return null;
	}
}
