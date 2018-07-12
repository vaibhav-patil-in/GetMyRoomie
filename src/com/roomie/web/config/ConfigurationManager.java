package com.roomie.web.config;

public enum ConfigurationManager {
	INSTANCE;

	Configuration configuration;

	public Configuration get() {
		if (configuration == null) {
			configuration = new ResourceConfiguration();
		}
		return configuration;
	}
}
