package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante e = new Estudiante();
		// e.setId(14);
		e.setCedula("1422663228");
		e.setNombre("Paul");
		e.setApellido("Perez");
		e.setEdad(20);
		e.setCarrera("Ing. Sistemas");
		// Insertar
		//this.estudianteJpaService.insertar(e);

		System.out.println("----------------------------------------------------------- Ejemplos TypedQuery -----------------------------------------------");
		// 1.
		LOG.info("Se a encontrado con TypedQuery el estudiante: "+ this.estudianteJpaService.buscarPorCedulaTyped("2555669899"));
		// 2.
		List<Estudiante> listaEstudianteT = this.estudianteJpaService.buscarPorCarreraTyped("Veterinaria");
		for (Estudiante i : listaEstudianteT) {
			LOG.info("Estudiantes con TypedQuery " + i);
		}

		System.out.println("----------------------------------------------------------- Ejemplos NamedQuery -----------------------------------------------");
		// 1.
		LOG.info("Se a encontrado con NamedQuery el estudiante: "+ this.estudianteJpaService.buscarPorCedulaNamed("1422663228"));
		// 2.
		List<Estudiante> listaEstudianteN = this.estudianteJpaService.buscarPorEdadNamed(18);
		for (Estudiante i : listaEstudianteN) {
			LOG.info("Estudiantes con NamedQuery " + i);
		}

		System.out.println("----------------------------------------------------------- Ejemplos TypedNamedQuery -----------------------------------------------");
		// 1.
		List<Estudiante> listaEstudianteTN = this.estudianteJpaService.buscarPorCarreraTypedNamed("Veterinaria");
		for (Estudiante i : listaEstudianteTN) {
			LOG.info("Estudiantes con TypedNamedQuery " + i);
		}
		// 2.
		List<Estudiante> listaEstudianteTN2 = this.estudianteJpaService.buscarPorApellidoEdadTypedNamed("Perez", 20);
		for (Estudiante i : listaEstudianteTN2) {
			LOG.info("Estudiantes con TypedNamedQuery " + i);

		}
	}
}