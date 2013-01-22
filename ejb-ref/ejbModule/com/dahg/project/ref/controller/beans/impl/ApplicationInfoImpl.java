package com.dahg.project.ref.controller.beans.impl;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.dahg.project.ref.controller.services.local.ApplicationInfo;

@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ApplicationInfoImpl implements ApplicationInfo {
	
	@Autowired
	@Qualifier("resourceBundle")
	private Properties resourceBundle;	
	
	@Override
	public String getApplicationName() {
		return getProperty("app.name");
	}

	@Override
	public String getCityName() {
		return getProperty("app.city.name");
	}

	@Override
	public String getProperty(String key) {
		String text = this.resourceBundle.getProperty(key);
		if (text==null || text.isEmpty()) return String.format("@%s@", key);
		return text;
	}
	
	

}

