package com.roomie.web.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EMFService {
	
	protected final static Log logger = LogFactory.getLog(EMFService.class);
	
	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");

	private EMFService() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
