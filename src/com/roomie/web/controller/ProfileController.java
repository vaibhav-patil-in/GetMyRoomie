package com.roomie.web.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roomie.web.WebAppConstants;
import com.roomie.web.businesslogic.IBusinessLogic;
import com.roomie.web.dao.entity.Message;
import com.roomie.web.dao.entity.MyMateListing;
import com.roomie.web.dao.entity.MyRoomListing;
import com.roomie.web.dao.entity.RoomList;
import com.roomie.web.dao.entity.RoomMateList;
import com.roomie.web.dao.entity.User;

@Controller
public class ProfileController {

	protected final static Log logger = LogFactory.getLog(ProfileController.class);

	@Autowired
	private IBusinessLogic businessLogic;
	
	@RequestMapping(value = "/profile")
    public String getProfile(ModelMap map){
		logger.debug("Start---getProfile()");
		User user = businessLogic.getCurrentUserProfile();
		map.put("user", user);
		map.put("messageCount", getMessageCount());
		logger.debug("End---getProfile()");
        return "profile";
    }
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public String updateProfile(ModelMap map, User user){
		logger.debug("Start---updateProfile()");
		businessLogic.updateUser(user);
		map.put("messageCount", getMessageCount());
		logger.debug("End---updateProfile()");
        return "profile";
    }
	
	@RequestMapping(value = "/profileNeedARoom")
    public String getProfileNeedARoom(ModelMap map){
		logger.debug("Start---getProfileNeedARoom()");
		
		MyMateListing myListing = null;
        myListing = businessLogic.getAllMyMateListing();
        if(myListing!=null){
        	RoomMateList roomMate = null;
        	roomMate = businessLogic.getAllRoomMateList();
        	map.put("roomMate", roomMate);
        	map.put("action", "updateRoomMateList");
        }else{
        	map.put("action", "createRoomMateList");
        }
        map.put("messageCount", getMessageCount());
		logger.debug("End---getProfileNeedARoom()");
        return "profileNeedARoom";
    }
	
	@RequestMapping(value = "/createRoomMateList", method = RequestMethod.POST)
    public String createRoomMateList(ModelMap map,RoomMateList roomMate){
		logger.debug("Start - In createRoomMateList()- Room mate creation started");
		try{
			businessLogic.createRoomMateList(roomMate);			
		}catch (Exception e) {
			logger.debug("Exception - In createRoomMateList()- Error occurred in Room mate list creation"+e.getStackTrace());
		}
        logger.debug("End - In createRoomMateList()- user created succesfully.");
        return "redirect:/profileMyListing";
    }
	
	@RequestMapping(value = "/updateRoomMateList", method = RequestMethod.POST)
    public String updateRoomMateList(ModelMap map,RoomMateList roomMate){
		logger.debug("Start - In updateRoomMateList()- Room mate creation started");
		try{
			businessLogic.updateRoomMateList(roomMate);
		}catch (Exception e) {
			logger.debug("Exception - In updateRoomMateList()- Error occurred in Room mate list creation"+e.getStackTrace());
		}
        logger.debug("End - In updateRoomMateList()- user created succesfully.");
        return "redirect:/profileMyListing";
    }

	@RequestMapping(value = "/profileListARoom")
    public String getProfileListARoom(ModelMap map){
		logger.debug("Start---getProfileListARoom()");

		MyRoomListing myRoomListing = null;
		myRoomListing = businessLogic.getAllMyRoomListing();
        if(myRoomListing!=null){
        	RoomList room = null;
        	room = businessLogic.getAllRoomList();
        	map.put("room", room);
        	map.put("action", "updateRoomList");
        }else{
        	map.put("action", "createRoomList");
        }
        map.put("messageCount", getMessageCount());
		logger.debug("End---getProfileListARoom()");
        return "profileListARoom";
    }
	
	@RequestMapping(value = "/createRoomList", method = RequestMethod.POST)
    public String createRoomList(ModelMap map,RoomList room){
		logger.debug("Start - In createRoomList()- Room creation started");
		try{
			businessLogic.createRoomList(room);			
		}catch (Exception e) {
			logger.debug("Exception - In createRoomList()- Error occurred in Room list creation"+e.getStackTrace());
		}
        logger.debug("End - In createRoomList()- user created succesfully.");
        return "redirect:/profileMyListing";
    }
	
