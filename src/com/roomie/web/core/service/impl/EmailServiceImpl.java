package com.roomie.web.core.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.roomie.web.config.ConfigurationManager;
import com.roomie.web.core.service.IEmailService;
import com.roomie.web.core.utility.CipherUtils;

public class EmailServiceImpl implements IEmailService {
	
	protected final static Log logger = LogFactory.getLog(EmailServiceImpl.class);

	@Override
	public void sendOtpEmail(String userName, String email, String otp) {
		logger.debug("Start---sendOtpEmail() for--"+email);
		String param = "email="+email+"#otp="+otp;
		String encryptedParam = CipherUtils.encrypt(param, ConfigurationManager.INSTANCE.get().getProperty("cipher.key.otp.param"));
		String subject = ConfigurationManager.INSTANCE.get().getProperty("activate.account.email.subject");
        String msgBody="";
		try {
			msgBody = "Hello "+ userName+"\n\n"+
					"Welcome to GetMyRoomie.com"+"\n\n"+
					"Please click on the link bellow to verify your email.\n\n"+
					"http://www.getmyroomie.com/verifyEmail?param="+URLEncoder.encode(encryptedParam,"ISO-8859-1")+
					"\n\n\n"+
					"Thanks,\n"+
					"GetMyRoomie";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sendEmailNotificationFromAdmin(email, userName, subject, msgBody);
		
        logger.debug("End---sendOtpEmail() for--"+email);
	}
	
	@Override
	public void sendPasswordRecoveryEmail(String userName, String email, String otp) {
		logger.debug("Start---sendOtpEmail() for--"+email);
		String param = "email="+email+"#otp="+otp;
		String encryptedParam = CipherUtils.encrypt(param, ConfigurationManager.INSTANCE.get().getProperty("cipher.key.otp.param"));
		String subject = ConfigurationManager.INSTANCE.get().getProperty("change.password.subject");
        String msgBody="";
		try {
			msgBody = "Hello "+ userName+"\n\n"+
					"Welcome to GetMyRoomie.com"+"\n\n"+
					"Please click on the link bellow to change your password.\n\n"+
					"http://www.getmyroomie.com/changePassword?param="+URLEncoder.encode(encryptedParam,"ISO-8859-1")+
					"\n\n\n"+
					"Thanks,\n"+
					"GetMyRoomie";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sendEmailNotificationFromAdmin(email, userName, subject, msgBody);
		
        logger.debug("End---sendOtpEmail() for--"+email);
	}
	
	//Common API for send email notifications from Administrator.
	public void sendEmailNotificationFromAdmin(String email, String userName, String subject, String msgBody){
		logger.debug("Start---sendEmailNotification() for--"+email);
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        try {
        	Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(ConfigurationManager.INSTANCE.get().getProperty("admin.email"),ConfigurationManager.INSTANCE.get().getProperty("getmyroomie.admin.name")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email, userName));
	        msg.setSubject(subject);
	        msg.setText(msgBody);
	        Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
			logger.error("Error occured in sedning mail...Encoding issue"+e.getStackTrace());
		} catch (MessagingException e) {
			logger.error("Error occured in sedning mail...Messaging issue"+e.getStackTrace());
		}
        logger.debug("End---sendEmailNotification() for--"+email);	
	}
}
