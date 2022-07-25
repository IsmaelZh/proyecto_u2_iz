package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEquipoRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService{

	@Autowired
	private IEquipoRepository equipoRepository;
	
	@Override
	public void insertar(Equipo equipo) {
		// TODO Auto-generated method stub
		this.equipoRepository.insertar(equipo);
	}

	@Override
	public Equipo buscar(String nombre) {
		// TODO Auto-generated method stub
		return this.equipoRepository.buscar(nombre);
	}

	@Override
	public void actualizar(Equipo equipo) {
		// TODO Auto-generated method stub
		this.equipoRepository.actualizar(equipo);
	}

	@Override
	public void eliminar(String  nombre) {
		// TODO Auto-generated method stub
		this.equipoRepository.eliminar(nombre);
	}

	
	
}
