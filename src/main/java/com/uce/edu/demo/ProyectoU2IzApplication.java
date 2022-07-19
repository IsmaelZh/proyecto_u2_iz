package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		List<EstudianteSencillo> listaEstudianteSencillo =  this.estudianteJpaService.buscarPorCarreaSencillo("Veterinaria");
		for(EstudianteSencillo i : listaEstudianteSencillo) {
			LOG.info("Estudiante Sencillo: " + i);
		}
		
		List<EstudianteContadorCarrera> listaEstudianteCarrera =  this.estudianteJpaService.consultarCantidadCarreraPorEdad(18);
		for(EstudianteContadorCarrera i : listaEstudianteCarrera) {
			LOG.info("Carrera: " + i);
		}
	}
}