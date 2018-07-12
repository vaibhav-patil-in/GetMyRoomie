package com.roomie.web.core.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.roomie.web.core.service.ICurrentUserDetailsService;

public class CurrentUserDetailsServiceImpl implements ICurrentUserDetailsService {

	protected final static Log logger = LogFactory.getLog(CurrentUserDetailsServiceImpl.class);

	@Override
	public String getCurrentUserEmail() {
		logger.debug("Start---getCurrentUserEmail()");
		String userEmail=null;
		try{
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				userEmail = ((UserDetails)principal).getUsername();
			} else {
				userEmail = principal.toString();
			}
		}catch (Exception e) {
			logger.error("Error occured in getting current user email from session"+e.getStackTrace());
		}
		logger.debug("End---getCurrentUserEmail()");
		return StringUtils.upperCase(userEmail);
	}
}
