package com.dahg.project.ref.controller.services.local;

import java.util.List;

import javax.ejb.Local;

import com.dahg.project.ref.controller.services.Service;
import com.dahg.project.ref.model.impl.Rol;

@Local
public interface RolService extends Service<Rol>{

	List<Rol> getAll();
}
