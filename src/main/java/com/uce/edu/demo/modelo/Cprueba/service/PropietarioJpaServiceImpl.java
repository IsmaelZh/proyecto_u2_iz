package com.uce.edu.demo.modelo.Cprueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Cprueba.Propietario;
import com.uce.edu.demo.modelo.Cprueba.repository.IPropietarioJpaRepository;

@Service
public class PropietarioJpaServiceImpl implements IPropietarioJpaService {
	
	@Autowired
	private IPropietarioJpaRepository iPropietarioJpaRepository;
	
	@Override
	public void crear(Propietario p) {
		// TODO Auto-generated method stub
		this.iPropietarioJpaRepository.insertar(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iPropietarioJpaRepository.eliminar(cedula);
	}

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.iPropietarioJpaRepository.consultarPorCedula(cedula);
	}

}
