package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.onetomany.Equipo;

@Repository
@Transactional
public class EquipoRepositoryImpl implements IEquipoRepository{

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Equipo equipo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(equipo);
		
		LOG.info("Se inserto el equipo: " + equipo);
		
	}

	@Override
	public Equipo buscar(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT e FROM Equipo e WHERE e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		jpqlQuery.getSingleResult();
		return (Equipo) jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Equipo equipo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(equipo);
		
		LOG.info("Se actualizo el equipo: " + equipo);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		Equipo equipo = this.buscar(nombre);
		this.entityManager.remove(equipo);
		
		LOG.info("Se elimino el equipo: " + equipo);
	}

	
	
}
