package com.roomie.web.core.exception;

public class RoomAppException extends Exception {
	private static final long serialVersionUID = -3670635856159034539L;
	private String errorCode;

	public RoomAppException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public RoomAppException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
