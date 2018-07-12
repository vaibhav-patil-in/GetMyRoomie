package com.roomie.web.businesslogic.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.appengine.api.datastore.Text;
import com.roomie.web.WebAppConstants;
import com.roomie.web.businesslogic.IBusinessLogic;
import com.roomie.web.config.ConfigurationManager;
import com.roomie.web.core.service.ICurrentUserDetailsService;
import com.roomie.web.core.service.IEmailService;
import com.roomie.web.core.utility.CipherUtils;
import com.roomie.web.core.utility.Utility;
import com.roomie.web.dao.IDaoFactory;
import com.roomie.web.dao.entity.Message;
import com.roomie.web.dao.entity.MyMateListing;
import com.roomie.web.dao.entity.MyRoomListing;
import com.roomie.web.dao.entity.RoomList;
import com.roomie.web.dao.entity.RoomMateList;
import com.roomie.web.dao.entity.RoomShortListings;
import com.roomie.web.dao.entity.User;

public class BusinessLogicImpl implements IBusinessLogic {

	protected final static Log logger = LogFactory.getLog(BusinessLogicImpl.class);

	@Autowired
	private IDaoFactory daoFactory;
	
	@Autowired 
	private ICurrentUserDetailsService currentUserDetailsService;
	
	@Autowired 
	IEmailService emailService;
	
