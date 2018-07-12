package com.roomie.web.core.service.restful;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roomie.web.businesslogic.IBusinessLogic;
import com.roomie.web.config.ConfigurationManager;
import com.roomie.web.dao.entity.MyMateListing;
import com.roomie.web.dao.entity.MyRoomListing;
import com.roomie.web.dao.entity.User;

/**
 * @author Vaibhav.Patil
 */
@Component
@Path("/service")
public class WebAppRestfulService {

	protected final static Log log = LogFactory.getLog(WebAppRestfulService.class);

	@Autowired
	private IBusinessLogic businessLogic;

	@GET
	@Path("/checkEmailExist/")
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONResponseWrapper checkEmailExist(@QueryParam("email") String email) {

		log.debug("Start--In ajax call handler checkEmailExist");
		log.debug("Email is:"+email);

		JSONResponseWrapper jSONResponseWrapper = new JSONResponseWrapper();
		Update update = new Update();
		try {
			User user = businessLogic.checkUserEmailExist(email);
			if(user!=null){
				update.setErrorMessage(ConfigurationManager.INSTANCE.get().getProperty("register.user.email.alreadyExist"));
				jSONResponseWrapper.setUpdate(update);
			}else{
				update.setPasswordRecoveryEmailNotExist(ConfigurationManager.INSTANCE.get().getProperty("recovery.email.not.exist"));
				jSONResponseWrapper.setUpdate(update);
			}
		} catch (Exception exp) {
			log.error("Error while getting user with specified email"+exp.getStackTrace());
		}
		log.debug("Ends--In ajax call handler checkEmailExist");
		return jSONResponseWrapper;
	}
	
	@GET
	@Path("/searchRoommates/")
	@Produces({ MediaType.APPLICATION_JSON })
    public JSONResponseWrapper searchRoommates(@QueryParam("lookingCity") String lookingCity,@QueryParam("lookingAreaInCity") String lookingAreaInCity, 
    		@QueryParam("userGender") String userGender, @QueryParam("userOccupation") String userOccupation, @QueryParam("monthlyBudget") String monthlyBudget){
		log.debug("Start --searchRoommate()");
		JSONResponseWrapper jSONResponseWrapper = new JSONResponseWrapper();
		List<MyMateListing> myMateListingList = new ArrayList<MyMateListing>();
		Update update = new Update();
		try {
			MyMateListing roommateParam = new MyMateListing();
			roommateParam.setLookingInCity(lookingCity);
			roommateParam.setLookingforArea(lookingAreaInCity);
			roommateParam.setUserGender(userGender);
			roommateParam.setUserOccupation(userOccupation);
			roommateParam.setMonthlyBudget(monthlyBudget);
			myMateListingList = businessLogic.searchRoommates(roommateParam);
			if(myMateListingList!=null){
				update.setMyMateListingList(myMateListingList);
				jSONResponseWrapper.setUpdate(update);
			}
		} catch (Exception exp) {
			log.error("Error while seraching room mate"+exp.getStackTrace());
		}
		log.debug("Ends--In ajax call handler searchRoommate");
		return jSONResponseWrapper;
    }
	
	@GET
	@Path("/searchRooms/")
	@Produces({ MediaType.APPLICATION_JSON })
    public JSONResponseWrapper searchRooms(@QueryParam("lookingCity") String lookingCity,@QueryParam("lookingAreaInCity") String lookingAreaInCity, 
    		@QueryParam("mateGender") String mateGender, @QueryParam("propertyType") String propertyType, @QueryParam("monthlyRent") String monthlyRent){
		log.debug("Start --searchRooms()");
		JSONResponseWrapper jSONResponseWrapper = new JSONResponseWrapper();
		List<MyRoomListing> myRoomListingList = new ArrayList<MyRoomListing>();
		Update update = new Update();
		try {
			MyRoomListing roomParam = new MyRoomListing();
			roomParam.setRoomInCity(lookingCity);
			roomParam.setRoomAreaInCity(lookingAreaInCity);
			roomParam.setMateGender(mateGender);
			roomParam.setPropertyType(propertyType);
			roomParam.setMonthlyRent(monthlyRent);
			myRoomListingList = businessLogic.searchRooms(roomParam);
			if(myRoomListingList!=null){
				update.setMyRoomListingList(myRoomListingList);
				jSONResponseWrapper.setUpdate(update);
			}
		} catch (Exception exp) {
			log.error("Error while seraching room"+exp.getStackTrace());
		}
		log.debug("Ends--In ajax call handler searchRooms");
		return jSONResponseWrapper;
    }
}
