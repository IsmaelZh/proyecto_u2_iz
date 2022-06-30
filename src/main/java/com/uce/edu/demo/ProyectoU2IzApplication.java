package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

//	@Autowired
//	private IPersonaJpaService iPersonaJpaService;
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante e = new Estudiante();
		e.setId(14);
		e.setNombre("Marcelo");
		e.setApellido("Salazar");
		e.setEdad(26);
		e.setCarrera("Psicologia");
	    //Insertar
		this.estudianteJpaService.insertar(e);
		
		//Buscar
		LOG.info("Se encontro con JPA el estudiante: " + this.estudianteJpaService.buscar(20));
		
		e.setCarrera("Artes visuales");
		//Actualizar
		this.estudianteJpaService.actualizar(e);
		
		//Eliminar
		this.estudianteJpaService.eliminar(15);
	}
}
