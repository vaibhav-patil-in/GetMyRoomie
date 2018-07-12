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
@Table(name = "USER_MESSAGES")
public class Message implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MSG_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long msgId;
	
	@Column(name="MSG_SENDER")
	private String msgSenderEmail;
	
	@Column(name="MSG_RECEIVER")
	private String msgReceiverEmail;
	
	@Column(name="MSG_SUBJECT")
	private String msgSubject;
	
	@Column(name="MSG_BODY")
	private String msgBody;
	
	@Column(name="MSG_MARKED_READ")
	private String msgMarkedRead;

	@Column(name="MSG_SENDER_USERNAME")
	private String msgSenderUserName;
	
	@Column(name="MSG_SENDER_PROFILE_IMG")
	private Text msgSenderProfileImgText;
	private String msgSenderProfileImg;
	
	@Column(name="MSG_SENT_DATE_TIME")
	private String msgSentDateTime;
	
	public Message(){
		
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getMsgSenderEmail() {
		return msgSenderEmail;
	}

	public void setMsgSenderEmail(String msgSenderEmail) {
		this.msgSenderEmail = msgSenderEmail;
	}

	public String getMsgReceiverEmail() {
		return msgReceiverEmail;
	}

	public void setMsgReceiverEmail(String msgReceiverEmail) {
		this.msgReceiverEmail = msgReceiverEmail;
	}

	public String getMsgSubject() {
		return msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getMsgMarkedRead() {
		return msgMarkedRead;
	}

	public void setMsgMarkedRead(String msgMarkedRead) {
		this.msgMarkedRead = msgMarkedRead;
	}

	public String getMsgSenderUserName() {
		return msgSenderUserName;
	}

	public void setMsgSenderUserName(String msgSenderUserName) {
		this.msgSenderUserName = msgSenderUserName;
	}
	
	public Text getMsgSenderProfileImgText() {
		return msgSenderProfileImgText;
	}

	public void setMsgSenderProfileImgText(Text msgSenderProfileImgText) {
		this.msgSenderProfileImgText = msgSenderProfileImgText;
	}

	public String getMsgSenderProfileImg() {
		return msgSenderProfileImg;
	}

	public void setMsgSenderProfileImg(String msgSenderProfileImg) {
		this.msgSenderProfileImg = msgSenderProfileImg;
	}

	public String getMsgSentDateTime() {
		return msgSentDateTime;
	}

	public void setMsgSentDateTime(String msgSentDateTime) {
		this.msgSentDateTime = msgSentDateTime;
	}
}
