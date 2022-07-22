package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CiudadanoTarea;

@Repository
@Transactional
public class CiudadanoTareaJpaRepoImpl implements ICiudadoTareaJpaRepo {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CiudadanoTarea ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
		
		LOG.info("Se inserto con el ciudadano: " + ciudadano);
	}

	@Override
	public CiudadanoTarea buscar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<CiudadanoTarea> myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM CiudadanoTarea c WHERE c.cedula = :datoCedula", CiudadanoTarea.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public void actualizar(CiudadanoTarea ciudadano) {
		// TODO Auto-generated method stub
		
		this.entityManager.merge(ciudadano);
		
		LOG.info("Se actualizo el ciudadano: " + ciudadano);
		
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		
		CiudadanoTarea ciudadano = this.buscar(cedula);
		this.entityManager.remove(ciudadano);
		
		LOG.info("Se elimino el ciudadano: " + ciudadano );
		
	}

	
	
}
