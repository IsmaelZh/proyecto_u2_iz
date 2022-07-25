package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Equipo;
import com.uce.edu.demo.service.IEquipoService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Autowired
	private IEquipoService equipoService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// INSERTAR
		Equipo equipo = new Equipo();
		equipo.setNombre("Delfin");
		equipo.setLocalidad("Manabi");
		equipo.setFechacreacion(LocalDateTime.of(1989,3, 1, 14, 20));
		
		this.equipoService.insertar(equipo);

		// BUSCAR
		LOG.info("Se encontro el equipo: " + this.equipoService.buscar("Liga"));

		// ACTUALIZAR

		Equipo equipo1 = new Equipo();
		equipo1.setId(4);
		equipo1.setNombre("Barcelona");
		equipo1.setLocalidad("España");
		equipo1.setFechacreacion(LocalDateTime.of(1899,11, 29, 20, 15));

		this.equipoService.actualizar(equipo1);
		
		// ELIMINAR
		this.equipoService.eliminar("Elemec");
	}

}
