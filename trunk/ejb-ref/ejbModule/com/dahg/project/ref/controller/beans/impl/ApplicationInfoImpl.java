package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.dahg.project.ref.controller.services.local.ApplicationInfo;

@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ApplicationInfoImpl implements ApplicationInfo {

	@Value("${app.name}")
	private String applicationName;
	@Value("${app.city.name}")
	private String cityName;
	
	@Override
	public String getApplicationName() {
		return applicationName;
	}

	@Override
	public String getCityName() {
		return cityName;
	}

}
