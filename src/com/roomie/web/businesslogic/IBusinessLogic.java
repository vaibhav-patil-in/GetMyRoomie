package com.roomie.web.businesslogic;

import java.util.List;

import com.roomie.web.dao.entity.Message;
import com.roomie.web.dao.entity.MyMateListing;
import com.roomie.web.dao.entity.MyRoomListing;
import com.roomie.web.dao.entity.RoomList;
import com.roomie.web.dao.entity.RoomMateList;
import com.roomie.web.dao.entity.User;

public interface IBusinessLogic {
	
	public String registerUser(User user);
	
	public User updateUser(User user);
	
	public RoomMateList createRoomMateList(RoomMateList roomMate);
	
	public User findUserByUserEmail(String userEmail);
	
	public String verifyEmail(String param);
	
	public RoomMateList getAllRoomMateList();
	
	public MyMateListing getAllMyMateListing();
	
	public User getCurrentUserProfile();
	
	public RoomMateList updateRoomMateList(RoomMateList roomMate);
	
	public User checkUserEmailExist(String userEmail);
	
	public RoomList createRoomList(RoomList room);
	
	public RoomList updateRoomList(RoomList room);
	
	public RoomList getAllRoomList();
	
	public MyRoomListing getAllMyRoomListing();
	
	public List<MyRoomListing> getAllRoomsList();
	
	public List<MyMateListing> getAllMatesList();
	
	public void updateRoomMateStatus(String status);
	
	public void updateRoomStatus(String status);
	
	public MyMateListing getRoomMateDetailsByEmail(String email);
	
	public MyRoomListing  getRoomDetailsByEmail(String email);
	
	public String recoverPassword(String email);
	
	public String updatePassword(User user);
	
	public String sendMessage(Message message);
	
	public List<Message> getAllMyMessages();
	
	public void deleteMessage(String msgId);
	
	public void markMsgAsRead(String msgId);
	
	public List<MyRoomListing> searchRooms(MyRoomListing roomParam);
	
	public List<MyMateListing> searchRoommates(MyMateListing roommateParam);
	
	public String shortList(String shortListingUserEmail,String shortListingType);
	
	public List<MyRoomListing> searchRoomsFromHomePage(String homeLocation);
	
	public List<MyMateListing> searchRoommatesFromHomePage(String homeLocation);
}
