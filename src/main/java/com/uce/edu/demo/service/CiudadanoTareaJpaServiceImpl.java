package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadoTareaJpaRepo;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.onetoone.CiudadanoTarea;

@Service
public class CiudadanoTareaJpaServiceImpl implements ICiudadadoTareaJpaService {

	@Autowired
	private ICiudadoTareaJpaRepo ciudadoTareaJpaRepo;
	
	@Override
	public void insertar(CiudadanoTarea ciudadado) {
		// TODO Auto-generated method stub
		this.ciudadoTareaJpaRepo.insertar(ciudadado);
	}

	@Override
	public CiudadanoTarea buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadoTareaJpaRepo.buscar(cedula);
	}

	@Override
	public void actualizar(CiudadanoTarea ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadoTareaJpaRepo.actualizar(ciudadano);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.ciudadoTareaJpaRepo.eliminar(cedula);
	}

}
