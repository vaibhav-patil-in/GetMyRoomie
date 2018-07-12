package com.roomie.web.core.service;

public interface IEmailService {
	
	public void sendOtpEmail(String firstName, String email, String otp);
	
	public void sendPasswordRecoveryEmail(String firstName, String email, String otp);
}
