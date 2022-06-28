package com.uce.edu.demo.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Estudiante;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository{
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Estudiante buscar(int cedula) {
		// TODO Auto-generated method stub
		
		return this.jdbcTemplate.queryForObject("select * from estudiante where id = ?", new Object[] { cedula },
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (id, nombre, apellido, edad, carrera) values (?, ?, ?, ?, ?)",
				new Object[] { estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getId(), estudiante.getCarrera() });
		
		LOG.info("Se inserto el estudiante: " + estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set nombre = ?, apellido = ?, edad = ?, carrera = ? where id = ?",
				new Object[] { estudiante.getNombre(), estudiante.getApellido(), estudiante.getEdad(), estudiante.getCarrera(), estudiante.getId() });
		
		LOG.info("Se actualizo el estudiante: " + estudiante);
	}

	@Override
	public void eliminar(int cedula) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from estudiante where id = ? ", new Object[] { cedula });
		
		LOG.info("Se elimino el estudiante con id " + cedula);
	}

	
	
}
