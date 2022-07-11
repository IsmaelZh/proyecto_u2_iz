package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Cprueba.Propietario;
import com.uce.edu.demo.modelo.Cprueba.Vehiculo;
import com.uce.edu.demo.modelo.Cprueba.service.IPropietarioJpaService;
import com.uce.edu.demo.modelo.Cprueba.service.IVehiculoJpaService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IPropietarioJpaService iPropietarioJpaService;
	
	@Autowired
	private IVehiculoJpaService iVehiculoJpaService;
	

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//--------------------------------------------- Propietario -------------------------------------
		
		//INSERTAR
		Propietario p = new Propietario();
		//p.setId(20);
		p.setNombre("Cristian");
		p.setApellido("Fueltala");
		p.setCedula("1789653269");
		
		this.iPropietarioJpaService.crear(p);
		
		//BUSCAR
	    LOG.info("Se encontro con JPA el propietario:" + this.iPropietarioJpaService.buscar("0305988895"));
		
		//ELIMINAR
		this.iPropietarioJpaService.eliminar("0259865428");
		
		//-------------------------------------------- Vehiculo ---------------------------------------------
		
		//INSERTAR
		Vehiculo v = new Vehiculo();
		//v.setId(30);
		v.setMarca("Volkswagen");
		v.setModelo("pichirilo");
		v.setPlaca("UYG-488");
		v.setPrecio(new BigDecimal(18500));
		v.setTipo("Liviano");
		
		this.iVehiculoJpaService.insertar(v);
		
		//BUSCAR
		LOG.info("Se encontro con JPA el vehiculo:" + this.iVehiculoJpaService.buscar("UQW-458"));
		
		//ACTUALIZAR
		v.setPlaca("QLU-554");
		
		this.iVehiculoJpaService.actualizar(v);
		
		//ELIMINAR
		this.iVehiculoJpaService.eliminar("951OJ");
			    
	}
}