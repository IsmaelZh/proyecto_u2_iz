package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//LOG.info("Dato con JPA: " + this.iPersonaJpaService.buscar(1));

		Persona p = new Persona();
		//p.setId(65);
		p.setNombre("Pedro");
		p.setApellido("Paredes");
		//Guardar
		this.iPersonaJpaService.guardar(p);
		
		Persona p1 = new Persona();
		p1.setId(9);
		p1.setNombre("Mateo");
		p1.setApellido("Solis");
		//Actualizar
		//this.iPersonaJpaService.actualizar(p1);
		
		//Eliminar
		//this.iPersonaJpaService.eliminar(3);
	}
}