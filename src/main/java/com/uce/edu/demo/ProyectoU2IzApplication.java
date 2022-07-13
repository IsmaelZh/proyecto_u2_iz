package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		LOG.info("Se encontro con NativeQuery: " + this.iPersonaJpaService.buscarPorCedulaNative("0696699696"));
		LOG.info("Se encontro con NamedNativeQuery: " + this.iPersonaJpaService.buscarPorCedulaNamedNative("1796325874"));

	}
}