	@RequestMapping(value = "/updateRoomList", method = RequestMethod.POST)
    public String updateRoomList(ModelMap map,RoomList room){
		logger.debug("Start - In updateRoomList()- Room updating started");
		try{
			businessLogic.updateRoomList(room);
		}catch (Exception e) {
			logger.debug("Exception - In updateRoomList()- Error occurred in Room mate list creation"+e.getStackTrace());
		}
        logger.debug("End - In updateRoomList()- user created succesfully.");
        return "redirect:/profileMyListing";
    }
	
	@RequestMapping(value = "/profileMyListing")
    public String getProfileMyListing(ModelMap map){
		logger.debug("Start --getProfileMyListing() Get user listing that he has created");
		MyMateListing myMateListing = null;
		myMateListing = businessLogic.getAllMyMateListing();
		map.put("myMateListing", myMateListing);
		
		MyRoomListing myRoomListing = null;
		myRoomListing = businessLogic.getAllMyRoomListing();
		map.put("myRoomListing", myRoomListing);

		map.put("messageCount", getMessageCount());
		logger.debug("End--getProfileMyListing()"+myMateListing);
        return "profileMyListing";
    }
	
	@RequestMapping(value = "/profileMessages")
    public String getProfileMessages(ModelMap map){
		logger.debug("Start---getProfileMessages()");
		List<Message> myMessages = new ArrayList<Message>();
		myMessages = businessLogic.getAllMyMessages();
		map.put("myMessages", myMessages);
		map.put("messageCount", getMessageCount());
		logger.debug("End---getProfileMessages()");
        return "profileMessages";
    }
	
	@RequestMapping(value = "/profileMyShortList")
    public String getProfileMyShortList(ModelMap map){
		logger.debug("Start---getProfileMyShortList()");
		map.put("messageCount", getMessageCount());
        return "profileMyShortList";
    }
	
	@RequestMapping(value = "/deActivateMateListing")
    public String deActivateMateListing(ModelMap map){
		logger.debug("Start---deActivateMateListing()");
		businessLogic.updateRoomMateStatus(WebAppConstants.LISTING_DEACTIVE);
		return "redirect:/profileMyListing";
    }
	
	@RequestMapping(value = "/activateMateListing")
    public String activateMateListing(ModelMap map){
		logger.debug("Start---activateMateListing()");
		businessLogic.updateRoomMateStatus(WebAppConstants.LISTING_ACTIVE);
		return "redirect:/profileMyListing";
    }
	
	@RequestMapping(value = "/deActivateRoomListing")
    public String deActivateRoomListing(ModelMap map){
		logger.debug("Start---deActivateRoomListing()");
		businessLogic.updateRoomStatus(WebAppConstants.LISTING_DEACTIVE);
		return "redirect:/profileMyListing";
    }
	
	@RequestMapping(value = "/activateRoomListing")
    public String activateRoomListing(ModelMap map){
		logger.debug("Start---activateRoomListing()");
		businessLogic.updateRoomStatus(WebAppConstants.LISTING_ACTIVE);
		return "redirect:/profileMyListing";
    }
	
	@RequestMapping(value = "/shortList")
    public String shortList(ModelMap map, @RequestParam(required=true) String param, @RequestParam(required=false) String listingType){
		logger.debug("Start---shortList()");
		businessLogic.shortList(param, listingType);
		logger.debug("End---shortList()");
		if("roomMate".equalsIgnoreCase(listingType)){
			return "redirect:/viewRoommate?param="+URLEncoder.encode(param);
		}
		if("room".equalsIgnoreCase(listingType)){
			return "redirect:/viewRoom?param="+URLEncoder.encode(param);
		}
		return null;
    }
	
	//Get the messages count and show them in all the tabs...
	public int getMessageCount(){
		List<Message> myMessages = new ArrayList<Message>();
		myMessages = businessLogic.getAllMyMessages();
		if(myMessages!=null){
			return myMessages.size();
		}else{
			return 0;
		}
	}
}
