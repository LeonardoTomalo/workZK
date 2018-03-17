package com.demo.controllers;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

import com.demo.pojosModel.Opcion;
import com.demo.pojosModel.OpcionDAO;

public class Menu {
	
	public List<Opcion> getOpcion(){
		OpcionDAO opcionDao = new OpcionDAO();
		
		return opcionDao.getOpcionRol();
	}
	
	@Command
	@NotifyChange("formularioActual")
	public void cargaUrl(@BindingParam("url") String url) {
		
		if (url.substring(0,4).toLowerCase().equals("http")) {
			Sessions.getCurrent().setAttribute("FormularioActual", null);
			Executions.getCurrent().sendRedirect(url, "_blank");			
		}else{
			Sessions.getCurrent().setAttribute("FormularioActual", url);
		}
	}

	public String getFormularioActual(){
		return (String) Sessions.getCurrent().getAttribute("FormularioActual");
	}
}
