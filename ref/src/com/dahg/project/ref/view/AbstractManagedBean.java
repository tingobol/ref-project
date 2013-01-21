package com.dahg.project.ref.view;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.dahg.project.ref.controller.exception.ValidationException;

public abstract class AbstractManagedBean {
	
	@ManagedProperty("#{app}")
	private ResourceBundle bundle;

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	private void addMessage(String msg, Severity severity) {
		FacesMessage message = new FacesMessage();
		message.setDetail(msg);
		message.setSummary(msg);
		message.setSeverity(severity);
		getFacesContext().addMessage(null, message);
	}
	
	public String getMessageKey(String key) {
		return bundle.getString(key);
	}
	
	public void addInfo(String msg) {
		addMessage(msg, FacesMessage.SEVERITY_INFO);
	}
	
	public void addError(String msg) {
		addMessage(msg, FacesMessage.SEVERITY_ERROR);
	}
	
	public void addError(Throwable e) {
		String msg=(e instanceof ValidationException)?e.getCause().getMessage():e.getMessage();			
		addMessage(msg, FacesMessage.SEVERITY_ERROR);
	}
	
	public void addWarn(String msg) {
		addMessage(msg, FacesMessage.SEVERITY_WARN);
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}
	
	protected RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}
	
}
