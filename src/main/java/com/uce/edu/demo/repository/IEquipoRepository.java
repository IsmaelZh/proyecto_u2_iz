package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Equipo;

public interface IEquipoRepository {

	public void insertar (Equipo equipo);
	public Equipo buscar (String nombre);
	public void actualizar (Equipo equipo);
	public void eliminar (String nombre);
	
}
