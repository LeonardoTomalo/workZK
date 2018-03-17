package com.demo.pojosModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.catalina.security.SecurityUtil;

public class OpcionDAO extends ClaseDAO {
	
	@SuppressWarnings("unchecked")
	public List<Opcion> getOpciones() {
		List<Opcion> retorno = new ArrayList<Opcion>();

		Query query = getEntityManager().createNamedQuery("Opcion.findAll");
		retorno = (List<Opcion>) query.getResultList();
		
		return retorno;
	}
	
	/*
	 * Retornar la lista de opciones por su rol
	 */
	@SuppressWarnings("unchecked")
	public List<Opcion> getOpcionRol(){
        List<Opcion> resultado;
        int patron=2;
        //Consultar el rol del usuario
        Query consulta2 = getEntityManager().createNamedQuery("Privilegio.usuarioPrivilegio");
		consulta2.setParameter("patron", patron);
		System.out.println(consulta2.getResultList());
		int id_rol= (int) consulta2.getSingleResult();
	    
	    System.out.println("rol: " +id_rol);  
          //Consultar opcion de acuerdo a su rol
        Query query = getEntityManager().createNamedQuery("Opcion.opcionPrivilegio");
        query.setHint("javax.persistence.cache.storeMode", "REFRESH");
        query.setParameter("patron",id_rol);
   
        //obtener la lista del menu
        resultado = (List<Opcion>) query.getResultList();
        
        return resultado;
    }
}
