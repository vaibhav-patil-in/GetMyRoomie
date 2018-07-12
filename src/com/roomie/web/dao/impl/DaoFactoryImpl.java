package com.roomie.web.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.appengine.api.datastore.Text;
import com.roomie.web.WebAppConstants;
import com.roomie.web.config.ConfigurationManager;
import com.roomie.web.core.utility.CipherUtils;
import com.roomie.web.dao.EMFService;
import com.roomie.web.dao.IDaoFactory;
import com.roomie.web.dao.entity.Message;
import com.roomie.web.dao.entity.MyRoomListing;
import com.roomie.web.dao.entity.RoomList;
import com.roomie.web.dao.entity.RoomMateList;
import com.roomie.web.dao.entity.RoomShortListings;
import com.roomie.web.dao.entity.User;

public class DaoFactoryImpl implements IDaoFactory {
	
	protected final static Log logger = LogFactory.getLog(DaoFactoryImpl.class);
	
	public void save(Object obj){
		logger.debug("Start----save()");
		EntityManager em = EMFService.get().createEntityManager();
		try{
			em.persist(obj);
		}catch (Exception e) {
			logger.error("Error occured in saving the object in persistant store"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End----save()");
	}

	@Override
	public void registerUser(User user) {
		logger.debug("Start---registerUser() to persist"+user.getUserEmail());
		save(user);
		logger.debug("End---registerUser() to persist"+user.getUserEmail());
	}

	@Override
	public User findUserByUserEmail(String userEmail) {
		logger.debug("Start---findUserByUserEmail() to persist"+userEmail);
		EntityManager em = EMFService.get().createEntityManager();
		User user = null;
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("findUserByUserEmail"));
			query.setParameter("userEmail", StringUtils.upperCase(userEmail));
			query.setParameter("userStatus", WebAppConstants.VERIFIED_USER);
			user = (User)query.getSingleResult();
		}catch (Exception e) {
			logger.error("Error occured in getting user by:"+userEmail+":"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---findUserByUserEmail() to persist"+userEmail);
		return user;
	}

	@Override
	public void updateUser(User user) {
		logger.debug("Start---updateUser():"+user.getUserEmail());
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("update.user"));
			if(user!=null)
				query.setParameter("userEmail", user.getUserEmail());
			
			User modelUser = (User)query.getSingleResult();
			if(modelUser!=null){
				modelUser.setUserName(user.getUserName());
				if(StringUtils.isNotBlank(user.getUserProfileimage())){
					modelUser.setUserProfileimageText(new Text(user.getUserProfileimage()));
				}else{
					modelUser.setUserProfileimageText(new Text(ConfigurationManager.INSTANCE.get().getProperty("user.default.image")));
				}
				modelUser.setUserMobileNumber(user.getUserMobileNumber());
				if(user.getShowUserMobileNumber()!=null && StringUtils.isNotEmpty(user.getShowUserMobileNumber())){
					modelUser.setShowUserMobileNumber(user.getShowUserMobileNumber());
				}else{
					modelUser.setShowUserMobileNumber("No");
				}
				modelUser.setUserAge(user.getUserAge());
				modelUser.setUserGender(user.getUserGender());
				modelUser.setUserOccupation(user.getUserOccupation());
				modelUser.setUserHavePets(user.getUserHavePets());
				modelUser.setUserDrink(user.getUserDrink());
				modelUser.setUserSmoke(user.getUserSmoke());
				modelUser.setUserAboutMe(user.getUserAboutMe());
				modelUser.setUserModifiedDate(String.valueOf(new Date()));
				em.persist(modelUser);
			}
		}catch (Exception e) {
			logger.error("Error occured in updating user:"+user.getUserEmail()+" :"+e.getStackTrace());
		}
		finally{
			em.close();
		}
		logger.debug("End---updateUser():"+user.getUserEmail()+" User updated succesfully");
	}
	
