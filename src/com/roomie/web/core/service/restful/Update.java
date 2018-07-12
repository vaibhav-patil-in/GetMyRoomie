package com.roomie.web.core.service.restful;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.roomie.web.dao.entity.MyMateListing;
import com.roomie.web.dao.entity.MyRoomListing;

@XmlRootElement
public class Update {

	private String errorMessage;
	private String successMessage;
	private String passwordRecoveryEmailNotExist;
	private List<MyMateListing> myMateListingList;
	private List<MyRoomListing> myRoomListingList;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPasswordRecoveryEmailNotExist() {
		return passwordRecoveryEmailNotExist;
	}

	public void setPasswordRecoveryEmailNotExist(
			String passwordRecoveryEmailNotExist) {
		this.passwordRecoveryEmailNotExist = passwordRecoveryEmailNotExist;
	}

	public List<MyMateListing> getMyMateListingList() {
		return myMateListingList;
	}

	public void setMyMateListingList(List<MyMateListing> myMateListingList) {
		this.myMateListingList = myMateListingList;
	}

	public List<MyRoomListing> getMyRoomListingList() {
		return myRoomListingList;
	}

	public void setMyRoomListingList(List<MyRoomListing> myRoomListingList) {
		this.myRoomListingList = myRoomListingList;
	}
}
