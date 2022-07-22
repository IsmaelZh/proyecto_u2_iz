package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CiudadanoTarea;
import com.uce.edu.demo.repository.modelo.Persona;

public interface ICiudadadoTareaJpaService {

	public void insertar (CiudadanoTarea cuidadano);
	public CiudadanoTarea buscar (String cedula);
	public void actualizar (CiudadanoTarea cuidadano);
	public void eliminar (String cedula);
	
	
}
