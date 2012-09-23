package com.dahg.project.ref.view.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractManagedBean {
	
	public boolean test(String arg) {		
		return !(arg.indexOf("ADMIN")>-1);
	}
	
}
