package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.to.EstudianteTo;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService {

	@Autowired
	private IEstudianteJdbcRepository estudianteJdbcRepository;
	
	@Override
	public EstudianteTo buscar(int id) {
		// TODO Auto-generated method stub
		return this.estudianteJdbcRepository.buscar(id);
	}

	@Override
	public void insertar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.eliminar(id);
	}

}
