package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository estudianteJpaRepository;

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscar(id);
	}

	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public List<Estudiante> buscarPorCarreraTyped(String carrera) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCarreraTyped(carrera);
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public List<Estudiante> buscarPorEdadNamed(Integer edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorEdadNamed(edad);
	}

	@Override
	public List<Estudiante> buscarPorCarreraTypedNamed(String carrera) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCarreraTypedNamed(carrera);
	}

	@Override
	public List<Estudiante> buscarPorApellidoEdadTypedNamed(String apellido, Integer edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorApellidoEdadTypedNamed(apellido, edad);
	}
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.eliminar(id);
	}



}
