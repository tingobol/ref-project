package com.dahg.project.ref.controller.test;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Test {

	public String getNada() {
		return "Nada";
	}
}
