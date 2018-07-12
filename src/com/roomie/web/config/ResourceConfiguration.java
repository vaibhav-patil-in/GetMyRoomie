package com.roomie.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.roomie.web.WebAppConstants;


public class ResourceConfiguration implements Configuration {

	private static final long serialVersionUID = -8773420378010420128L;

	protected final static Log logger = LogFactory.getLog(ResourceConfiguration.class);
	private Properties properties = new Properties();
	//Used to identify the environment like QA, UAT and PROD.
	private static String envType = System.getProperty("ROOMIEAPP_ENV");

	public ResourceConfiguration() {

		logger.debug("ResourceConfiguration Called");
		logger.debug("Started Loading properties------>");

		//Loading properties form properties.xml file.
		InputStream propertiesStream = ResourceConfiguration.class.getResourceAsStream("/config/properties.xml");
		InputStream dBMappingPropStream = ResourceConfiguration.class.getResourceAsStream("/config/dbmapping.properties");
		InputStream staticTextStream = ResourceConfiguration.class.getResourceAsStream("/config/static-text.properties");
 
		try {
			properties.loadFromXML(propertiesStream);
			properties.load(dBMappingPropStream);
			properties.load(staticTextStream);

			if (StringUtils.isNotBlank(envType)) {
				properties.put(WebAppConstants.ENV_PROPERTY, envType);
			} else {
				properties.put(WebAppConstants.ENV_PROPERTY, WebAppConstants.ENV_NAME_DEV);
			}

		} catch (Exception e) {
			logger.info("Error Loading Properties");
		} finally {
			try {
				propertiesStream.close();
				dBMappingPropStream.close();
				staticTextStream.close();
			} catch (IOException e) {
				logger.info("Error occured While closing the configuration resource streams.");
			}
		}
		logger.debug("End Loading properties------>");
	}

	@Override
	public String getProperty(String key) {
		String value = "";

		//For environment specific variable the key will be suffixed with QA or UAT, for development environment webapp.env will be DEV
		String envSpecificKey = key + "." + envType;

		if (StringUtils.isNotBlank(envType) && properties != null && properties.containsKey(envSpecificKey)) {
			value = properties.getProperty(envSpecificKey);
		} else {
			value = properties.getProperty(key);
		}

		if (StringUtils.isNotBlank(value))
		{
			return value;
		}

		return value;
	}

	@Override
	public String getProperty(String key, String countryCode) {
		String value = null;
		if (StringUtils.isNotBlank(countryCode)) {
			value = getProperty(key + "." + StringUtils.lowerCase(countryCode));
		}
		if (StringUtils.isBlank(value)) {
			value = getProperty(key);
		}
		return value;
	}
}
