package com.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.pojosModel.Usuario;
import com.demo.pojosModel.UsuarioDAO;
import com.demo.pojosModel.UsuarioPrivilegio;



public class ServicioAutenticacion implements UserDetailsService {

	/**
	 * Este metodo es invocado en el momento de la autenticacion paraa recuperar 
	 * los datos del usuario.
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario; 
		User usuarioSpring;
		List<GrantedAuthority> privilegios; 

		usuario = usuarioDAO.getUsuarios(nombreUsuario);
		privilegios = obtienePrivilegios(usuario);

		// Construye un objeto de Spring en base a los datos del usuario de la base de datos.
		usuarioSpring = new User(usuario.getUsuario(), usuario.getClave(), privilegios);
		
		return usuarioSpring;
	}

	/**
	 * Elabora una lista de objetos del tipo GrantedAuthority en base a los privilegios
	 * del usuario.
	 * 
	 * @param usuario
	 * @return
	 */
	private List<GrantedAuthority> obtienePrivilegios(Usuario usuario) {
		List<GrantedAuthority> listaPrivilegios = new ArrayList<GrantedAuthority>(); 

		for(UsuarioPrivilegio rolUsuario  : usuario.getUsuarioPrivilegios()){
			listaPrivilegios.add(new SimpleGrantedAuthority(rolUsuario.getPrivilegio().getDescripcion()));
		}

		return listaPrivilegios;
	}

}
