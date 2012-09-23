package com.dahg.project.ref.controller.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SpringPersistence  {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}	
	
}
