package com.roomie.web.core.exception;

public class RoomAppRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 2497485780260884133L;
	private String errorCode;

	public RoomAppRuntimeException() {
		super();
	}

	public RoomAppRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoomAppRuntimeException(String errorCode) {
		super();
	}

	public RoomAppRuntimeException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public RoomAppRuntimeException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public RoomAppRuntimeException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
