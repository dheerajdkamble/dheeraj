package com.hackethon.spring.bb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hackethon.spring.model.User;
import com.hackethon.spring.service.UserService;

@Controller
@Scope(value="session")
public class UserBB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2659752014533452810L;

	private String destination="C:\\Hackethon\\";
	
	private User user;

	private String fileContent;

	private int idProofType;

	private String idProofId;

	private boolean uploadedSuccessful;

	private List<String> errors;

	private UploadedFile file;
	
	private int onlineTransactionPin;

	@Autowired
	private UserService userService;
	
	public void setFile(UploadedFile file) {
		this.file = file;
	}

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

	public int getOnlineTransactionPin() {
		return onlineTransactionPin;
	}

	public void setOnlineTransactionPin(int onlineTransactionPin) {
		this.onlineTransactionPin = onlineTransactionPin;
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String submit() {
		userService.saveUser(user);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful", "Account successfully created for " + user.getFirstName()));
//		errors = ValidationUtil.validate(this.user);
//		for (String string : errors) {
//			System.out.println(string);
//		}
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
	
	public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }  
 
    public void copyFile(String fileName, InputStream in) {
           try {
              
              
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
