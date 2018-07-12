package com.roomie.web.core.service.restful;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vaibhav.Patil This class holds the JSON Response
 */
@XmlRootElement
public class JSONResponseWrapper {

	Update update = new Update();
	
	public JSONResponseWrapper() {

	}

	public JSONResponseWrapper(Update update) {
		super();
		this.update = update;
	}

	@XmlElement
	public Update getUpdate() {
		return update;
	}

	public void setUpdate(Update update) {
		this.update = update;
	}
}
