package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Persona p = new Persona();
		// p.setId(65);
		p.setNombre("Luis");
		p.setApellido("Miranda");
		p.setGenero("M");
		p.setCedula("0262626262");
		// Guardar
		//this.iPersonaJpaService.guardar(p);
		
		List<PersonaSencilla> listaPersonaSencilla =  this.iPersonaJpaService.buscarPorApellidoSencillo("Arco");
		for(PersonaSencilla i : listaPersonaSencilla) {
			LOG.info("Persona Sencilla " + i);
		}
		
		List<PersonaContadorGenero> listaPersonaGenero =  this.iPersonaJpaService.consultarCantidadPorGenero();
		for(PersonaContadorGenero i : listaPersonaGenero) {
			LOG.info("Persona Contador Genero " + i);
		}
	}
}