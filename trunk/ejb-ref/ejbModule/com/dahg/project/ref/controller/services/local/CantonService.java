package com.dahg.project.ref.controller.services.local;

import javax.ejb.Local;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.impl.Canton;

@Local
public interface CantonService extends CatalogService<Canton>{

}
