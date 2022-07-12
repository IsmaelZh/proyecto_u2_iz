package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Persona p = new Persona();
		// p.setId(65);
		p.setNombre("Lucas");
		p.setApellido("Tañeda");
		p.setGenero("M");
		p.setCedula("0696699696");
		// Guardar
		//this.iPersonaJpaService.guardar(p);
		
		//1. TypedQuery
		Persona perTyped = this.iPersonaJpaService.buscarPorCedulaTyped("0696699696");
		LOG.info("Persona Typed: " + perTyped);
		
		//2. NamedQuery
		Persona perNamed = this.iPersonaJpaService.buscarPorCedulaNamed("0696699696");
		LOG.info("Persona Named: " + perNamed);
		
		//3. NamedTypedQuery
		Persona perTypedNamed = this.iPersonaJpaService.buscarPorCedulaTypedNamed("0696699696");
		LOG.info("Persona TypedNamed: " + perTypedNamed);
		
		//4.  Varios NamedQuery
		List<Persona> listaPersona = this.iPersonaJpaService.buscarPorNombreApellido("Heredia", "Matias");
		for(Persona i : listaPersona) {
			LOG.info("Persona " + i);
		}
		
	}
}