package com.roomie.web.dao;

import java.util.List;

import com.roomie.web.dao.entity.Message;
import com.roomie.web.dao.entity.MyRoomListing;
import com.roomie.web.dao.entity.RoomList;
import com.roomie.web.dao.entity.RoomMateList;
import com.roomie.web.dao.entity.RoomShortListings;
import com.roomie.web.dao.entity.User;

public interface IDaoFactory {

	public void registerUser(User user);
	
	public User findUserByUserEmail(String userEmail);
	
	public void updateUser(User user);
	
	public void verifyEmail(String email,String otp);
	
	public void createRoomMateList(RoomMateList roomMate);
	
	public RoomMateList getAllRoomMateListByEmail(String email);
	
	public void updateRoomMateList(RoomMateList roomMate);
	
	public User checkUserEmailExist(String userEmail);
	
	public void createRoomList(RoomList room);
	
	public void updateRoomList(RoomList room);
	
	public RoomList getAllRoomListByEmail(String email);
	
	public List<RoomList> getAllRoomsList();
	
	public List<RoomMateList> getAllRoomMatesList();
	
	public void updateRoomMateStatus(String status, String email);
	
	public void updateRoomStatus(String status, String email);
	
	public void updatePassword(User user);
	
	public void sendMessage(Message message);
	
	public List<Message> getAllMyMessages(String email);
	
	public void deleteMessage(String msgId);
	
	public void markMsgAsRead(String msgId);
	
	public List<RoomList> searchRooms(MyRoomListing roomParam);
	
	public void shortList(RoomShortListings shortList);
	
	public List<RoomList> searchRoomsFromHomePage(String homeLocation);
}
