package com.demo.pojosModel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the opcion_privilegio database table.
 * 
 */
@Entity
@Table(name="opcion_privilegio")

@NamedQueries({
@NamedQuery(name="OpcionPrivilegio.findAll", query="SELECT o FROM OpcionPrivilegio o"),
@NamedQuery(name="OpcionRol.OpcionAcceso", query="SELECT o "
		+ "FROM OpcionPrivilegio o,Opcion m,Privilegio r "
		+ "WHERE o.opcion.id=m.id AND o.privilegio.id=r.id AND o.privilegio.id=:patron AND o.estado='A' "),
@NamedQuery(name="OpcionPrivilegio.OpcionSinAcceso", query= "SELECT m "
		+ "FROM Opcion m WHERE m.id NOT IN (SELECT a.opcion.id FROM OpcionPrivilegio a WHERE a.privilegio.id=:patron AND a.estado='A') "
		+ "AND m.estado='A' "),
@NamedQuery(name="OpcionPrivilegio.OpcionAccesoEliminado", query= " SELECT a.id FROM OpcionPrivilegio a WHERE a.privilegio.id=:patron1 AND a.opcion.id=:patron2 AND a.estado='E'")

})
public class OpcionPrivilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String estado;

	//bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name="id_opcion")
	private Opcion opcion;

	//bi-directional many-to-one association to Privilegio
	@ManyToOne
	@JoinColumn(name="id_privilegio")
	private Privilegio privilegio;

	public OpcionPrivilegio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Opcion getOpcion() {
		return this.opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public Privilegio getPrivilegio() {
		return this.privilegio;
	}

	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

}