package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	
	public List<Persona> buscarPorApellido(String apellido);
	public List<Persona> buscarPorNombreApellido(String apellido, String nombre);
	public List<Persona> buscarPorNombre(String nombre);
	public List<Persona> buscarPorGenero(String genero);
	public Persona buscarPorCedula(String cedula);
	public Persona buscarPorCedulaTyped(String cedula);
	public Persona buscarPorCedulaNamed(String cedula);
	public Persona buscarPorCedulaTypedNamed(String cedula);
	public Persona buscarPorCedulaNative(String cedula);
	public Persona buscarPorCedulaNamedNative(String cedula);
	public Persona buscarPorCedulaCriteriaApi(String cedula);
	public Persona buscarPorId (Integer id);
	public void insertar (Persona persona);
	public void actualizar (Persona persona);
	public void eliminar (Integer id);
	
	public int actualizarPorApellido(String genero,String apellido);
	public int eliminarPorGenero(String genero);
	
}
