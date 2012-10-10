package com.dahg.project.ref.controller.services.local;

import javax.ejb.Local;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.model.impl.Usuario;

@Local
public interface UsuarioService extends Service<Usuario>{

	Usuario validate(String user, String pass) throws ValidationException,ControllerException;
	
}
