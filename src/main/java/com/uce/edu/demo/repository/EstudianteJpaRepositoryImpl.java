package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula", Estudiante.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorCarreraTyped(String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.carrera = :datoCarrera", Estudiante.class);
		myTypedQuery.setParameter("datoCarrera", carrera);
		return myTypedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedula");
		myNamedQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myNamedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorEdadNamed(Integer edad) {
		// TODO Auto-generated method stub
		Query myNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad");
		myNamedQuery.setParameter("datoEdad", edad);
		return (List<Estudiante>) myNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorCarreraTypedNamed(String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedNamedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCarrera",
				Estudiante.class);
		myTypedNamedQuery.setParameter("datoCarrera", carrera);
		return myTypedNamedQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoEdadTypedNamed(String apellido, Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedNamedQuery = this.entityManager
				.createNamedQuery("Estudiante.buscarPorApellidoEdad", Estudiante.class);
		myTypedNamedQuery.setParameter("datoApellido", apellido);
		myTypedNamedQuery.setParameter("datoEdad", edad);
		return myTypedNamedQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM estudiante WHERE estu_cedula = :datoCedula ", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorCarreraNative(String carrera) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE estu_carrera = :datoCarrera ORDER BY estu_apellido asc",
				Estudiante.class);
		myQuery.setParameter("datoCarrera", carrera);
		return (List<Estudiante>) myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.BuscarPorCedulaNative",
				Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorEdadNamedNative(Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.BuscarPorEdadNative",
				Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);

		LOG.info("Se inserto con JPA el estudiante: " + estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);

		LOG.info("Se actualizo con JPA el estudiante: " + estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.buscar(id);
		this.entityManager.remove(estudiante);

		LOG.info("Se elimino con JPA el estudiante: " + estudiante);
	}

}
