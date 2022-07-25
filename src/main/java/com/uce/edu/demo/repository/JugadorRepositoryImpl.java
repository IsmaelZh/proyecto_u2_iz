package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Jugador;

@Repository
@Transactional
public class JugadorRepositoryImpl implements IJugadorRepository {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Jugador jugador) {
		// TODO Auto-generated method stub
		this.entityManager.persist(jugador);

		LOG.info("Se inserto el jugador: " + jugador);
	}

	@Override
	public Jugador buscar(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT j FROM Juagdor j WHERE e.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		jpqlQuery.getSingleResult();
		return (Jugador) jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Jugador jugador) {
		// TODO Auto-generated method stub
		this.entityManager.merge(jugador);

		LOG.info("Se actualizo el equipo: " + jugador);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		Jugador jugador = this.buscar(nombre);
		this.entityManager.remove(jugador);
		
		LOG.info("Se elimino el equipo: " + jugador);
	}

}
