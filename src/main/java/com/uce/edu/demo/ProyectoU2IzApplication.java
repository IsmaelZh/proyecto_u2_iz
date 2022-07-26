package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.manytomany.Autor;
import com.uce.edu.demo.repository.manytomany.Libro;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Autowired
	private ILibroService iLibroService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Autor autor1 = new Autor();
		autor1.setNombre("Jose Navaz");
		
		Autor autor2 = new Autor();
		autor2.setNombre("Maria Vega");
		
		Set<Autor> autores = new HashSet<>();
		autores.add(autor1);
		autores.add(autor2);
		
		Libro libro = new Libro();
		libro.setTitulo("Quimica");
		libro.setPaginas(250);
		
		libro.setAutores(autores);
		
		this.iLibroService.insertar(libro);
		
		
	}

}
