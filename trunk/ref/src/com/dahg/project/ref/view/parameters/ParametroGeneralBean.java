package com.dahg.project.ref.view.parameters;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dahg.project.ref.controller.exception.ControllerException;
import com.dahg.project.ref.controller.services.local.LogicService;
import com.dahg.project.ref.controller.services.local.TextoService;
import com.dahg.project.ref.model.parameters.Logic;
import com.dahg.project.ref.model.parameters.Texto;
import com.dahg.project.ref.view.AbstractManagedBean;

@ManagedBean(name="parametro")
@ViewScoped
public class ParametroGeneralBean extends AbstractManagedBean {

	@EJB
	private TextoService textoService;
	@EJB
	private LogicService logicService;
	
	private Texto jefeREF;
	private Texto rubricaJefeREF;
	private Texto cargoJefeREF;
	private Logic firmaJefeREF;
	
	@PostConstruct
	public void init() {		
		try {
			setJefeREF(textoService.getParametro("JEFEREF"));
			setRubricaJefeREF(textoService.getParametro("RUBRICASUBJREF"));
			setCargoJefeREF(textoService.getParametro("CARGOJEFEREF"));
			setFirmaJefeREF(logicService.getParametro("FIRMAJEFEREF"));
		} catch (ControllerException e) {
			addError(e);
		}
	}
	
	public String guardar() {
		textoService.merge(jefeREF);
		textoService.merge(rubricaJefeREF);
		textoService.merge(cargoJefeREF);
		logicService.merge(firmaJefeREF);
		addInfo("Parametros guardados");
		return null;
	}

	public Texto getJefeREF() {
		return jefeREF;
	}

	public void setJefeREF(Texto jefeREF) {
		this.jefeREF = jefeREF;
	}

	public Texto getRubricaJefeREF() {
		return rubricaJefeREF;
	}

	public void setRubricaJefeREF(Texto rubricaJefeREF) {
		this.rubricaJefeREF = rubricaJefeREF;
	}

	public Texto getCargoJefeREF() {
		return cargoJefeREF;
	}

	public void setCargoJefeREF(Texto cargoJefeREF) {
		this.cargoJefeREF = cargoJefeREF;
	}

	public Logic getFirmaJefeREF() {
		return firmaJefeREF;
	}

	public void setFirmaJefeREF(Logic firmaJefeREF) {
		this.firmaJefeREF = firmaJefeREF;
	}
	
	
}
