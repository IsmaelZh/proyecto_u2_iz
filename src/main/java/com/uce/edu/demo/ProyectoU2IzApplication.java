package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoJpaService;
import com.uce.edu.demo.service.IEmpleadoJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Autowired
	private ICiudadanoJpaService ciudadanoJpaService;
	
	@Autowired
	private IEmpleadoJpaService empleadoJpaService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		Ciudadano ciu1= new Ciudadano();
        ciu1.setNombre("Ana");
        ciu1.setApellido("Obredo");

        Empleado empl1 = new Empleado();
        empl1.setCodigoIess("00112");
        empl1.setSalario(new BigDecimal(100));
        empl1.setCiudadano(ciu1);

        ciu1.setEmpleado(empl1);

        this.ciudadanoJpaService.insertar(ciu1);
		
	}
}