package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibro2Autor2Rrepository;
import com.uce.edu.demo.repository.modelo.onetomany.Libro2Autor2;

@Service
public class Libro2Autor2ServiceImpl implements ILibro2Autor2Service{

	@Autowired
	private ILibro2Autor2Rrepository autor2Rrepository;
	
	@Override
	public void insertar(Libro2Autor2 libroAutor) {
		// TODO Auto-generated method stub
		this.autor2Rrepository.insertar(libroAutor);
	}

}
