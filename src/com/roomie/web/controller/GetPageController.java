package com.roomie.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetPageController {

	protected final static Log logger = LogFactory.getLog(GetPageController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(){
		logger.debug("-----Homepage Called--------");
        return "home";
    }
	
	@RequestMapping(value = "/login")
    public String getLogin(ModelMap map, @RequestParam(required=false) String message){
		logger.debug("-----Login Called--------");
		map.put("message", message);
		return "loginUser";
    }
	
	@RequestMapping(value = "/getRegister", method = RequestMethod.GET)
	public String getRegister(){
		logger.debug("-----Register Called--------");
		return "registerUser";
	}
	
	@RequestMapping(value = "/getPasswordRecovery", method = RequestMethod.GET)
	public String getPasswordRecovery(){
		logger.debug("-----Password recovery Called--------");
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/getMessagePage")
    public String getMessagePage(ModelMap map, @RequestParam(required=true) String param, @RequestParam(required=false) String msgSubject){
		logger.debug("Start---getMessagePage()");
		map.put("msgReceiverEmail", param);
		map.put("msgSubject", msgSubject);
		logger.debug("End---getMessagePage()");
        return "emailMessagePage";
    }

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getErrorPage(){
		logger.debug("-----An error occurred--------");
		return "errorPage";
	}
}
