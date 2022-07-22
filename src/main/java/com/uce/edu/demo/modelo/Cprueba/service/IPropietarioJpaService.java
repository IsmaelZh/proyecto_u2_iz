package com.uce.edu.demo.modelo.Cprueba.service;

import com.uce.edu.demo.modelo.Cprueba.Propietario;

public interface IPropietarioJpaService {
	
	public void crear(Propietario p);
	public Propietario buscar(String cedula);
	public void eliminar(String cedula);
	
}
