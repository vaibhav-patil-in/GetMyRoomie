package com.roomie.web.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.google.appengine.api.datastore.Text;

@Entity
@Table(name = "ROOM_LIST")
public class RoomList {
	
	@Id
	@Column(name="ROOM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomId;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="ROOM_HEAD_LINE")
	private String roomHeadLine;
	
	@Column(name="ABOUT_ROOM")
	private String aboutRoom;
	
	@Column(name="NUMBER_OF_ROOMS")
	private String numberOfRooms;
	
	@Column(name="NUMBER_OF_ROOMMATES")
	private String numberOfRoomMates;
	
	@Column(name="MINIMUM_STAY")
	private String minimumStay;
	
	@Column(name="MONTHLY_RENT")
	private String monthlyRent;
	
	@Column(name="AVAILABLE_FROM_DATE")
	private String availableFromDate;
	
	@Column(name="ROOM_IN_CITY")
	private String roomInCity;
	
	@Column(name="ROOM_AREA_IN_CITY")
	private String roomAreaInCity;
	
	@Column(name="ROOM_POSTAL_CODE")
	private String roomPostalCode;
	
	@Column(name="ROOM_ADDRESS")
	private String roomAddress;
	
	@Column(name="PROPERTY_TYPE")
	private String propertyType;
	
	@Column(name="ROOM_RELATION")
	private String roomRelation;
	
	@Column(name="ROOM_ACCOMODATES")
	private String roomAccomodates;
	
	@Column(name="ROOM_FURNISHING_TYPE")
	private String roomFurnishingType;
	
	@Column(name="COOKING_AT_HOME")
	private String cookingAtHome;
	
	@Column(name="ARE_PETS_IN_HOUSE")
	private String arePetsInHouse;
	
	@Column(name="ARE_SMOKER_IN_HOUSE")
	private String areSmokersInHouse;
	
	@Column(name="ARE_DRINKER_IN_HOUSE")
	private String areDrinkersInHouse;
	
	@Column(name="ROOM_AMENITIES")
	private String roomAmenities;
	
	@Column(name="MATE_PREFER_TOLIVE_WITH")
	private String matePreferToLiveWith;
	
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
	
	@Column(name="ROOM_LIST_STATUS")
	private String roomListStatus;
	
	@Column(name="ROOM_LIST_CREATED_DATE")
	private String roomListCreatedDate;
	
	@Column(name="ROOM_LIST_MODIFIED_DATE")
	private String roomListModifiedDate;
	
	@Column(name="ROOM_LIST_IMAGE1")
	private Text roomListingImageText1;
	private String roomListingImage1;
	
	@Column(name="ROOM_LIST_IMAGE2")
	private Text roomListingImageText2;
	private String roomListingImage2;
	
	@Column(name="ROOM_LIST_IMAGE3")
	private Text roomListingImageText3;
	private String roomListingImage3;
	
	@Column(name="ROOM_LIST_IMAGE4")
	private Text roomListingImageText4;
	private String roomListingImage4;
	
	@Column(name="ROOM_LIST_IMAGE5")
	private Text roomListingImageText5;
	private String roomListingImage5;
	
	@Column(name="ROOM_LIST_IMAGE6")
	private Text roomListingImageText6;
	private String roomListingImage6;
	
	public RoomList(){	
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getUserEmail() {
		return StringUtils.upperCase(userEmail);
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = StringUtils.upperCase(userEmail);
	}

	public String getRoomHeadLine() {
		return roomHeadLine;
	}

	public void setRoomHeadLine(String roomHeadLine) {
		this.roomHeadLine = roomHeadLine;
	}

	public String getAboutRoom() {
		return aboutRoom;
	}

	public void setAboutRoom(String aboutRoom) {
		this.aboutRoom = aboutRoom;
	}

	public String getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getNumberOfRoomMates() {
		return numberOfRoomMates;
	}

	public void setNumberOfRoomMates(String numberOfRoomMates) {
		this.numberOfRoomMates = numberOfRoomMates;
	}

	public String getMinimumStay() {
		return minimumStay;
	}

	public void setMinimumStay(String minimumStay) {
		this.minimumStay = minimumStay;
	}

	public String getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	public String getAvailableFromDate() {
		return availableFromDate;
	}

	public void setAvailableFromDate(String availableFromDate) {
		this.availableFromDate = availableFromDate;
	}

	public String getRoomInCity() {
		return roomInCity;
	}

	public void setRoomInCity(String roomInCity) {
		this.roomInCity = roomInCity;
	}

	public String getRoomAreaInCity() {
		return roomAreaInCity;
	}

	public void setRoomAreaInCity(String roomAreaInCity) {
		this.roomAreaInCity = roomAreaInCity;
	}

	public String getRoomPostalCode() {
		return roomPostalCode;
	}

	public void setRoomPostalCode(String roomPostalCode) {
		this.roomPostalCode = roomPostalCode;
	}

	public String getRoomAddress() {
		return roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getRoomRelation() {
		return roomRelation;
	}

	public void setRoomRelation(String roomRelation) {
		this.roomRelation = roomRelation;
	}

	public String getRoomAccomodates() {
		return roomAccomodates;
	}

	public void setRoomAccomodates(String roomAccomodates) {
		this.roomAccomodates = roomAccomodates;
	}

	public String getRoomFurnishingType() {
		return roomFurnishingType;
	}

	public void setRoomFurnishingType(String roomFurnishingType) {
		this.roomFurnishingType = roomFurnishingType;
	}

	public String getCookingAtHome() {
		return cookingAtHome;
	}

	public void setCookingAtHome(String cookingAtHome) {
		this.cookingAtHome = cookingAtHome;
	}

	public String getArePetsInHouse() {
		return arePetsInHouse;
	}

	public void setArePetsInHouse(String arePetsInHouse) {
		this.arePetsInHouse = arePetsInHouse;
	}

	public String getAreSmokersInHouse() {
		return areSmokersInHouse;
	}

	public void setAreSmokersInHouse(String areSmokersInHouse) {
		this.areSmokersInHouse = areSmokersInHouse;
	}

	public String getAreDrinkersInHouse() {
		return areDrinkersInHouse;
	}

	public void setAreDrinkersInHouse(String areDrinkersInHouse) {
		this.areDrinkersInHouse = areDrinkersInHouse;
	}

	public String getRoomAmenities() {
		return roomAmenities;
	}

	public void setRoomAmenities(String roomAmenities) {
		this.roomAmenities = roomAmenities;
	}

	public String getMatePreferToLiveWith() {
		return matePreferToLiveWith;
	}

	public void setMatePreferToLiveWith(String matePreferToLiveWith) {
		this.matePreferToLiveWith = matePreferToLiveWith;
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

	public String getRoomListStatus() {
		return roomListStatus;
	}

	public void setRoomListStatus(String roomListStatus) {
		this.roomListStatus = roomListStatus;
	}

	public String getRoomListCreatedDate() {
		return roomListCreatedDate;
	}

	public void setRoomListCreatedDate(String roomListCreatedDate) {
		this.roomListCreatedDate = roomListCreatedDate;
	}

	public String getRoomListModifiedDate() {
		return roomListModifiedDate;
	}

	public void setRoomListModifiedDate(String roomListModifiedDate) {
		this.roomListModifiedDate = roomListModifiedDate;
	}

	public Text getRoomListingImageText1() {
		return roomListingImageText1;
	}

	public void setRoomListingImageText1(Text roomListingImageText1) {
		this.roomListingImageText1 = roomListingImageText1;
	}

	public String getRoomListingImage1() {
		return roomListingImage1;
	}

	public void setRoomListingImage1(String roomListingImage1) {
		this.roomListingImage1 = roomListingImage1;
	}

	public Text getRoomListingImageText2() {
		return roomListingImageText2;
	}

	public void setRoomListingImageText2(Text roomListingImageText2) {
		this.roomListingImageText2 = roomListingImageText2;
	}

	public String getRoomListingImage2() {
		return roomListingImage2;
	}

	public void setRoomListingImage2(String roomListingImage2) {
		this.roomListingImage2 = roomListingImage2;
	}

	public Text getRoomListingImageText3() {
		return roomListingImageText3;
	}

	public void setRoomListingImageText3(Text roomListingImageText3) {
		this.roomListingImageText3 = roomListingImageText3;
	}

	public String getRoomListingImage3() {
		return roomListingImage3;
	}

	public void setRoomListingImage3(String roomListingImage3) {
		this.roomListingImage3 = roomListingImage3;
	}

	public Text getRoomListingImageText4() {
		return roomListingImageText4;
	}

	public void setRoomListingImageText4(Text roomListingImageText4) {
		this.roomListingImageText4 = roomListingImageText4;
	}

	public String getRoomListingImage4() {
		return roomListingImage4;
	}

	public void setRoomListingImage4(String roomListingImage4) {
		this.roomListingImage4 = roomListingImage4;
	}

	public Text getRoomListingImageText5() {
		return roomListingImageText5;
	}

	public void setRoomListingImageText5(Text roomListingImageText5) {
		this.roomListingImageText5 = roomListingImageText5;
	}

	public String getRoomListingImage5() {
		return roomListingImage5;
	}

	public void setRoomListingImage5(String roomListingImage5) {
		this.roomListingImage5 = roomListingImage5;
	}

	public Text getRoomListingImageText6() {
		return roomListingImageText6;
	}

	public void setRoomListingImageText6(Text roomListingImageText6) {
		this.roomListingImageText6 = roomListingImageText6;
	}
	
	public String getRoomListingImage6() {
		return roomListingImage6;
	}

	public void setRoomListingImage6(String roomListingImage6) {
		this.roomListingImage6 = roomListingImage6;
	}
}