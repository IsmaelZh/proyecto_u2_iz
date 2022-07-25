package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEmpleadoJpaRepository;
import com.uce.edu.demo.repository.modelo.onetoone.Empleado;

@Service
public class EmpleadoJpaServiceImpl implements IEmpleadoJpaService {

	@Autowired
	private IEmpleadoJpaRepository empleadoJpaRepository;
	
	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoJpaRepository.insertar(empleado);
	}

}
