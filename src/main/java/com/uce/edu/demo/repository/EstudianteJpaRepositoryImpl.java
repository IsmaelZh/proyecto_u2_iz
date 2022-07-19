package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;

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
	public List<Estudiante> buscarPorCarreraEdadCriteriaAPI(String carrera, Integer edad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);

		Root<Estudiante> estudianteFrom = myQuery.from(Estudiante.class);

		Predicate predicadoCarrera = myBuilder.equal(estudianteFrom.get("carrera"), carrera);
		Predicate predicadoEdad = myBuilder.equal(estudianteFrom.get("edad"), edad);

		Predicate myPredicadoFinal = myBuilder.and(predicadoCarrera, predicadoEdad);

		myQuery.select(estudianteFrom).where(myPredicadoFinal);

		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getResultList();
	}

	@Override
	public List<Estudiante> buscarDinamicamenteCriteriaAPI(String nombre, String apellido, String carrera,
			Integer edad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);

		Root<Estudiante> estudianteFrom = myQuery.from(Estudiante.class);

		Predicate predicadoNombre = myBuilder.equal(estudianteFrom.get("nombre"), nombre);
		Predicate predicadoApellido = myBuilder.equal(estudianteFrom.get("apellido"), apellido);
		Predicate predicadoCarrera = myBuilder.equal(estudianteFrom.get("carrera"), carrera);
		Predicate predicadoEdad = myBuilder.equal(estudianteFrom.get("edad"), edad);

		Predicate predicadoFinal = null;

		if (edad < 18) {

			predicadoFinal = myBuilder.or(predicadoNombre, predicadoApellido);
			predicadoFinal = myBuilder.and(predicadoFinal, predicadoCarrera);

		} else {

			predicadoFinal = myBuilder.and(predicadoCarrera, predicadoEdad);

		}

		myQuery.select(estudianteFrom).where(predicadoFinal);

		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getResultList();

	}

	@Override
	public List<EstudianteSencillo> buscarPorCarreaSencillo(String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteSencillo(e.carrera, e.apellido, e.cedula) FROM Estudiante e WHERE e.carrera = :datoCarrera",
				EstudianteSencillo.class);
		myQuery.setParameter("datoCarrera", carrera);

		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteContadorCarrera> consultarCantidadCarreraPorEdad(Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteContadorCarrera> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteContadorCarrera(e.carrera, COUNT(e.carrera)) FROM Estudiante e WHERE e.edad > :datoEdad GROUP BY e.carrera",
				EstudianteContadorCarrera.class);
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
