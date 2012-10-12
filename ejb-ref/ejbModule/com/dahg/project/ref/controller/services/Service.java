package com.dahg.project.ref.controller.services;

import com.dahg.project.ref.controller.exception.ControllerException;

public interface Service<T> {

	T getById(Object id);	
	void persist(T obj) throws ControllerException;
	void merge(T obj);
	void remove(T obj);
	
}
