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
		return info.getAplicationName();
	}
	
}