	@Override
	public void updatePassword(User user) {
		logger.debug("Start---updatePassword():"+user.getUserEmail());
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("update.user"));
			if(user!=null)
				query.setParameter("userEmail", user.getUserEmail());
			
			User modelUser = (User)query.getSingleResult();
			if(modelUser!=null){
				modelUser.setUserPassword(CipherUtils.encrypt(user.getUserPassword(), ConfigurationManager.INSTANCE.get().getProperty("cipher.key.password")));
				em.persist(modelUser);
			}
		}catch (Exception e) {
			logger.error("Error occured in updating password for:"+user.getUserEmail()+" :"+e.getStackTrace());
		}
		finally{
			em.close();
		}
		logger.debug("End---updatePassword():"+user.getUserEmail()+" password updated succesfully");
	}
	
	@Override
	public void updateRoomMateList(RoomMateList roomMate) {
		logger.debug("Start---updateRoomMateList():"+roomMate.getUserEmail());
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("update.roommate"));
			if(roomMate!=null)
				query.setParameter("userEmail", roomMate.getUserEmail());
			
			RoomMateList modelroomMate = (RoomMateList)query.getSingleResult();
			if(modelroomMate!=null){
				modelroomMate.setProfileHeadLine(roomMate.getProfileHeadLine());
				modelroomMate.setLookingInCity(roomMate.getLookingInCity());
				modelroomMate.setLookingforArea(roomMate.getLookingforArea());
				modelroomMate.setRentingForMonth(roomMate.getRentingForMonth());
				modelroomMate.setMonthlyBudget(roomMate.getMonthlyBudget());
				modelroomMate.setMoveInDate(roomMate.getMoveInDate());
				modelroomMate.setMateGender(roomMate.getMateGender());
				modelroomMate.setMateOccupation(roomMate.getMateOccupation());
				modelroomMate.setMatePetsAllowed(roomMate.getMatePetsAllowed());
				modelroomMate.setMateDrinkingAllowed(roomMate.getMateDrinkingAllowed());
				modelroomMate.setMateSmokingAllowed(roomMate.getMateSmokingAllowed());
				modelroomMate.setMatePreferToLiveWith(roomMate.getMatePreferToLiveWith());
				modelroomMate.setMateListStatus(WebAppConstants.LISTING_ACTIVE);
				modelroomMate.setMateListModifiedDate(String.valueOf(new Date()));
				em.persist(modelroomMate);
			}
		}catch (Exception e) {
			logger.error("Error occured in updateRoomMateList:"+roomMate.getUserEmail()+" :"+e.getStackTrace());
		}
		finally{
			em.close();
		}
		logger.debug("End---updateUser():"+roomMate.getUserEmail()+" User updated succesfully");
	}
	
	@Override
	public void updateRoomList(RoomList room) {
		logger.debug("Start---updateRoomList():"+room.getUserEmail());
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("update.room"));
			if(room!=null)
				query.setParameter("userEmail", room.getUserEmail());
			
			RoomList modelRoom = (RoomList)query.getSingleResult();
			if(modelRoom!=null){
				modelRoom.setRoomHeadLine(room.getRoomHeadLine());
				modelRoom.setAboutRoom(room.getAboutRoom());
				modelRoom.setNumberOfRooms(room.getNumberOfRooms());
				modelRoom.setNumberOfRoomMates(room.getNumberOfRoomMates());
				modelRoom.setMinimumStay(room.getMinimumStay());
				modelRoom.setMonthlyRent(room.getMonthlyRent());
				modelRoom.setAvailableFromDate(room.getAvailableFromDate());
				modelRoom.setRoomInCity(room.getRoomInCity());
				modelRoom.setRoomAreaInCity(room.getRoomAreaInCity());
				modelRoom.setRoomPostalCode(room.getRoomPostalCode());
				modelRoom.setRoomAddress(room.getRoomAddress());
				modelRoom.setPropertyType(room.getPropertyType());
				modelRoom.setRoomRelation(room.getRoomRelation());
				modelRoom.setRoomAccomodates(room.getRoomAccomodates());
				modelRoom.setRoomFurnishingType(room.getRoomFurnishingType());
				modelRoom.setCookingAtHome(room.getCookingAtHome());
				modelRoom.setArePetsInHouse(room.getArePetsInHouse());
				modelRoom.setAreSmokersInHouse(room.getAreSmokersInHouse());
				modelRoom.setAreDrinkersInHouse(room.getAreDrinkersInHouse());
				modelRoom.setRoomAmenities(room.getRoomAmenities());
				modelRoom.setMatePreferToLiveWith(room.getMatePreferToLiveWith());
				modelRoom.setMateGender(room.getMateGender());
				modelRoom.setMateOccupation(room.getMateOccupation());
				modelRoom.setMatePetsAllowed(room.getMatePetsAllowed());
				modelRoom.setMateSmokingAllowed(room.getMateSmokingAllowed());
				modelRoom.setMateDrinkingAllowed(room.getMateDrinkingAllowed());
				
				/*Room images starts*/
				if(StringUtils.isNotBlank(room.getRoomListingImage1())){
					modelRoom.setRoomListingImageText1(new Text(room.getRoomListingImage1()));
				}else{
					modelRoom.setRoomListingImageText1(new Text(ConfigurationManager.INSTANCE.get().getProperty("room.default.image")));
				}
				if(StringUtils.isNotBlank(room.getRoomListingImage2())){
					modelRoom.setRoomListingImageText2(new Text(room.getRoomListingImage2()));
				}else{
					modelRoom.setRoomListingImageText2(new Text(""));
				}
				if(StringUtils.isNotBlank(room.getRoomListingImage3())){
					modelRoom.setRoomListingImageText3(new Text(room.getRoomListingImage3()));
				}else{
					modelRoom.setRoomListingImageText3(new Text(""));
				}
				if(StringUtils.isNotBlank(room.getRoomListingImage4())){
					modelRoom.setRoomListingImageText4(new Text(room.getRoomListingImage4()));
				}else{
					modelRoom.setRoomListingImageText4(new Text(""));
				}
				if(StringUtils.isNotBlank(room.getRoomListingImage5())){
					modelRoom.setRoomListingImageText5(new Text(room.getRoomListingImage5()));
				}else{
					modelRoom.setRoomListingImageText5(new Text(""));
				}
				if(StringUtils.isNotBlank(room.getRoomListingImage6())){
					modelRoom.setRoomListingImageText6(new Text(room.getRoomListingImage6()));
				}else{
					modelRoom.setRoomListingImageText6(new Text(""));
				}
				/*Room images ends*/
				
				modelRoom.setRoomListStatus(WebAppConstants.LISTING_ACTIVE);
				modelRoom.setRoomListModifiedDate(String.valueOf(new Date()));
				em.persist(modelRoom);
			}
		}catch (Exception e) {
			logger.error("Error occured in updateRoomList:"+room.getUserEmail()+" :"+e.getStackTrace());
		}
		finally{
			em.close();
		}
		logger.debug("End---updateRoomList():"+room.getUserEmail()+" room updated succesfully");
	}

	@Override
	public void verifyEmail(String email, String otp) {
		logger.debug("Start---verifyEmail():"+email);
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("verifyEmail"));
			query.setParameter("userEmail", StringUtils.upperCase(email));
			query.setParameter("userOtp", otp);
			
			User modelUser = (User)query.getSingleResult();
			if(modelUser!=null){
				modelUser.setUserStatus(WebAppConstants.VERIFIED_USER);
			}
			em.persist(modelUser);
		}catch (Exception e) {
			logger.error("Error occured in verifying email address:"+email+" :"+e.getStackTrace());
		}
		finally{
			em.close();
		}
		logger.debug("End---verifyEmail():"+email);
	}

	@Override
	public void createRoomMateList(RoomMateList roomMate) {
		logger.debug("Start---createRoomMateList():"+roomMate.getUserEmail());
		save(roomMate);
		logger.debug("End---createRoomMateList():"+roomMate.getUserEmail());
	}
	
	@Override
	public void createRoomList(RoomList room) {
		logger.debug("Start---createRoomList():"+room.getUserEmail());
		save(room);
		logger.debug("End---createRoomList():"+room.getUserEmail());
	}

	@Override
	public RoomMateList getAllRoomMateListByEmail(String email) {
		logger.debug("Start---getAllRoomMateListByEmail():"+email);
		EntityManager em = EMFService.get().createEntityManager();
		RoomMateList roomMate=null;
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("getAllRoomMateListByEmail"));
			query.setParameter("userEmail", StringUtils.upperCase(email));
			roomMate = (RoomMateList)query.getSingleResult();
		}catch (Exception e) {
			logger.error("Error occurred in getting roommate list by email"+email+" :"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---getAllRoomMateListByEmail():"+email);
		return roomMate;
	}
	
	@Override
	public RoomList getAllRoomListByEmail(String email) {
		logger.debug("Start---getAllRoomListByEmail():"+email);
		EntityManager em = EMFService.get().createEntityManager();
		RoomList room=null;
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("getAllRoomListByEmail"));
			query.setParameter("userEmail", StringUtils.upperCase(email));
			room = (RoomList)query.getSingleResult();
		}catch (Exception e) {
			logger.error("Error occurred in getting roommate list by email"+email+" :"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---getAllRoomListByEmail():"+email);
		return room;
	}
	
	@Override
	public User checkUserEmailExist(String userEmail) {
		logger.debug("Start---checkUserEmailExist(): "+userEmail);
		EntityManager em = EMFService.get().createEntityManager();
		User user = null;
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("checkUserEmailExist"));
			query.setParameter("userEmail", StringUtils.upperCase(userEmail));
			user = (User)query.getSingleResult();
		}catch (Exception e) {
			logger.error("Error occured in getting user by:"+userEmail+":"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---checkUserEmailExist() to : "+userEmail);
		return user;
	}
	
	public List<RoomList> getAllRoomsList(){
		logger.debug("Start---getAllRoomsList()");
		EntityManager em = EMFService.get().createEntityManager();
		List<RoomList> roomsList = new ArrayList<RoomList>();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("getAllRoomsList"));
			query.setParameter("roomListStatus", WebAppConstants.LISTING_ACTIVE);
			roomsList = query.getResultList();
		}catch (Exception e) {
			logger.error("Error occurred in getting all rooms from DB:"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---getAllRoomsList()");
		return roomsList;
	}
	
	public List<RoomMateList> getAllRoomMatesList(){
		logger.debug("Start---getAllRoomMatesList()");
		EntityManager em = EMFService.get().createEntityManager();
		List<RoomMateList> roomMateList = new ArrayList<RoomMateList>();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("getAllRoomMatesList"));
			query.setParameter("mateListStatus", WebAppConstants.LISTING_ACTIVE);
			roomMateList = query.getResultList();
		}catch (Exception e) {
			logger.error("Error occurred in getting all room mates from DB:"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---getAllRoomMatesList()");
		return roomMateList;
	}

	@Override
	public void updateRoomMateStatus(String status, String email) {
		logger.debug("Start---updateRoomMateStatus():"+email);
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("update.roommate"));
			if(email!=null)
				query.setParameter("userEmail", StringUtils.upperCase(email));
			
			RoomMateList modelRoomMate = (RoomMateList)query.getSingleResult();
			if(modelRoomMate!=null){
				modelRoomMate.setMateListStatus(status);
				modelRoomMate.setMateListModifiedDate(String.valueOf(new Date()));
				em.persist(modelRoomMate);
			}
		}catch (Exception e) {
			logger.error("Error occured in updating roomMate status:"+email+" :"+e.getStackTrace());
		}
		finally{
			em.close();
		}
		logger.debug("End---updateRoomMateStatus():"+email+" User updated succesfully");
	}

	@Override
	public void updateRoomStatus(String status, String email) {
		logger.debug("Start---updateRoomStatus():"+email);
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("update.room"));
			if(email!=null)
				query.setParameter("userEmail", StringUtils.upperCase(email));
			
			RoomList modelRoom = (RoomList)query.getSingleResult();
			if(modelRoom!=null){
				modelRoom.setRoomListStatus(status);
				modelRoom.setRoomListModifiedDate(String.valueOf(new Date()));
				em.persist(modelRoom);
			}
		}catch (Exception e) {
			logger.error("Error occured in updating room status:"+email+" :"+e.getStackTrace());
		}
		finally{
			em.close();
		}
		logger.debug("End---updateRoomStatus():"+email+" User updated succesfully");
	}
	
	@Override
	public void sendMessage(Message message){
		logger.debug("Start---sendMessage()"+message.getMsgSenderEmail());
		save(message);
		logger.debug("End---sendMessage()"+message.getMsgSenderEmail());
	}
	
	public List<Message> getAllMyMessages(String email){
		logger.debug("Start---getAllMyMessages()");
		EntityManager em = EMFService.get().createEntityManager();
		List<Message> myMessages = new ArrayList<Message>();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("getAllMyMessagesByEmail"));
			query.setParameter("msgReceiverEmail", StringUtils.upperCase(email));
			myMessages = query.getResultList();
		}catch (Exception e) {
			logger.error("Error occurred in getting all messages from DB:"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---getAllMyMessages()");
		return myMessages;
	}

	public void deleteMessage(String msgId){
		logger.debug("Start---deleteMessage()");
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("selectMessageByMsgId"));
			query.setParameter("msgId", msgId);
			Message msg = (Message) query.getSingleResult();
			em.remove(msg);
		}catch(Exception ex){
			logger.error("Error occured in deleteMessage :"+ex.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---deleteMessage()");
	}
	
	public void markMsgAsRead(String msgId){
		logger.debug("Start---markMsgAsRead()");
		EntityManager em = EMFService.get().createEntityManager();
		try{
			Query query = em.createQuery(ConfigurationManager.INSTANCE.get().getProperty("selectMessageByMsgId"));
			query.setParameter("msgId", msgId);
			Message msg = (Message) query.getSingleResult();
			msg.setMsgMarkedRead("Y");
			em.persist(msg);
		}catch(Exception ex){
			logger.error("Error occured in markMsgAsRead :"+ex.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---markMsgAsRead()");
	}
	
	public List<RoomList> searchRooms(MyRoomListing roomParam){
		logger.debug("Start---searchRooms()");
		EntityManager em = EMFService.get().createEntityManager();
		List<RoomList> roomsList = new ArrayList<RoomList>();
		try{
			if(roomParam != null){
				String serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRooms");

				//With City AND Area in City
				if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityArea");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCity");
				}else if(roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithArea");
				}
				
				//With City AND Area in City AND Gender
				if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) && 
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaGender");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityGender");
				}

				//With City AND Area in City AND Gender AND Occupation
				/*if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) && 
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getMateOccupation()!=null && !StringUtils.isEmpty(roomParam.getMateOccupation())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaGenderOccupation");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) &&
						roomParam.getMateOccupation()!=null && !StringUtils.isEmpty(roomParam.getMateOccupation())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaOccupation");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getMateOccupation()!=null && !StringUtils.isEmpty(roomParam.getMateOccupation())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityGenderOccupation");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getMateOccupation()!=null && !StringUtils.isEmpty(roomParam.getMateOccupation())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityOccupation");
				}*/

				//With City AND Area in City AND Gender AND PropertyType
				if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) && 
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaGenderPropertyType");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) &&
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaPropertyType");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityGenderPropertyType");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityPropertyType");
				}
				
				//With City AND Area in City AND Gender AND Oc AND Monthly Rent
				if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) && 
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType()) && 
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaGenderPropertyTypeMonthlyRent");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType()) && 
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityGenderPropertyTypeMonthlyRent");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) && 
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType()) && 
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaPropertyTypeMonthlyRent");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityGenderMonthlyRent");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getPropertyType()!=null && !StringUtils.isEmpty(roomParam.getPropertyType()) && 
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityPropertyTypeMonthlyRent");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) && 
						roomParam.getMateGender()!=null && !StringUtils.isEmpty(roomParam.getMateGender()) && 
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaGenderMonthlyRent");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getRoomAreaInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomAreaInCity()) &&  
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityAreaMonthlyRent");
				}else if(roomParam.getRoomInCity()!=null && !StringUtils.isEmpty(roomParam.getRoomInCity()) &&
						roomParam.getMonthlyRent()!=null && !StringUtils.isEmpty(roomParam.getMonthlyRent())){
					serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsWithCityMonthlyRent");
				}

				String roomAreaInCity="";
				if(roomParam.getRoomAreaInCity()!=null && !roomParam.getRoomAreaInCity().isEmpty()){
					String[] splitLocation = roomParam.getRoomAreaInCity().split(",");
					roomAreaInCity = splitLocation[0];
				}
				
				String minMonthlyRent="";
				String maxMonthlyRent="";
				if(roomParam.getMonthlyRent()!=null && !roomParam.getMonthlyRent().isEmpty()){
					String[] splitMonthlyRent = roomParam.getMonthlyRent().split("-");
					minMonthlyRent = splitMonthlyRent[0];
					maxMonthlyRent = splitMonthlyRent[1];
				}
				
				Query query = em.createQuery(serachQuery);
				query.setParameter("roomListStatus", WebAppConstants.LISTING_ACTIVE);
				query.setParameter("roomInCity", roomParam.getRoomInCity());
				query.setParameter("roomAreaInCity", roomAreaInCity+"%");
				query.setParameter("mateGender", roomParam.getMateGender());
				//query.setParameter("mateOccupation", roomParam.getMateOccupation());
				query.setParameter("propertyType", roomParam.getPropertyType());
				query.setParameter("minMonthlyRent", minMonthlyRent);
				query.setParameter("maxMonthlyRent", maxMonthlyRent);
				roomsList = query.getResultList();
			}
		}catch (Exception e) {
			logger.error("Error occurred in getting all rooms from DB:"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---searchRooms()");
		return roomsList;
	}
	
	public List<RoomList> searchRoomsFromHomePage(String homeLocation){
		logger.debug("Start---searchRoomsFromHomePage()");
		EntityManager em = EMFService.get().createEntityManager();
		List<RoomList> roomsList = new ArrayList<RoomList>();
		try{
			String roomAreaInCity="";
			if(homeLocation!=null && !homeLocation.isEmpty()){
				String[] splitLocation = homeLocation.split(",");
				roomAreaInCity = splitLocation[0];
			}
			String serachQuery = ConfigurationManager.INSTANCE.get().getProperty("searchRoomsFromHomePage");
			Query query = em.createQuery(serachQuery);
			query.setParameter("roomListStatus", WebAppConstants.LISTING_ACTIVE);
			query.setParameter("roomAreaInCity", roomAreaInCity+"%");
			roomsList = query.getResultList();
		}catch (Exception e) {
			logger.error("Error occurred in getting all rooms from DB:"+e.getStackTrace());
		}finally{
			em.close();
		}
		logger.debug("End---searchRoomsFromHomePage()");
		return roomsList;
	}
	
	@Override
	public void shortList(RoomShortListings shortList){
		logger.debug("Start---shortList()"+shortList.getUserEmail());
		save(shortList);
		logger.debug("End---shortList()"+shortList.getUserEmail());
	}
}
