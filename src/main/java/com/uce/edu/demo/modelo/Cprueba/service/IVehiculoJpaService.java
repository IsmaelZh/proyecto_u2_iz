package com.uce.edu.demo.modelo.Cprueba.service;

import com.uce.edu.demo.modelo.Cprueba.Vehiculo;

public interface IVehiculoJpaService {
	
	public void insertar(Vehiculo v);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo v);
	public void eliminar(String placa);
	
}
