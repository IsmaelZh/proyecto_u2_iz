package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CiudadanoTarea;

public interface ICiudadoTareaJpaRepo {

	public void insertar (CiudadanoTarea cuidadano);
	public CiudadanoTarea buscar (String cedula);
	public void actualizar (CiudadanoTarea cuidadano);
	public void eliminar (String cedula);
	
}
