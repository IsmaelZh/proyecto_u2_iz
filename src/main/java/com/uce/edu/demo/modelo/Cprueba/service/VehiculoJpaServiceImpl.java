package com.uce.edu.demo.modelo.Cprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Cprueba.Vehiculo;
import com.uce.edu.demo.modelo.Cprueba.repository.IVehiculoJpaRepository;

@Service
public class VehiculoJpaServiceImpl implements IVehiculoJpaService {

	@Autowired
	private IVehiculoJpaRepository iVehiculoRepository;
	
	@Override
	public void insertar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.insertar(v);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.buscarPorPlaca(placa);
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.actualizar(v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.eliminar(placa);
	}

}
