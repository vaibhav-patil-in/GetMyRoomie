package com.roomie.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roomie.web.businesslogic.IBusinessLogic;
import com.roomie.web.dao.entity.MyMateListing;
import com.roomie.web.dao.entity.MyRoomListing;

@Controller
public class RoomieController {
	
	protected final static Log logger = LogFactory.getLog(RoomieController.class);

	@Autowired
	private IBusinessLogic businessLogic;
	
	@RequestMapping(value = "/browseRooms")
    public String browseRooms(ModelMap map){
		logger.debug("Start --browseRooms()");
		List<MyRoomListing> myRoomListingList = new ArrayList<MyRoomListing>();
		myRoomListingList = businessLogic.getAllRoomsList();
		map.put("myRoomListingList", myRoomListingList);
		logger.debug("End --browseRooms()");
        return "browseRooms";
    }
	
	@RequestMapping(value = "/browseRoomMates")
    public String browseRoomMates(ModelMap map){
		logger.debug("Start --browseRoomMates()");
		List<MyMateListing> myMateListingList = new ArrayList<MyMateListing>();
		myMateListingList = businessLogic.getAllMatesList();
		map.put("myMateListingList", myMateListingList);
		logger.debug("End --browseRoomMates()");
        return "browseRoomMates";
    }
	
	@RequestMapping(value = "/viewRoom")
    public String viewRoom(ModelMap map, @RequestParam(required=false) String param){
		logger.debug("Start --viewRoom()");
		MyRoomListing roomDetails = businessLogic.getRoomDetailsByEmail(param);
		map.put("roomList", roomDetails);
		logger.debug("End --viewRoom()");
        return "viewRoom";
    }
	
	@RequestMapping(value = "/viewRoommate")
    public String viewRoommate(ModelMap map, @RequestParam(required=false) String param){
		logger.debug("Start --viewRoommate()");
		logger.debug("User email is:"+param);
		MyMateListing roomMateDetails = businessLogic.getRoomMateDetailsByEmail(param);
		map.put("roomMateList", roomMateDetails);
		logger.debug("End --viewRoommate()");
        return "viewRoommate";
    }
	
	@RequestMapping(value = "/searchRoomsFromHomePage")
    public String searchRoomsFromHomePage(ModelMap map,@RequestParam(required=true) String homeLocation){
		logger.debug("Start --searchFromHomePage()");
		
		if(StringUtils.isEmpty(homeLocation)){
			return "redirect:/browseRooms";
		}
		
		List<MyRoomListing> myRoomListingList = new ArrayList<MyRoomListing>();
		myRoomListingList = businessLogic.searchRoomsFromHomePage(homeLocation);
		if(myRoomListingList!=null && myRoomListingList.size()>0){
			map.put("myRoomListingList", myRoomListingList);
		}else{
			map.put("myRoomListingList", null);
		}

		MyRoomListing roomParam = new MyRoomListing();
		roomParam.setRoomAreaInCity(homeLocation);
		map.put("room", roomParam);
		logger.debug("End --searchFromHomePage()");
		return "browseRooms";
    }
	
	@RequestMapping(value = "/searchRoommatesFromHomePage")
    public String searchRoommatesFromHomePage(ModelMap map, @RequestParam(required=false) String homeLocation){
		logger.debug("Start --searchRoommatesFromHomePage()");
		
		if(StringUtils.isEmpty(homeLocation)){
			return "redirect:/browseRoomMates";
		}
		
		List<MyMateListing> myMateListingList = new ArrayList<MyMateListing>();
		myMateListingList = businessLogic.searchRoommatesFromHomePage(homeLocation);
		if(myMateListingList!=null && myMateListingList.size()>0){
			map.put("myMateListingList", myMateListingList);
		}else{
			map.put("myMateListingList", null);
		}
		
		MyMateListing roommateParam = new MyMateListing();
		roommateParam.setLookingforArea(homeLocation);
		map.put("roommate", roommateParam);
		logger.debug("End --searchRoommatesFromHomePage()");
		return "browseRoomMates";
    }
}
