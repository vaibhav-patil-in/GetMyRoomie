package com.roomie.web.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "ROOM_MATE_LIST")
public class RoomMateList {
	
	@Id
	@Column(name="ROOM_MATE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomMateId;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="LOOKIN_IN_CITY")
	private String lookingInCity;
	
	@Column(name="LOOKIN_FOR_AREA")
	private String lookingforArea;

	@Column(name="PROFILE_HEADLINE")
	private String profileHeadLine;
	
	@Column(name="RENTING_FOR_MONTHS")
	private String rentingForMonth;
	
	@Column(name="MONTHLY_BUDGET")
	private String monthlyBudget;
	
	@Column(name="MOVE_IN_DATE")
	private String moveInDate;
	
	@Column(name="MATE_GENDER")
	private String mateGender;
	
	@Column(name="MATE_OCCUPATION")
	private String mateOccupation;
	
	@Column(name="MATE_PETS_ALLOWED")
	private String matePetsAllowed;
	
	@Column(name="MATE_SMOKING_ALLOWED")
	private String mateSmokingAllowed;
	
	@Column(name="MATE_DRINKING_ALLOWED")
	private String mateDrinkingAllowed;
	
	@Column(name="MATE_PREFER_TOLIVE_WITH")
	private String matePreferToLiveWith;
	
	@Column(name="MATE_LIST_STATUS")
	private String mateListStatus;
	
	@Column(name="MATE_LIST_CREATED_DATE")
	private String mateListCreatedDate;
	
	@Column(name="MATE_LIST_MODIFIED_DATE")
	private String mateListModifiedDate;
	
	public RoomMateList(){
		
	}

	public Long getRoomMateId() {
		return roomMateId;
	}

	public void setRoomMateId(Long roomMateId) {
		this.roomMateId = roomMateId;
	}

	public String getUserEmail() {
		return StringUtils.upperCase(userEmail);
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = StringUtils.upperCase(userEmail);
	}
	
	public String getLookingInCity() {
		return lookingInCity;
	}

	public void setLookingInCity(String lookingInCity) {
		this.lookingInCity = lookingInCity;
	}

	public String getLookingforArea() {
		return lookingforArea;
	}

	public void setLookingforArea(String lookingforArea) {
		this.lookingforArea = lookingforArea;
	}

	public String getProfileHeadLine() {
		return profileHeadLine;
	}

	public void setProfileHeadLine(String profileHeadLine) {
		this.profileHeadLine = profileHeadLine;
	}

	public String getRentingForMonth() {
		return rentingForMonth;
	}

	public void setRentingForMonth(String rentingForMonth) {
		this.rentingForMonth = rentingForMonth;
	}

	public String getMonthlyBudget() {
		return monthlyBudget;
	}

	public void setMonthlyBudget(String monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}

	public String getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(String moveInDate) {
		this.moveInDate = moveInDate;
	}

	public String getMateGender() {
		return mateGender;
	}

	public void setMateGender(String mateGender) {
		this.mateGender = mateGender;
	}

	public String getMateOccupation() {
		return mateOccupation;
	}

	public void setMateOccupation(String mateOccupation) {
		this.mateOccupation = mateOccupation;
	}

	public String getMatePetsAllowed() {
		return matePetsAllowed;
	}

	public void setMatePetsAllowed(String matePetsAllowed) {
		this.matePetsAllowed = matePetsAllowed;
	}

	public String getMateSmokingAllowed() {
		return mateSmokingAllowed;
	}

	public void setMateSmokingAllowed(String mateSmokingAllowed) {
		this.mateSmokingAllowed = mateSmokingAllowed;
	}

	public String getMateDrinkingAllowed() {
		return mateDrinkingAllowed;
	}

	public void setMateDrinkingAllowed(String mateDrinkingAllowed) {
		this.mateDrinkingAllowed = mateDrinkingAllowed;
	}

	public String getMatePreferToLiveWith() {
		return matePreferToLiveWith;
	}

	public void setMatePreferToLiveWith(String matePreferToLiveWith) {
		this.matePreferToLiveWith = matePreferToLiveWith;
	}

	public String getMateListStatus() {
		return mateListStatus;
	}

	public void setMateListStatus(String mateListStatus) {
		this.mateListStatus = mateListStatus;
	}

	public String getMateListCreatedDate() {
		return mateListCreatedDate;
	}

	public void setMateListCreatedDate(String mateListCreatedDate) {
		this.mateListCreatedDate = mateListCreatedDate;
	}

	public String getMateListModifiedDate() {
		return mateListModifiedDate;
	}

	public void setMateListModifiedDate(String mateListModifiedDate) {
		this.mateListModifiedDate = mateListModifiedDate;
	}
}
