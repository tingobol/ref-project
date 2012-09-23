package com.dahg.project.ref.controller.beans.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.dahg.project.ref.controller.services.local.ApplicationInfo;

@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class AplicationInfoImpl implements ApplicationInfo {

	@Value("${app.name}")
	private String applicationName;
	
	@Override
	public String getAplicationName() {
		return applicationName;
	}

}
