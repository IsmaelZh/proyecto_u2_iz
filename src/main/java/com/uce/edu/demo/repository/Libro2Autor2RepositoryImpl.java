package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Libro2Autor2;

@Repository
@Transactional
public class Libro2Autor2RepositoryImpl implements ILibro2Autor2Rrepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro2Autor2 libroAutor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libroAutor);

	}
}