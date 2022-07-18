package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaService {

	public Estudiante buscar (Integer id);
	public Estudiante buscarPorCedulaTyped (String cedula);
	public List<Estudiante> buscarPorCarreraTyped(String carrera);
	public Estudiante buscarPorCedulaNamed (String cedula);
	public List<Estudiante> buscarPorEdadNamed(Integer edad);
	public List<Estudiante> buscarPorCarreraTypedNamed(String carrera);
	public List<Estudiante> buscarPorApellidoEdadTypedNamed(String apellido, Integer edad);
	public Estudiante buscarPorCedulaNative(String cedula);
	public List<Estudiante> buscarPorCarreraNative(String carrera);
	public Estudiante buscarPorCedulaNamedNative(String cedula);
	public List<Estudiante> buscarPorEdadNamedNative(Integer edad);
	public List<Estudiante> buscarPorCarreraEdadCriteriaAPI(String carrera, Integer edad);
	public List<Estudiante> buscarDinamicamenteCriteriaAPI(String nombre, String apellido, String carrera, Integer edad);
	public void insertar(Estudiante estudiante);
	public void actualizar (Estudiante estudiante);
	public void eliminar (Integer id);
	
}
