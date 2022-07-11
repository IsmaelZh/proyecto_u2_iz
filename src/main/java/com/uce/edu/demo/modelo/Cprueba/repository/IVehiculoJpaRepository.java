package com.uce.edu.demo.modelo.Cprueba.repository;

import com.uce.edu.demo.modelo.Cprueba.Vehiculo;

public interface IVehiculoJpaRepository {
	
	//C: crear/insertar 
	public void insertar(Vehiculo v);
	//R: leer/buscar
	public Vehiculo buscarPorPlaca(String placa);
	//U: actualizar 
	public void actualizar (Vehiculo v);
	//D: eliminar
    public void eliminar(String placa);
	
}
