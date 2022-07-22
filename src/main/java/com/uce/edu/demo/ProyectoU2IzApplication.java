package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.CiudadanoTarea;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadadoTareaJpaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Autowired
	private ICiudadadoTareaJpaService ciudadadoTareaJpaService;

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//INSERTAR
		CiudadanoTarea ciudadano = new CiudadanoTarea();
        ciudadano.setNombre("Pedro");
        ciudadano.setApellido("Pezantes");
        ciudadano.setCedula("0302666966");
        ciudadano.setFechaNacimiento(LocalDateTime.of(1999, 1, 6, 14, 45));
        
        Pasaporte pasaporte = new Pasaporte();
        pasaporte.setNumero("235");
        pasaporte.setFechaEmision(LocalDateTime.of(2010, 5, 6, 8, 9));
        pasaporte.setFechaCaducidad(LocalDateTime.of(2025, 2, 9, 2, 1));
 
        ciudadano.setPasaporte(pasaporte);

        pasaporte.setCiudadano(ciudadano);
        
        this.ciudadadoTareaJpaService.insertar(ciudadano);
        
        //BUSCAR
        CiudadanoTarea ciud = this.ciudadadoTareaJpaService.buscar("1725363969");
        LOG.info("Se encontro el estudiante: " + ciud);
        
        //ACTUALIZAR
        CiudadanoTarea ciudadano1 = new CiudadanoTarea();
        ciudadano1.setId(2);
        ciudadano1.setApellido("Velez");
        
        this.ciudadadoTareaJpaService.actualizar(ciudadano1);
		
        //ELIMINAR
        this.ciudadadoTareaJpaService.eliminar("1725363969");
	}

}