	@Override
	public String registerUser(User user) {
		logger.debug("Start---registerUser()");
		String message ="";
		try{
			//Check if user with specified email already exists.
			User userCheck = daoFactory.findUserByUserEmail(user.getUserEmail());
			if(userCheck!=null){
				message = ConfigurationManager.INSTANCE.get().getProperty("register.user.email.alreadyExist");
				return message;
			}
			
			//TODO Validate Input fields.
		
			//Encrypt the password using AES and Base64 and then save in DB.
			user.setUserPassword(CipherUtils.encrypt(user.getUserPassword(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.password")));
		
			//Generate OTP and Send an email for it to user email ID.
			String otp = Utility.getRandomAlphanumericString(8);
			emailService.sendOtpEmail(user.getUserName(), user.getUserEmail(), otp);

			user.setUserOtp(otp.toUpperCase());
			user.setUserStatus(WebAppConstants.NOT_VERIFIED_USER);
			user.setUserCreatedDate(String.valueOf(new Date()));
			user.setUserModifiedDate(String.valueOf(new Date()));
			user.setUserProfileimageText(new Text(ConfigurationManager.INSTANCE.get().getProperty("user.default.image")));
			
			daoFactory.registerUser(user);
			message = ConfigurationManager.INSTANCE.get().getProperty("register.success.message");

		}catch (Exception e) {
			logger.error("Error occured in registering user"+user.getUserEmail());
		}
		logger.debug("End---registerUser()");
		return message;
	}
	
	@Override
	public String recoverPassword(String email){
		logger.debug("Start---recoverPassword()");
		String message ="";
		try{
			//Check if user with specified email already exists.
			User userCheck = daoFactory.findUserByUserEmail(email);
			if(userCheck == null){
				message = ConfigurationManager.INSTANCE.get().getProperty("recovery.email.not.exist");
				return message;
			}else{
				String otp = userCheck.getUserOtp();
				String userName = userCheck.getUserName();
				String userEmail = userCheck.getUserEmail();	
				emailService.sendPasswordRecoveryEmail(userName, userEmail, otp);
				message = ConfigurationManager.INSTANCE.get().getProperty("recovery.email.success");
			}
		}catch (Exception e) {
			logger.error("Error occured in registering user:"+email);
		}
		logger.debug("End---recoverPassword()");
		return message;
	}
	
	@Override
	public String updatePassword(User user){
		logger.debug("Start---updatePassword()");
		String message ="";
		try{
			daoFactory.updatePassword(user);
			message = ConfigurationManager.INSTANCE.get().getProperty("password.update.success");
		}catch (Exception e) {
			logger.error("Error occured in updating user:"+user.getUserEmail()+" :"+e.getStackTrace());
		}
		logger.debug("End---updatePassword()");
		return message;
	}

	@Override
	public User updateUser(User user) {
		logger.debug("Start---updateUser()");
		try{
			user.setUserEmail(currentUserDetailsService.getCurrentUserEmail());
			daoFactory.updateUser(user);
		}catch (Exception e) {
			logger.error("Error occured in updating user:"+user.getUserEmail()+" :"+e.getStackTrace());
		}
		logger.debug("End---updateUser()");
		return user;
	}
	
	@Override
	public RoomMateList updateRoomMateList(RoomMateList roomMate) {
		logger.debug("Start---updateUser()");
		try{
			roomMate.setUserEmail(currentUserDetailsService.getCurrentUserEmail());
			daoFactory.updateRoomMateList(roomMate);
		}catch (Exception e) {
			logger.error("Error occured in updating user:"+roomMate.getUserEmail()+" :"+e.getStackTrace());
		}
		logger.debug("End---updateUser()");
		return roomMate;
	}
	
	@Override
	public RoomList updateRoomList(RoomList room) {
		logger.debug("Start---updateUser()");
		try{
			room.setUserEmail(currentUserDetailsService.getCurrentUserEmail());
			daoFactory.updateRoomList(room);
		}catch (Exception e) {
			logger.error("Error occured in updating user:"+room.getUserEmail()+" :"+e.getStackTrace());
		}
		logger.debug("End---updateUser()");
		return room;
	}
	
	@Override
	public RoomMateList createRoomMateList(RoomMateList roomMate) {
		logger.debug("Start---createRoomMateList()");
		try{
			String currentUserEmail = currentUserDetailsService.getCurrentUserEmail();
			roomMate.setUserEmail(currentUserEmail);
			roomMate.setMateListStatus(WebAppConstants.LISTING_ACTIVE);
			roomMate.setMateListCreatedDate(String.valueOf(new Date()));
			roomMate.setMateListModifiedDate(String.valueOf(new Date()));
			daoFactory.createRoomMateList(roomMate);
		}catch (Exception e) {
			logger.error("Error occured in createRoomMateList"+roomMate.getUserEmail()+" :"+e.getStackTrace());
		}
		logger.debug("End---createRoomMateList()");
		return roomMate;
	}
	
	@Override
	public RoomList createRoomList(RoomList room) {
		logger.debug("Start---createRoomList()");
		try{
			String currentUserEmail = currentUserDetailsService.getCurrentUserEmail();
			room.setUserEmail(currentUserEmail);
			room.setRoomListStatus(WebAppConstants.LISTING_ACTIVE);
			room.setRoomListCreatedDate(String.valueOf(new Date()));
			room.setRoomListModifiedDate(String.valueOf(new Date()));
			
			/*Image setter starts*/
			if(StringUtils.isNotBlank(room.getRoomListingImage1())){
				room.setRoomListingImageText1(new Text(room.getRoomListingImage1()));
			}else{
				room.setRoomListingImageText1(new Text(ConfigurationManager.INSTANCE.get().getProperty("room.default.image")));
			}
			if(StringUtils.isNotBlank(room.getRoomListingImage2())){
				room.setRoomListingImageText2(new Text(room.getRoomListingImage2()));
			}else{
				room.setRoomListingImageText2(new Text(""));
			}
			if(StringUtils.isNotBlank(room.getRoomListingImage3())){
				room.setRoomListingImageText3(new Text(room.getRoomListingImage3()));
			}else{
				room.setRoomListingImageText3(new Text(""));
			}
			if(StringUtils.isNotBlank(room.getRoomListingImage4())){
				room.setRoomListingImageText4(new Text(room.getRoomListingImage4()));
			}else{
				room.setRoomListingImageText4(new Text(""));
			}
			if(StringUtils.isNotBlank(room.getRoomListingImage5())){
				room.setRoomListingImageText5(new Text(room.getRoomListingImage5()));
			}else{
				room.setRoomListingImageText5(new Text(""));
			}
			if(StringUtils.isNotBlank(room.getRoomListingImage6())){
				room.setRoomListingImageText6(new Text(room.getRoomListingImage6()));
			}else{
				room.setRoomListingImageText6(new Text(""));
			}
			/*Image setter ends*/
			
			daoFactory.createRoomList(room);
		}catch (Exception e) {
			logger.error("Error occured in createRoomList"+room.getUserEmail()+" :"+e.getStackTrace());
		}
		logger.debug("End---createRoomList()");
		return room;
	}
	
	@Override
	public User findUserByUserEmail(String userEmail) {
		logger.debug("Start---findUserByUserEmail()");
		return daoFactory.findUserByUserEmail(userEmail);
	}
	
	@Override
	public String verifyEmail(String param) {
		logger.debug("Start---verifyEmail()");
		String email ="";
		try{
			String encryptedParam = CipherUtils.decrypt(param, ConfigurationManager.INSTANCE.get().getProperty("cipher.key.otp.param"));
			String[] params = encryptedParam.split("#");
			email = StringUtils.substringAfter(params[0], "=");
			String otp = StringUtils.substringAfter(params[1], "=");
			logger.info("Verify email is:"+email);
			logger.info("Verify OTP is:"+otp);
			daoFactory.verifyEmail(email, otp);
		}catch (Exception e) {
			logger.error("Error occured in verifying email address:"+email+" :"+e.getStackTrace());
		}
		logger.debug("End---verifyEmail()");
		return email;
	}
	
	@Override
	public RoomMateList getAllRoomMateList() {
		logger.debug("Start---getAllRoomMateList()");
		RoomMateList roomMate =null;
		try{
			roomMate = daoFactory.getAllRoomMateListByEmail(currentUserDetailsService.getCurrentUserEmail());
		}catch (Exception e) {
			logger.error("Error occured in getAllRoomMateList()"+e.getStackTrace());
		}
		logger.debug("End---getAllRoomMateList()");
		return roomMate;
	}
	
	@Override
	public RoomList getAllRoomList() {
		logger.debug("Start---getAllRoomList()");
		RoomList room =null;
		try{
			room = daoFactory.getAllRoomListByEmail(currentUserDetailsService.getCurrentUserEmail());
			room.setRoomListingImage1(room.getRoomListingImageText1().getValue());
			room.setRoomListingImage2(room.getRoomListingImageText2().getValue());
			room.setRoomListingImage3(room.getRoomListingImageText3().getValue());
			room.setRoomListingImage4(room.getRoomListingImageText4().getValue());
			room.setRoomListingImage5(room.getRoomListingImageText5().getValue());
			room.setRoomListingImage6(room.getRoomListingImageText6().getValue());
		}catch (Exception e) {
			logger.error("Error occured in getAllRoomList()"+e.getStackTrace());
		}
		logger.debug("End---getAllRoomList()");
		return room;
	}

	@Override
	public MyMateListing getAllMyMateListing() {
		logger.debug("Start---getAllMyListing()");
		MyMateListing myListing = null;
		try{
			User user = daoFactory.findUserByUserEmail(currentUserDetailsService.getCurrentUserEmail());
			RoomMateList roomMate = daoFactory.getAllRoomMateListByEmail(currentUserDetailsService.getCurrentUserEmail());
			if(user!=null && roomMate!=null){
				myListing = new MyMateListing();
				myListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(user.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
				myListing.setUserName(user.getUserName());
				myListing.setProfileHeadLine(roomMate.getProfileHeadLine());
				myListing.setMoveInDate(roomMate.getMoveInDate());
				myListing.setMonthlyBudget(roomMate.getMonthlyBudget());
				myListing.setUserAboutMe(user.getUserAboutMe());
				myListing.setProfileImage(user.getUserProfileimageText().getValue());
				myListing.setMateListStatus(roomMate.getMateListStatus());
			}
		}catch (Exception e) {
			logger.error("Error occured in getting getAllMyListing()"+e.getStackTrace());
		}
		logger.debug("End---getAllMyListing()");
		return myListing;
	}
	
	@Override
	public MyRoomListing getAllMyRoomListing() {
		logger.debug("Start---getAllMyRoomListing()");
		MyRoomListing myListing = null;
		try{
			User user = daoFactory.findUserByUserEmail(currentUserDetailsService.getCurrentUserEmail());
			RoomList room = daoFactory.getAllRoomListByEmail(currentUserDetailsService.getCurrentUserEmail());
			if(user!=null && room!=null){
				myListing = new MyRoomListing();
				myListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(user.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
				myListing.setRoomHeadLine(room.getRoomHeadLine());
				myListing.setRoomAddress(room.getRoomAddress());
				myListing.setRoomInCity(room.getRoomInCity());
				myListing.setMonthlyRent(room.getMonthlyRent());
				myListing.setAvailableFromDate(room.getAvailableFromDate());
				myListing.setRoomListingImage1(room.getRoomListingImageText1().getValue());
				myListing.setRoomListingImage2(room.getRoomListingImageText2().getValue());
				myListing.setRoomListingImage3(room.getRoomListingImageText3().getValue());
				myListing.setRoomListingImage4(room.getRoomListingImageText4().getValue());
				myListing.setRoomListingImage5(room.getRoomListingImageText5().getValue());
				myListing.setRoomListingImage6(room.getRoomListingImageText6().getValue());
				myListing.setRoomListStatus(room.getRoomListStatus());
			}
		}catch (Exception e) {
			logger.error("Error occured in getting getAllMyRoomListing()"+e.getStackTrace());
		}
		logger.debug("End---getAllMyRoomListing()");
		return myListing;
	}

	@Override
	public User getCurrentUserProfile() {
		logger.debug("Start---getCurrentUserProfile()");
		User user = null;
		try{
			String email = currentUserDetailsService.getCurrentUserEmail();
			user = findUserByUserEmail(email);
			if(user!=null && user.getUserProfileimageText()!=null){
				user.setUserProfileimage(user.getUserProfileimageText().getValue());
			}
		}catch (Exception e) {
			logger.error("Error occured in getting profile for the user:"+user.getUserEmail()+" :"+e.getStackTrace());
		}
		logger.debug("End---getCurrentUserProfile()");
		return user;
	}

	@Override
	public User checkUserEmailExist(String userEmail) {
		logger.debug("Start---checkUserEmailExist()");
		return daoFactory.checkUserEmailExist(userEmail);
	}

	@Override
	public List<MyRoomListing> getAllRoomsList() {
		logger.debug("Start---getAllRoomsList()");
		List<MyRoomListing> roomsListingList =new ArrayList<MyRoomListing>();
		List<RoomList> roomsList =null;
		try{
			roomsList = daoFactory.getAllRoomsList();
			if(roomsList!=null && roomsList.size()>0){
				for (RoomList roomList : roomsList) {
					MyRoomListing myRoomListing = new MyRoomListing();
					myRoomListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(roomList.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
					myRoomListing.setRoomHeadLine(roomList.getRoomHeadLine());
					myRoomListing.setRoomAddress(roomList.getRoomAddress());
					myRoomListing.setRoomInCity(roomList.getRoomInCity());
					myRoomListing.setMonthlyRent(roomList.getMonthlyRent());
					myRoomListing.setAvailableFromDate(roomList.getAvailableFromDate());
					myRoomListing.setRoomListingImage1(roomList.getRoomListingImageText1().getValue());
					myRoomListing.setRoomListingImage2(roomList.getRoomListingImageText2().getValue());
					myRoomListing.setRoomListingImage3(roomList.getRoomListingImageText3().getValue());
					myRoomListing.setRoomListingImage4(roomList.getRoomListingImageText4().getValue());
					myRoomListing.setRoomListingImage5(roomList.getRoomListingImageText5().getValue());
					myRoomListing.setRoomListingImage6(roomList.getRoomListingImageText6().getValue());
					roomsListingList.add(myRoomListing);
				}
			}
		}catch (Exception e) {
			logger.error("Error occured in getAllRoomsList()"+e.getStackTrace());
		}
		logger.debug("End---getAllRoomsList()");
		return roomsListingList;
	}
	
	public List<MyMateListing> getAllMatesList(){
		logger.debug("Start---getAllMatesList()");
		List<MyMateListing> mateListingList =new ArrayList<MyMateListing>();
		List<RoomMateList> roomMateList =null;
		try{
			roomMateList = daoFactory.getAllRoomMatesList();
			if(roomMateList!=null && roomMateList.size()>0){
				for (RoomMateList roomMate : roomMateList) {
					MyMateListing myMateListing = new MyMateListing();
					//Get user details from email address.
					User user = findUserByUserEmail(roomMate.getUserEmail());
					myMateListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(roomMate.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
					myMateListing.setUserName(user.getUserName());
					myMateListing.setProfileHeadLine(roomMate.getProfileHeadLine());
					myMateListing.setMoveInDate(roomMate.getMoveInDate());
					myMateListing.setMonthlyBudget(roomMate.getMonthlyBudget());
					myMateListing.setUserAboutMe(user.getUserAboutMe());
					myMateListing.setProfileImage(user.getUserProfileimageText().getValue());
					mateListingList.add(myMateListing);
				}
			}
		}catch (Exception e) {
			logger.error("Error occured in getAllMatesList()"+e.getStackTrace());
		}
		logger.debug("End---getAllMatesList()");
		return mateListingList;
	}

	@Override
	public void updateRoomMateStatus(String status) {
		logger.debug("Start---updateRoomMateStatus()");
		String email ="";
		try{
			email = currentUserDetailsService.getCurrentUserEmail();
			daoFactory.updateRoomMateStatus(status,email);
		}catch (Exception e) {
			logger.error("Error occured in updating user:"+email+" :"+e.getStackTrace());
		}
		logger.debug("End---updateRoomMateStatus()");
	}

	@Override
	public void updateRoomStatus(String status) {
		logger.debug("Start---updateRoomMateStatus()");
		String email ="";
		try{
			email = currentUserDetailsService.getCurrentUserEmail();
			daoFactory.updateRoomStatus(status,email);
		}catch (Exception e) {
			logger.error("Error occured in updating user:"+email+" :"+e.getStackTrace());
		}
		logger.debug("End---updateRoomMateStatus()");
	}

	@Override
	public MyMateListing getRoomMateDetailsByEmail(String param) {
		logger.debug("Start---getRoomMateDetailsByEmail()");
		String email = CipherUtils.decrypt(param, ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param"));
		MyMateListing myMateListing = new MyMateListing();
		RoomMateList roomMate =null;
		try{
			User user = findUserByUserEmail(email);
			myMateListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(user.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
			myMateListing.setUserName(user.getUserName());
			myMateListing.setUserGender(user.getUserGender());
			myMateListing.setUserAge(user.getUserAge());
			myMateListing.setUserMobileNumber(user.getUserMobileNumber());
			myMateListing.setShowUserMobileNumber(user.getShowUserMobileNumber());
			myMateListing.setUserOccupation(user.getUserOccupation());
			myMateListing.setUserHavePets(user.getUserHavePets());
			myMateListing.setUserDrink(user.getUserDrink());
			myMateListing.setUserSmoke(user.getUserSmoke());
			myMateListing.setUserAboutMe(user.getUserAboutMe());
			myMateListing.setProfileImage(user.getUserProfileimageText().getValue());
			
			roomMate = daoFactory.getAllRoomMateListByEmail(email);
			myMateListing.setLookingInCity(roomMate.getLookingInCity());
			myMateListing.setLookingforArea(roomMate.getLookingforArea());
			myMateListing.setProfileHeadLine(roomMate.getProfileHeadLine());
			myMateListing.setMonthlyBudget(roomMate.getMonthlyBudget());
			myMateListing.setRentingForMonth(roomMate.getRentingForMonth());
			myMateListing.setMoveInDate(roomMate.getMoveInDate());
			myMateListing.setMateGender(roomMate.getMateGender());
			myMateListing.setMateOccupation(roomMate.getMateOccupation());
			myMateListing.setMatePetsAllowed(roomMate.getMatePetsAllowed());
			myMateListing.setMateSmokingAllowed(roomMate.getMateSmokingAllowed());
			myMateListing.setMateDrinkingAllowed(roomMate.getMateDrinkingAllowed());
			myMateListing.setMatePreferToLiveWith(roomMate.getMatePreferToLiveWith());
			
		}catch (Exception e) {
			logger.error("Error occured in getRoomMateDetailsByEmail()"+e.getStackTrace());
		}
		logger.debug("End---getRoomMateDetailsByEmail()");
		return myMateListing;
	}
	
	@Override
	public MyRoomListing  getRoomDetailsByEmail(String param){
		logger.debug("Start---getRoomDetailsByEmail()");
		String email = CipherUtils.decrypt(param, ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param"));
		MyRoomListing myRoomListing = new MyRoomListing();
		RoomList room =null;
		try{
			User user = findUserByUserEmail(email);
			myRoomListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(user.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
			myRoomListing.setUserName(user.getUserName());
			myRoomListing.setUserGender(user.getUserGender());
			myRoomListing.setUserAge(user.getUserAge());
			myRoomListing.setUserMobileNumber(user.getUserMobileNumber());
			myRoomListing.setShowUserMobileNumber(user.getShowUserMobileNumber());
			myRoomListing.setUserOccupation(user.getUserOccupation());
			myRoomListing.setUserHavePets(user.getUserHavePets());
			myRoomListing.setUserDrink(user.getUserDrink());
			myRoomListing.setUserSmoke(user.getUserSmoke());
			myRoomListing.setUserAboutMe(user.getUserAboutMe());
			myRoomListing.setUserProfileimage(user.getUserProfileimageText().getValue());
			
			room = daoFactory.getAllRoomListByEmail(email);
			myRoomListing.setRoomHeadLine(room.getRoomHeadLine());
			myRoomListing.setAboutRoom(room.getAboutRoom());
			myRoomListing.setNumberOfRoomMates(room.getNumberOfRoomMates());
			myRoomListing.setNumberOfRooms(room.getNumberOfRooms());
			myRoomListing.setMinimumStay(room.getMinimumStay());
			myRoomListing.setMonthlyRent(room.getMonthlyRent());
			myRoomListing.setAvailableFromDate(room.getAvailableFromDate());
			myRoomListing.setRoomInCity(room.getRoomInCity());
			myRoomListing.setRoomAreaInCity(room.getRoomAreaInCity());
			myRoomListing.setRoomPostalCode(room.getRoomPostalCode());
			myRoomListing.setRoomAddress(room.getRoomAddress());
			myRoomListing.setPropertyType(room.getPropertyType());
			myRoomListing.setRoomRelation(room.getRoomRelation());
			myRoomListing.setRoomAccomodates(room.getRoomAccomodates());
			myRoomListing.setRoomFurnishingType(room.getRoomFurnishingType());
			myRoomListing.setCookingAtHome(room.getCookingAtHome());
			myRoomListing.setArePetsInHouse(room.getArePetsInHouse());
			myRoomListing.setAreSmokersInHouse(room.getAreSmokersInHouse());
			myRoomListing.setAreDrinkersInHouse(room.getAreDrinkersInHouse());
			myRoomListing.setRoomAmenities(room.getRoomAmenities());
			myRoomListing.setMatePreferToLiveWith(room.getMatePreferToLiveWith());
			myRoomListing.setMateGender(room.getMateGender());
			myRoomListing.setMateOccupation(room.getMateOccupation());
			myRoomListing.setMatePetsAllowed(room.getMatePetsAllowed());
			myRoomListing.setMateSmokingAllowed(room.getMateSmokingAllowed());
			myRoomListing.setMateDrinkingAllowed(room.getMateDrinkingAllowed());
			myRoomListing.setRoomListStatus(room.getRoomListStatus());
			myRoomListing.setRoomListCreatedDate(room.getRoomListCreatedDate());
			myRoomListing.setRoomListModifiedDate(room.getRoomListModifiedDate());
			myRoomListing.setRoomListingImage1(room.getRoomListingImageText1().getValue());
			myRoomListing.setRoomListingImage2(room.getRoomListingImageText2().getValue());
			myRoomListing.setRoomListingImage3(room.getRoomListingImageText3().getValue());
			myRoomListing.setRoomListingImage4(room.getRoomListingImageText4().getValue());
			myRoomListing.setRoomListingImage5(room.getRoomListingImageText5().getValue());
			myRoomListing.setRoomListingImage6(room.getRoomListingImageText6().getValue());

		}catch (Exception e) {
			logger.error("Error occured in getRoomDetailsByEmail()"+e.getStackTrace());
		}
		logger.debug("End---getRoomDetailsByEmail()");
		return myRoomListing;
	}
	
	@Override
	public String sendMessage(Message message){
		logger.debug("Start---sendMessage()");
		String messageText ="";
		try{
			String msgReceiver = CipherUtils.decrypt(message.getMsgReceiverEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param"));
			User user = findUserByUserEmail(currentUserDetailsService.getCurrentUserEmail());
			message.setMsgSenderEmail(StringUtils.upperCase(user.getUserEmail()));
			message.setMsgSenderUserName(user.getUserName());
			message.setMsgSenderProfileImgText(new Text(user.getUserProfileimageText().getValue()));			
			message.setMsgReceiverEmail(StringUtils.upperCase(msgReceiver));
			message.setMsgMarkedRead("N");
			message.setMsgSentDateTime(String.valueOf(new Date()));
			daoFactory.sendMessage(message);
			messageText = ConfigurationManager.INSTANCE.get().getProperty("email.message.sent.success");
		}catch (Exception e) {
			logger.error("Error occured in sendMessage :"+e.getStackTrace());
		}
		logger.debug("End---sendMessage()");
		return messageText;		
	}
	
	public List<Message> getAllMyMessages(){
		logger.debug("Start---getAllMyMessages()");
		List<Message> myMessages =new ArrayList<Message>();
		List<Message> myAllMessages = new ArrayList<Message>();
		try{
			myMessages = daoFactory.getAllMyMessages(currentUserDetailsService.getCurrentUserEmail());
			for (Message message : myMessages) {
				message.setMsgSenderEmail(URLEncoder.encode(CipherUtils.encrypt(message.getMsgSenderEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
				message.setMsgSenderProfileImg(message.getMsgSenderProfileImgText().getValue());
				myAllMessages.add(message);
			}
		}catch(Exception ex){
			logger.error("Error occured in getAllMyMessages :"+ex.getStackTrace());
		}
		logger.debug("End---getAllMyMessages()");
		return myAllMessages;
	}
	
	public void deleteMessage(String msgId){
		logger.debug("Start---deleteMessage()");
		try{
			daoFactory.deleteMessage(msgId);
		}catch(Exception ex){
			logger.error("Error occured in deleteMessage :"+ex.getStackTrace());
		}
		logger.debug("End---deleteMessage()");
	}
	
	public void markMsgAsRead(String msgId){
		logger.debug("Start---markMsgAsRead()");
		try{
			daoFactory.markMsgAsRead(msgId);
		}catch(Exception ex){
			logger.error("Error occured in markMsgAsRead :"+ex.getStackTrace());
		}
		logger.debug("End---markMsgAsRead()");
	}
	
	public List<MyRoomListing> searchRoomsFromHomePage(String homeLocation){
		logger.debug("Start---searchRoomsFromHomePage()");
		List<MyRoomListing> roomsListingList =new ArrayList<MyRoomListing>();
		List<RoomList> roomsList =null;
		try{
			roomsList = daoFactory.searchRoomsFromHomePage(homeLocation);
			if(roomsList!=null && roomsList.size()>0){
				for (RoomList roomList : roomsList) {
					MyRoomListing myRoomListing = new MyRoomListing();
					myRoomListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(roomList.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
					myRoomListing.setRoomHeadLine(roomList.getRoomHeadLine());
					myRoomListing.setRoomAddress(roomList.getRoomAddress());
					myRoomListing.setRoomInCity(roomList.getRoomInCity());
					myRoomListing.setMonthlyRent(roomList.getMonthlyRent());
					myRoomListing.setAvailableFromDate(roomList.getAvailableFromDate());
					myRoomListing.setRoomListingImage1(roomList.getRoomListingImageText1().getValue());
					myRoomListing.setRoomListingImage2(roomList.getRoomListingImageText2().getValue());
					myRoomListing.setRoomListingImage3(roomList.getRoomListingImageText3().getValue());
					myRoomListing.setRoomListingImage4(roomList.getRoomListingImageText4().getValue());
					myRoomListing.setRoomListingImage5(roomList.getRoomListingImageText5().getValue());
					myRoomListing.setRoomListingImage6(roomList.getRoomListingImageText6().getValue());
					roomsListingList.add(myRoomListing);
				}
			}
		}catch (Exception e) {
			logger.error("Error occured in searchRooms()"+e.getStackTrace());
		}
		logger.debug("End---searchRoomsFromHomePage()");
		return roomsListingList;		
	}
	
	public List<MyMateListing> searchRoommatesFromHomePage(String homeLocation){
		logger.debug("Start---searchRoommatesFromHomePage()");
		List<MyMateListing> mateListingList =new ArrayList<MyMateListing>();
		List<MyMateListing> finalMateListingList =new ArrayList<MyMateListing>();
		List<RoomMateList> roomMateList =null;
		try{
			roomMateList = daoFactory.getAllRoomMatesList();
			if(roomMateList!=null && roomMateList.size()>0){
				for (RoomMateList roomMate : roomMateList) {
					MyMateListing myMateListing = new MyMateListing();
					//Get user details from email address.
					User user = findUserByUserEmail(roomMate.getUserEmail());
					myMateListing.setUserEmail(roomMate.getUserEmail());
					myMateListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(roomMate.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
					myMateListing.setUserName(user.getUserName());
					myMateListing.setProfileHeadLine(roomMate.getProfileHeadLine());
					myMateListing.setMoveInDate(roomMate.getMoveInDate());
					myMateListing.setMonthlyBudget(roomMate.getMonthlyBudget());
					myMateListing.setUserAboutMe(user.getUserAboutMe());
					myMateListing.setProfileImage(user.getUserProfileimageText().getValue());
					myMateListing.setLookingInCity(roomMate.getLookingInCity());
					myMateListing.setLookingforArea(roomMate.getLookingforArea());
					mateListingList.add(myMateListing);
				}
			}
			
			//Filter list based on the looking for area in city.
			if(homeLocation!=null && !homeLocation.isEmpty()){
				String[] splitLocation = homeLocation.split(",");
				String roomAreaInCity = splitLocation[0];
				for(MyMateListing myMateListing : mateListingList){
					if(myMateListing.getLookingforArea().contains(roomAreaInCity)){
						finalMateListingList.add(myMateListing);
					}
				}
			}
		}catch (Exception e) {
			logger.error("Error occured in searchRoommatesFromHomePage()"+e.getStackTrace());
		}
		logger.debug("End---searchRoommatesFromHomePage()");
		return finalMateListingList;
	}
	
	public List<MyRoomListing> searchRooms(MyRoomListing roomParam){
		logger.debug("Start---searchRooms()");
		List<MyRoomListing> roomsListingList =new ArrayList<MyRoomListing>();
		List<RoomList> roomsList =null;
		try{
			roomsList = daoFactory.searchRooms(roomParam);
			if(roomsList!=null && roomsList.size()>0){
				for (RoomList roomList : roomsList) {
					MyRoomListing myRoomListing = new MyRoomListing();
					myRoomListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(roomList.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
					myRoomListing.setRoomHeadLine(roomList.getRoomHeadLine());
					myRoomListing.setRoomAddress(roomList.getRoomAddress());
					myRoomListing.setRoomInCity(roomList.getRoomInCity());
					myRoomListing.setMonthlyRent(roomList.getMonthlyRent());
					myRoomListing.setAvailableFromDate(roomList.getAvailableFromDate());
					myRoomListing.setRoomListingImage1(roomList.getRoomListingImageText1().getValue());
					myRoomListing.setRoomListingImage2(roomList.getRoomListingImageText2().getValue());
					myRoomListing.setRoomListingImage3(roomList.getRoomListingImageText3().getValue());
					myRoomListing.setRoomListingImage4(roomList.getRoomListingImageText4().getValue());
					myRoomListing.setRoomListingImage5(roomList.getRoomListingImageText5().getValue());
					myRoomListing.setRoomListingImage6(roomList.getRoomListingImageText6().getValue());
					roomsListingList.add(myRoomListing);
				}
			}
		}catch (Exception e) {
			logger.error("Error occured in searchRooms()"+e.getStackTrace());
		}
		logger.debug("End---searchRooms()");
		return roomsListingList;
	}

	public List<MyMateListing> searchRoommates(MyMateListing roommateParam){
		logger.debug("Start---searchRoommates()");
		List<MyMateListing> mateListingList =new ArrayList<MyMateListing>();
		List<MyMateListing> finalMateListingList =new ArrayList<MyMateListing>();
		List<RoomMateList> roomMateList =null;
		try{
			roomMateList = daoFactory.getAllRoomMatesList();
			if(roomMateList!=null && roomMateList.size()>0){
				for (RoomMateList roomMate : roomMateList) {
					MyMateListing myMateListing = new MyMateListing();
					//Get user details from email address.
					User user = findUserByUserEmail(roomMate.getUserEmail());
					myMateListing.setUserEmail(roomMate.getUserEmail());
					myMateListing.setUserEmail(URLEncoder.encode(CipherUtils.encrypt(roomMate.getUserEmail(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")),"ISO-8859-1"));
					myMateListing.setUserName(user.getUserName());
					myMateListing.setProfileHeadLine(roomMate.getProfileHeadLine());
					myMateListing.setMoveInDate(roomMate.getMoveInDate());
					myMateListing.setMonthlyBudget(roomMate.getMonthlyBudget());
					myMateListing.setUserAboutMe(user.getUserAboutMe());
					myMateListing.setProfileImage(user.getUserProfileimageText().getValue());
					myMateListing.setLookingInCity(roomMate.getLookingInCity());
					myMateListing.setLookingforArea(roomMate.getLookingforArea());
					mateListingList.add(myMateListing);
				}
			}
			
			//Filter list based on the input from FE.
			if(roommateParam!=null){
				for(MyMateListing myMateListing : mateListingList){
					if(myMateListing!=null){
						
						//City & Area
						if(roommateParam.getLookingInCity()!=null && !StringUtils.isEmpty(roommateParam.getLookingInCity()) && roommateParam.getLookingInCity().equalsIgnoreCase(myMateListing.getLookingInCity())
								&& roommateParam.getLookingforArea()!=null && !StringUtils.isEmpty(roommateParam.getLookingforArea()) && myMateListing.getLookingforArea()!=null && myMateListing.getLookingforArea().contains(roommateParam.getLookingforArea())){
							finalMateListingList.add(myMateListing);
						}else if(roommateParam.getLookingInCity()!=null && !StringUtils.isEmpty(roommateParam.getLookingInCity()) && roommateParam.getLookingInCity().equalsIgnoreCase(myMateListing.getLookingInCity())){
							finalMateListingList.add(myMateListing);
						}else if(roommateParam.getLookingforArea()!=null && !StringUtils.isEmpty(roommateParam.getLookingforArea()) && myMateListing.getLookingforArea()!=null && myMateListing.getLookingforArea().contains(roommateParam.getLookingforArea())){
							finalMateListingList.add(myMateListing);
						}
						
						//Gender
						if(roommateParam.getLookingInCity()!=null && !StringUtils.isEmpty(roommateParam.getLookingInCity()) && roommateParam.getLookingInCity().equalsIgnoreCase(myMateListing.getLookingInCity())
								&& roommateParam.getLookingforArea()!=null && !StringUtils.isEmpty(roommateParam.getLookingforArea()) && myMateListing.getLookingforArea()!=null && myMateListing.getLookingforArea().contains(roommateParam.getLookingforArea())
								&& roommateParam.getUserGender()!=null && !StringUtils.isEmpty(roommateParam.getUserGender()) && roommateParam.getUserGender().equalsIgnoreCase(myMateListing.getUserGender())){
							finalMateListingList.add(myMateListing);
						}else if(roommateParam.getUserGender()!=null && !StringUtils.isEmpty(roommateParam.getUserGender()) && roommateParam.getUserGender().equalsIgnoreCase(myMateListing.getUserGender())){
							finalMateListingList.add(myMateListing);
						}
						
						//Occupation
						if(roommateParam.getLookingInCity()!=null && !StringUtils.isEmpty(roommateParam.getLookingInCity()) && roommateParam.getLookingInCity().equalsIgnoreCase(myMateListing.getLookingInCity())
								&& roommateParam.getLookingforArea()!=null && !StringUtils.isEmpty(roommateParam.getLookingforArea()) && myMateListing.getLookingforArea()!=null && myMateListing.getLookingforArea().contains(roommateParam.getLookingforArea())
								&& roommateParam.getUserGender()!=null && !StringUtils.isEmpty(roommateParam.getUserGender()) && roommateParam.getUserGender().equalsIgnoreCase(myMateListing.getUserGender())
								&& roommateParam.getUserOccupation()!=null && !StringUtils.isEmpty(roommateParam.getUserOccupation()) && roommateParam.getUserOccupation().equalsIgnoreCase(myMateListing.getUserOccupation())){
							finalMateListingList.add(myMateListing);
						}else if(roommateParam.getUserOccupation()!=null && !StringUtils.isEmpty(roommateParam.getUserOccupation()) && roommateParam.getUserOccupation().equalsIgnoreCase(myMateListing.getUserOccupation())){
							finalMateListingList.add(myMateListing);
						}
						
						//TODO Monthly Rent
						
					}
				}
			}
		}catch (Exception e) {
			logger.error("Error occured in searchRoommates()"+e.getStackTrace());
		}
		logger.debug("End---searchRoommates()");
		return finalMateListingList;
	}
	
	@Override
	public String shortList(String shortListingUserEmail,String shortListingType){
		logger.debug("Start---shortList()");
		String messageText ="";
		try{
			RoomShortListings shortList = new RoomShortListings();
			shortList.setShortListingType(shortListingType);
			shortList.setUserEmail(currentUserDetailsService.getCurrentUserEmail());
			shortList.setShortListingUserEmail(CipherUtils.decrypt(shortListingUserEmail, ConfigurationManager.INSTANCE.get().getProperty("cipher.key.email.param")));
			shortList.setShortListingDateTime(String.valueOf(new Date()));
			daoFactory.shortList(shortList);
		}catch (Exception e) {
			logger.error("Error occured in shortList :"+e.getStackTrace());
		}
		logger.debug("End---shortList()");
		return messageText;		
	}
}
