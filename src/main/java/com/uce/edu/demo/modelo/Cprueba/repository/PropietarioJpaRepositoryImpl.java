package com.uce.edu.demo.modelo.Cprueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Cprueba.Propietario;
import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PropietarioJpaRepositoryImpl implements IPropietarioJpaRepository {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Propietario p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
		
		LOG.info("Se inserto con JPA el propietario: " + p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Propietario propietario = this.consultarPorCedula(cedula);
		this.entityManager.remove(propietario);
		
		LOG.info("Se elimino con JPA el propietario: " + propietario);
	}

	@Override
	public Propietario consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		jpqlQuery.getSingleResult();
		return (Propietario)jpqlQuery.getSingleResult();

	}


}
