package com.crud.hibernate.customexception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessgae;

	public ControllerException() {
		super();

	}

	public ControllerException(String errorCode, String errorMessgae) {
		super();
		this.errorCode = errorCode;
		this.errorMessgae = errorMessgae;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessgae() {
		return errorMessgae;
	}

	public void setErrorMessgae(String errorMessgae) {
		this.errorMessgae = errorMessgae;
	}
}