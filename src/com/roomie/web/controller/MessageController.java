package com.roomie.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roomie.web.businesslogic.IBusinessLogic;
import com.roomie.web.dao.entity.Message;

@Controller
public class MessageController {

	protected final static Log logger = LogFactory.getLog(MessageController.class);

	@Autowired
	private IBusinessLogic businessLogic;
	
	@RequestMapping(value = "/sendMessage")
    public String sendMessage(ModelMap map, Message message){
		logger.debug("Start---sendMessage()");
		String messageText = businessLogic.sendMessage(message);
		map.put("message", messageText);
		logger.debug("End---sendMessage()");
		return "messagePage";
    }
	
	@RequestMapping(value = "/deleteMsg")
    public String deleteMessage(ModelMap map, @RequestParam(required=true) String msgId){
		logger.debug("Start---deleteMessage() with msgId:"+msgId);
		businessLogic.deleteMessage(msgId);
		logger.debug("End---deleteMessage()");
        return "redirect:/profileMessages";
    }

	@RequestMapping(value = "/markMsgAsRead")
    public String markMsgAsRead(ModelMap map, @RequestParam(required=true) String msgId){
		logger.debug("Start---markMsgAsRead() with msgId:"+msgId);
		businessLogic.markMsgAsRead(msgId);
		logger.debug("End---markMsgAsRead()");
        return "redirect:/profileMessages";
    }
}
