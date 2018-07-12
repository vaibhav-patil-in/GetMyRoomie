package com.roomie.web.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.google.appengine.api.datastore.Text;

@Entity
@Table(name = "USER")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_GENDER")
	private String userGender;
	
	@Column(name="USER_AGE")
	private String userAge;
	
	@Column(name="USER_MOBILE_NUMBER")
	private String userMobileNumber;
	
	@Column(name="SHOW_USER_MOBILE_NUMBER")
	private String showUserMobileNumber;
	
	@Column(name="USER_OCCUPATION")
	private String userOccupation;
	
	@Column(name="USER_HAVE_PETS")
	private String userHavePets;
	
	@Column(name="USER_DRINK")
	private String userDrink;
	
	@Column(name="USER_SMOKE")
	private String userSmoke;
	
	@Column(name="USER_ABOUTME")
	private String userAboutMe;
	
	@Column(name="USER_OTP")
	private String userOtp;
	
	@Column(name="USER_STATUS")
	private String userStatus;
	
	@Column(name="USER_CREATED_DATE")
	private String userCreatedDate;
	
	@Column(name="USER_MODIFIED_DATE")
	private String userModifiedDate;

	@Column(name="USER_PROFILE_IMAGE")
    private Text userProfileimageText;
	private String userProfileimage;

	public User(){
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return StringUtils.upperCase(userEmail);
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = StringUtils.upperCase(userEmail);
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	
	public String getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	
	public String getShowUserMobileNumber() {
		return showUserMobileNumber;
	}

	public void setShowUserMobileNumber(String showUserMobileNumber) {
		this.showUserMobileNumber = showUserMobileNumber;
	}

	public String getUserOccupation() {
		return userOccupation;
	}

	public void setUserOccupation(String userOccupation) {
		this.userOccupation = userOccupation;
	}
	
	public String getUserHavePets() {
		return userHavePets;
	}

	public void setUserHavePets(String userHavePets) {
		this.userHavePets = userHavePets;
	}

	public String getUserDrink() {
		return userDrink;
	}

	public void setUserDrink(String userDrink) {
		this.userDrink = userDrink;
	}

	public String getUserSmoke() {
		return userSmoke;
	}

	public void setUserSmoke(String userSmoke) {
		this.userSmoke = userSmoke;
	}

	public String getUserAboutMe() {
		return userAboutMe;
	}

	public void setUserAboutMe(String userAboutMe) {
		this.userAboutMe = userAboutMe;
	}

	public String getUserOtp() {
		return userOtp;
	}

	public void setUserOtp(String userOtp) {
		this.userOtp = userOtp;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(String userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public String getUserModifiedDate() {
		return userModifiedDate;
	}

	public void setUserModifiedDate(String userModifiedDate) {
		this.userModifiedDate = userModifiedDate;
	}
	
	public Text getUserProfileimageText() {
		return userProfileimageText;
	}

	public void setUserProfileimageText(Text userProfileimageText) {
		this.userProfileimageText = userProfileimageText;
	}

	public String getUserProfileimage() {
		return userProfileimage;
	}

	public void setUserProfileimage(String userProfileimage) {
		this.userProfileimage = userProfileimage;
	}
}