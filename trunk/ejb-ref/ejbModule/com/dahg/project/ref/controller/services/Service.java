package com.dahg.project.ref.controller.services;

public interface Service<T> {

	T getById(Object id);	
	void persist(T obj);
	void merge(T obj);
	void remove(T obj);
	
}
