package com.uce.edu.demo.modelo.Cprueba;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "propietario")
public class Propietario {
	
	@Id
	@Column (name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prop_id_seq")
	@SequenceGenerator(name = "prop_id_seq", sequenceName = "prop_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "prop_cedula")
	private String cedula;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	@Column(name = "prop_apellido")
	private String apellido;
	
	@OneToOne(mappedBy = "propietario", cascade = CascadeType.ALL)
	private Matricula matricula;

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	//Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
