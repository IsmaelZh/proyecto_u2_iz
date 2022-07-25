package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Equipo;

public interface IEquipoService {

	public void insertar (Equipo equipo);
	public Equipo buscar (String nombre);
	public void actualizar (Equipo equipo);
	public void eliminar (String nombre);
	
}
