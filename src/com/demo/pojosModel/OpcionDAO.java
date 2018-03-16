package com.demo.pojosModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class OpcionDAO extends ClaseDAO {
	
	@SuppressWarnings("unchecked")
	public List<Opcion> getOpciones() {
		List<Opcion> retorno = new ArrayList<Opcion>();

		Query query = getEntityManager().createNamedQuery("Opcion.findAll");
		retorno = (List<Opcion>) query.getResultList();
		
		return retorno;
	}
}
