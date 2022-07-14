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
		LOG.info("\n---------------------------------------------------------------- Ejemplos NativeQuery -----------------------------------------------");
		// 1.
		LOG.info("Se encontro con NativeQuery: " + this.estudianteJpaService.buscarPorCedulaNative("1798985656"));
		// 2.
		List<Estudiante> listaEstudianteN = this.estudianteJpaService.buscarPorCarreraNative("Ing. Sistemas");
		for (Estudiante i : listaEstudianteN) {
			LOG.info("Estudiante con NativeQuery " + i);
		}
		
		LOG.info("\n---------------------------------------------------------------- Ejemplos NamedNativeQuery -----------------------------------------------");
		// 1.
		LOG.info("Se encontro con NamedNativeQuery: " + this.estudianteJpaService.buscarPorCedulaNamedNative("2555669899"));
		// 2.
		int edad = 18;
		List<Estudiante> listaEstudianteNN = this.estudianteJpaService.buscarPorEdadNamedNative(edad);
		for (Estudiante i : listaEstudianteNN) {
			LOG.info("Estudiante mayor a " + edad + " NamedNativeQuery: " + i);
		}

	}
}