package com.dahg.project.ref.controller.services.local;

import javax.ejb.Local;

@Local
public interface ApplicationInfo {

	String getApplicationName();
	String getCityName();
}
