package com.hackethon.spring.util;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackethon.spring.entity.RentAgreement;
import com.hackethon.spring.service.RentAgreementService;

@Service
public class MailUtility {

	@Autowired
	RentAgreementService rentAgreementService;

	@PostConstruct
	public void init() {
		List<RentAgreement> rentAgreements = rentAgreementService.getExpiringAgreements();

		if (rentAgreements != null && !rentAgreements.isEmpty()) {
			for (RentAgreement rentAgreement : rentAgreements) {
				MailSenderUtility msu = new MailSenderUtility(rentAgreement);
				msu.start();
			}
		}
	}

	private static class MailSenderUtility extends Thread {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		RentAgreement ra;

		public MailSenderUtility(RentAgreement ra) {
			this.ra = ra;
		}

		@Override
		public void run() {
			sendMail(ra);
		}

		@Override
		public synchronized void start() {
			super.start();
		}

		public void sendMail(RentAgreement rentAgreement) {
			// Recipient's email ID needs to be mentioned.
			String to = rentAgreement.getTenantEmail();

			// Sender's email ID needs to be mentioned
			String from = "saihomesmailsender@gmail.com";

	        final String username = "saihomesmailsender@gmail.com";
			final String password = "padmavati";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });

	        
			try {
				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				// Set Subject: header field
				message.setSubject("Rent Agreement Expiring on " + sdf.format(rentAgreement.getAgreementToDate()));

				// Now set the actual message
				StringBuffer sb = new StringBuffer();

				sb.append("Hi " + rentAgreement.getRentedTo());
				sb.append("\n\t");
				sb.append(
						"This is to inform you that the Agreement period for the flat occupied on rent by you will be going to expire on "
								+ sdf.format(rentAgreement.getAgreementToDate()));
				sb.append("\n\t");
				sb.append("If you wish to extend the agreement please contact Mr. Kiran D. Kamble on 9999999999");
				sb.append("\n\t");
				sb.append("Regards,\n");
				sb.append("Kiran D. Kamble\n");
				sb.append("(Priprietor)\n");
				sb.append("Sai Homes Real Estate Agency");
				message.setText(sb.toString());
				// Send message
				Transport.send(message);
				
				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}
	}

}
