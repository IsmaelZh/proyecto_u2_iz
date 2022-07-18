package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
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

		List<Estudiante> listaEstudiante = this.estudianteJpaService.buscarPorCarreraEdadCriteriaAPI("Veterinaria", 22);
		for (Estudiante i : listaEstudiante) {
			LOG.info("Estudiante con Criteria API " + i);
		}

		List<Estudiante> listaEstudianteD = this.estudianteJpaService.buscarDinamicamenteCriteriaAPI("Ariel", "Andrade", "Ing. Civil", 17);
		for (Estudiante i : listaEstudianteD) {
			LOG.info("Estudiante con Criteria API " + i);
		}

	}
}