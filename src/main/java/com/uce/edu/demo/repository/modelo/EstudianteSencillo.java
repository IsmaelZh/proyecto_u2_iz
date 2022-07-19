package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String apellido;
	private String cedula;
	private String carrera;

	public EstudianteSencillo() {

	}

	public EstudianteSencillo(String carrera, String apellido, String cedula) {

		this.carrera = carrera;
		this.apellido = apellido;
		this.cedula = cedula;

	}
	
	@Override
	public String toString() {
		return "EstudianteSencillo [apellido=" + apellido + ", cedula=" + cedula + ", carrera=" + carrera + "]";
	}

	// Set y Get
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
