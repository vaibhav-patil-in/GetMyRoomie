package com.roomie.web.config;

import java.io.Serializable;

public interface Configuration extends Serializable {

	public String getProperty(String key);
	public String getProperty(String key, String countryCode);
}
