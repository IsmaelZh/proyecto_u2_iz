package com.uce.edu.demo.modelo.Cprueba.repository;

import com.uce.edu.demo.modelo.Cprueba.Propietario;

public interface IPropietarioJpaRepository {
	
	//Crear
	public void insertar(Propietario p);
	
	//Eliminar
    public void eliminar(String cedula);
    
    //Buscar
    public Propietario consultarPorCedula(String cedula);
    
	
}
