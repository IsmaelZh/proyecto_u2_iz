package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Autor2;

@Repository
@Transactional
public class Autor2RepositoryImpl implements IAutor2Repository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Autor2 autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
		
		
	}

}
