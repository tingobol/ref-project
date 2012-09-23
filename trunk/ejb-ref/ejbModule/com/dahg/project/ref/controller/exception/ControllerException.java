package com.dahg.project.ref.controller.exception;

import java.io.Serializable;

public class ControllerException extends Exception implements Serializable {

	public ControllerException(String msg) {
		super(msg);
	}
	
	public ControllerException(Throwable ex) {
		super(ex);
	}
	
}
