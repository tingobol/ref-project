package com.dahg.project.ref.view;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dahg.project.ref.controller.services.local.ApplicationInfo;

@ManagedBean(name="info")
@ApplicationScoped
public class ApplicationBean {

	@EJB
	private ApplicationInfo info;
	
	public String getName() {
		return info.getApplicationName();
	}
	
	public String getCityName() {
		return info.getCityName();
	}
	
	public String key(String key) {
		return info.getProperty(key);
	}
	
}
