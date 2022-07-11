package com.uce.edu.demo.modelo.Cprueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Cprueba.Vehiculo;

@Repository
@Transactional
public class VehiculoJpaRepositoryImpl implements IVehiculoJpaRepository {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.entityManager.persist(v);
		
		LOG.info("Se inserto con JPA el vehiculo: " + v);

	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Vehiculo p WHERE p.placa = :datoPlaca");
		jpqlQuery.setParameter("datoPlaca", placa);
		jpqlQuery.getSingleResult();
		return (Vehiculo)jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub

		Query myQuery = this.entityManager.createQuery("UPDATE Vehiculo v SET v.marca = :datoMarca, v.modelo = :datoModelo, v.tipo = :datoTipo, v.precio = :datoPrecio WHERE v.placa = :datoPlaca");
        myQuery.setParameter("datoPlaca", v.getPlaca());
        myQuery.setParameter("datoMarca", v.getMarca());
        myQuery.setParameter("datoModelo", v.getModelo());
        myQuery.setParameter("datoTipo", v.getTipo());
        myQuery.setParameter("datoPrecio", v.getPrecio());
		
		LOG.info("Se actualizo con JPA el vehiculo: " + v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.buscarPorPlaca(placa);
		this.entityManager.remove(vehiculo);
		
		LOG.info("Se elimino con JPA el vehiculo: " + vehiculo);
	}

}
