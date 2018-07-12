package com.roomie.web.core.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.roomie.web.businesslogic.IBusinessLogic;
import com.roomie.web.config.ConfigurationManager;
import com.roomie.web.core.utility.CipherUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	protected final static Log logger = LogFactory.getLog(CustomUserDetailsService.class);
	
	@Autowired
	private IBusinessLogic businessLogic;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail)throws UsernameNotFoundException {
		logger.debug("Start --loadUserByUsername() for verifying user credentials");
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		com.roomie.web.dao.entity.User user = businessLogic.findUserByUserEmail(userEmail);
		
		return new org.springframework.security.core.userdetails.User(
				user.getUserEmail(), 
				CipherUtils.decrypt(user.getUserPassword(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.password")),
				enabled,
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,
				getAuthorities(1));
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}
	
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();
		
		if (role.intValue() == 1) {
			roles.add("ROLE_USER");
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
		}
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
