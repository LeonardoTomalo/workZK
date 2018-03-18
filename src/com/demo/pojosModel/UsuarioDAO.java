package com.demo.pojosModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class UsuarioDAO extends ClaseDAO {

	public List<Usuario> getUsuario() {
		List<Usuario> retorno = new ArrayList<Usuario>();

		Query query = getEntityManager().createNamedQuery("Usuario.findAll");
		retorno = (List<Usuario>) query.getResultList();
		
		return retorno;
	}
	
	/*
	 * Retorna un usuario en base a su nombre de usuario.
	 */
	public Usuario getUsuarios(String nombreUsuario) {
		
		 	Usuario usuario; 
			Query consulta;
			
			consulta = getEntityManager().createNamedQuery("Usuario.buscaUsuario");
			consulta.setParameter("nombreUsuario", nombreUsuario);
			usuario =  (Usuario) consulta.getSingleResult();
			
			return usuario;
	}
	
}
