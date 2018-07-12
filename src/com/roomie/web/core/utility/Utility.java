package com.roomie.web.core.utility;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Utility {
	
	protected final static Log logger = LogFactory.getLog(Utility.class);
	
	/**
	 * This method is used for generating random alphanumeric strings
	 * @param length
	 * @return a random alphanumeric string of specified length
	 */
	public static String getRandomAlphanumericString(int length){
		logger.debug("Start--getRandomAlphanumericString()");
		StringBuilder sb = new StringBuilder();
		try{
			Random rnd = new Random();
			final String sample = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			final int range = sample.length();
			for(int i = 0; i < length; i++) {
				sb.append(sample.charAt(rnd.nextInt(range)));
			}
		}catch (Exception e) {
			logger.error("Error occured in getting radom 8 alphanumeric code"+e.getStackTrace());
		}
		logger.debug("End--getRandomAlphanumericString()");
		return sb.toString();
	}
	
}
