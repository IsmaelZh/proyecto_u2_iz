package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	//private static final Logger LOG = (org.apache.logging.log4j.Logger) LoggerFactory.getLogger(ProyectoU2IzApplication.class);
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("Hola Mundo");
//		
//		LOG.fatal("Fatal");
//		LOG.warn("Warn");
//		LOG.error("Error, el estudiante no existe");
//		LOG.info("Hola mundo slf4j");
//		LOG.debug("Debug");
		
		Persona persona = new Persona();
		persona.setId(9);
		persona.setNombre("Mateo");
		persona.setApellido("Paez");
		
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		
		Persona per1 = new Persona();
		per1.setId(9);
		per1.setNombre("Mateo");
		per1.setApellido("Velez");
		
		//Actualizar
		//this.iPersonaJdbcService.actualizar(per1);
		
		//Eliminar 
		//this.iPersonaJdbcService.eliminar(3);
		
		//Buscar
		LOG.info(this.iPersonaJdbcService.buscar(1));
		
		
	}
}