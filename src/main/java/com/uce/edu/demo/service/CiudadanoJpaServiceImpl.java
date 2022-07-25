package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoJpaRepository;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

@Service
public class CiudadanoJpaServiceImpl implements ICiudadanoJpaService{

	@Autowired
	private ICiudadanoJpaRepository ciudadanoJpaRepository;
	
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoJpaRepository.insertar(ciudadano);
	}

}
