package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Jugador;

public interface IJugadorRepository {

	public void insertar (Jugador jugador);
	public Jugador buscar (String nombre);
	public void actualizar (Jugador jugador);
	public void eliminar (String nombre);
	
}
