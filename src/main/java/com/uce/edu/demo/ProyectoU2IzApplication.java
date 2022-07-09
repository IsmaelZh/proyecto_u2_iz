package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
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
		
		//LOG.info("Dato con JPA: " + this.iPersonaJpaService.buscar(1));

		Persona p = new Persona();
		//p.setId(65);
		p.setNombre("Matias");
		p.setApellido("Heredia");
		p.setGenero("M");
		p.setCedula("0111569745");
		//Guardar
		//this.iPersonaJpaService.guardar(p);
		
		Persona p1 = new Persona();
		p1.setId(9);
		p1.setNombre("Mateo");
		p1.setApellido("Solis");
		//Actualizar
		//this.iPersonaJpaService.actualizar(p1);
		
		//Eliminar
		//this.iPersonaJpaService.eliminar(12);
		
		//LOG.info("Se encontro la persona: " + this.iPersonaJpaService.buscarPorCedula("1796325896"));
		
//	    List<Persona> listaPersona = this.iPersonaJpaService.buscarPorApellido("Paredes");
//	    for (Persona i : listaPersona) {
//	    	LOG.info("Persona: " + i);
//	    }
		
//	    List<Persona> listaPersona2 = this.iPersonaJpaService.buscarPorNombre("Ana");
//	    for (Persona i : listaPersona2) {
//	    	LOG.info("Persona buscada por nombre: " + i);
//	    }
	    
//	    List<Persona> listaPersona3 = this.iPersonaJpaService.buscarPorGenero("M");
//	    for (Persona i : listaPersona3) {
//	    	LOG.info("Persona buscada por genero: " + i);
//	    }
		
		//Actualizar con JPQL
	    int resultado = this.iPersonaJpaService.actualizarPorApellido("F", "Paredes");
	    LOG.info("La cantidad de registros actualizados son: " + resultado);
	    
	    //Eliminar con JPQL
	    int resultado2 = this.iPersonaJpaService.eliminarPorGenero("F");
	    LOG.info("La cantidad de eliminados son: " + resultado2);
	    
	    
	}
}