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
import com.uce.edu.demo.modelo.Cprueba.service.IMatriculaGestorService;
import com.uce.edu.demo.modelo.Cprueba.service.IPropietarioJpaService;
import com.uce.edu.demo.modelo.Cprueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IPropietarioJpaService iPropietarioJpaService;
	
	@Autowired
	private IVehiculoJpaService iVehiculoJpaService;
	
	@Autowired
	private IMatriculaGestorService iMatriculaGestorService;

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
		p.setNombre("Tomas");
		p.setApellido("Ojeda");
		p.setCedula("2596665536");
		
		this.iPropietarioJpaService.crear(p);
		
		//BUSCAR
	    //LOG.info("Se encontro con JPA el propietario:" + this.iPropietarioJpaService.buscar("0305988895"));
		
		//ELIMINAR
		//this.iPropietarioJpaService.eliminar("0259865428");
		
		//-------------------------------------------- Vehiculo ---------------------------------------------
		
		//INSERTAR
		Vehiculo v = new Vehiculo();
		//v.setId(30);
		v.setMarca("Volkswagen");
		v.setModelo("Fox");
		v.setPlaca("PQL-222");
		v.setPrecio(new BigDecimal(9300));
		v.setTipo("Liviano");
		
		this.iVehiculoJpaService.insertar(v);
		
		//BUSCAR
		//LOG.info("Se encontro con JPA el vehiculo:" + this.iVehiculoJpaService.buscar("UQW-458"));
		
		//ACTUALIZAR
		Vehiculo v1 = new Vehiculo();
		v1.setId(17);
		v1.setMarca(v.getMarca());
		v1.setModelo(v.getModelo());
		v1.setPlaca("PJK-507");
		v1.setPrecio(v.getPrecio());
		v1.setTipo(v.getTipo());
		
		this.iVehiculoJpaService.actualizar(v1);
		
		//ELIMINAR
		//this.iVehiculoJpaService.eliminar("951OJ");
		
		//------------------------------------------ Matricula ---------------------------------------------
		
		this.iMatriculaGestorService.generar(p.getCedula(), v1.getPlaca());
			    
	}
}
