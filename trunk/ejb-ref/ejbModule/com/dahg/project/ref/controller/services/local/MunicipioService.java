package com.dahg.project.ref.controller.services.local;

import javax.ejb.Local;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.Municipio;

@Local
public interface MunicipioService extends CatalogService<Municipio> {

}
