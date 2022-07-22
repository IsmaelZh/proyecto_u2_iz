package com.uce.edu.demo.modelo.Cprueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Cprueba.Matricula;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Matricula m) {
		// TODO Auto-generated method stub
		this.entityManager.persist(m);
		
		LOG.info("Se inserto con JPA la matricula: " + m);
		
		
	}

}
