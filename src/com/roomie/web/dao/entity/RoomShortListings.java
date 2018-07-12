package com.roomie.web.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_SHORT_LISTINGS")
public class RoomShortListings implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SHORT_LISTING_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shortListingId;
	
	@Column(name="SHORT_LISTING_TYPE")
	private String shortListingType;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="SHORT_LISTING_USER_EMAIL")
	private String shortListingUserEmail;
	
	@Column(name="SHORT_LISTING_DATE_TIME")
	private String shortListingDateTime;
	
	public RoomShortListings(){
		
	}

	public Long getShortListingId() {
		return shortListingId;
	}

	public void setShortListingId(Long shortListingId) {
		this.shortListingId = shortListingId;
	}

	public String getShortListingType() {
		return shortListingType;
	}

	public void setShortListingType(String shortListingType) {
		this.shortListingType = shortListingType;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getShortListingUserEmail() {
		return shortListingUserEmail;
	}

	public void setShortListingUserEmail(String shortListingUserEmail) {
		this.shortListingUserEmail = shortListingUserEmail;
	}

	public String getShortListingDateTime() {
		return shortListingDateTime;
	}

	public void setShortListingDateTime(String shortListingDateTime) {
		this.shortListingDateTime = shortListingDateTime;
	}
}
