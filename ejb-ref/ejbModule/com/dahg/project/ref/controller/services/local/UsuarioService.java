package com.dahg.project.ref.controller.services.local;

import java.util.List;

import javax.ejb.Local;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.exception.ValidationException;
import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.model.impl.Usuario;

@Local
public interface UsuarioService extends Service<Usuario>{

	List<Usuario> getAll();
	Usuario validate(String user, String pass) throws ValidationException,ControllerException;
	void changePassword(Usuario usuario, String oldPassword, String newPassword) throws ValidationException;
	void changePassword(Usuario usuario, String newPassword) throws ValidationException;
	void isAuthorized(String section,Usuario usuario) throws ValidationException;
}
