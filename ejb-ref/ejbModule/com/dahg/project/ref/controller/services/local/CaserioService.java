package com.dahg.project.ref.controller.services.local;

import javax.ejb.Local;

import com.dahg.project.ref.controller.services.CatalogService;
import com.dahg.project.ref.model.impl.Caserio;

@Local
public interface CaserioService extends CatalogService<Caserio>{

}
