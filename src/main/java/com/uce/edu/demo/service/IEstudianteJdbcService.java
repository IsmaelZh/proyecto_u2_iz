package com.uce.edu.demo.service;

import com.uce.edu.demo.to.Estudiante;

public interface IEstudianteJdbcService {

	public Estudiante buscar (int id);
	public void insertar(Estudiante estudiante);
	public void actualizar (Estudiante estudiante);
	public void eliminar (int id);
	
}
