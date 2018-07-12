package com.roomie.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.roomie.web.businesslogic.IBusinessLogic;
import com.roomie.web.config.ConfigurationManager;
import com.roomie.web.dao.entity.User;

@Controller
public class UserController {

	protected final static Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	private IBusinessLogic businessLogic;
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure() {
		logger.debug("-------Login failed--------");
		String message = ConfigurationManager.INSTANCE.get().getProperty("login.failure.message");
		return "redirect:/login?message="+message;
	}
	
	/**
	 * This method is used for registering a user.
	 * @param ModelMap, User
	 * @return registers a user in application
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(ModelMap map, User user)
    {
		logger.debug("Start - In registerUser()- Registration started for user"+user.getUserEmail());
		String message ="";
		try{
			message = businessLogic.registerUser(user);
			map.put("message", message);
		}catch (Exception e) {
			logger.debug("Exception - In registerUser()- Error occurred in registration"+e.getStackTrace());
		}
        logger.debug("End - In registerUser()- user registered successfully"+user.getUserEmail());
        return "messagePage";
    }
	
	/**
	 * This method is used for verifying the OTP associated with user email.
	 * @param email, otp
	 * @return activates user, so that user can login and use the application.
	 */
	@RequestMapping(value = "/verifyEmail")
	public String verifyEmail(ModelMap map, @RequestParam(required=true) String param){
		logger.debug("Start - In verifyEmail()- Activation process started for user"+param);
		try{
			businessLogic.verifyEmail(param);
			String message = ConfigurationManager.INSTANCE.get().getProperty("user.activated.message");
			map.put("message", message);
		}catch (Exception e) {
			logger.debug("Start - In verifyEmail()-Error occured in verifying user"+param);
		}
		logger.debug("Start - In verifyEmail()- Activation process completed."+param+" activated sucessfully");
	    return "messagePage";
	}
	
	/**
	 * This method is used for checking if the email exist to recover the password.
	 * @param ModelMap, User
	 * @return sends email to email address to recover the user password.
	 */
	@RequestMapping(value = "/recoverPassword", method = RequestMethod.POST)
    public String recoverPassword(ModelMap map, User user)
    {
		logger.debug("Start - In recoverPassword()- recovery started for user"+user.getUserEmail());
		String message ="";
		try{
			message = businessLogic.recoverPassword(user.getUserEmail());
			map.put("message", message);
		}catch (Exception e) {
			logger.debug("Exception - In recoverPassword()- Error occurred in recoverPassword"+e.getStackTrace());
		}
        logger.debug("End - In recoverPassword()- user password recovered successfully"+user.getUserEmail());
        return "messagePage";
    }


	/**
	 * This method is used for verifying the OTP associated with user email.
	 * @param email, otp
	 * @return activates user, so that user can login and use the application.
	 */
	@RequestMapping(value = "/changePassword")
	public String changePassword(ModelMap map, @RequestParam(required=true) String param){
		logger.debug("Start - In changePassword()- Activation process started for user"+param);
		try{
			String userEmail = businessLogic.verifyEmail(param);
			String message = ConfigurationManager.INSTANCE.get().getProperty("new.password.message");
			map.put("userEmail", userEmail);
			map.put("message", message);
		}catch (Exception e) {
			logger.debug("Start - In changePassword()-Error occured in verifying user"+param);
		}
		logger.debug("Start - In changePassword()- Activation process completed."+param+" activated sucessfully");
	    return "changePassword";
	}
	
	/**
	 * This method is used for verifying the OTP associated with user email.
	 * @param email, otp
	 * @return activates user, so that user can login and use the application.
	 */
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String updatePassword(ModelMap map, User user){
		logger.debug("Start - In updatePassword()- Activation process started for user");
		try{
			String message = businessLogic.updatePassword(user);
			map.put("message", message);
		}catch (Exception e) {
			logger.debug("Start - In changePassword()-Error occured in verifying user");
		}
		logger.debug("Start - In changePassword()- Activation process completed.");
	    return "messagePage";
	}
}