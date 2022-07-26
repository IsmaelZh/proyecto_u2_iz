package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Autor2;
import com.uce.edu.demo.repository.modelo.onetomany.Libro2;
import com.uce.edu.demo.repository.modelo.onetomany.Libro2Autor2;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Service;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private ILibro2Service iLibro2Service;

	@Autowired
	private IAutor2Service iAutor2Service;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1 Autor con 2 libros
		Autor2 autor = new Autor2();
		autor.setNombre("Marco Herrera");

		Libro2Autor2 libroAutor = new Libro2Autor2();
		libroAutor.setAutor(autor);

		Libro2 libro = new Libro2();
		libro.setTitulo("Sendo en un bar");
		libro.setCantidadpaginas(268);
		libroAutor.setLibro(libro);

		Libro2 libro2 = new Libro2();
		libro2.setTitulo("Longebo");
		libro2.setCantidadpaginas(378);;
		Libro2Autor2 libroAutor2 = new Libro2Autor2();
		libroAutor2.setAutor(autor);
		libroAutor2.setLibro(libro2);

		List<Libro2Autor2> listaLibros = new ArrayList<>();

		listaLibros.add(libroAutor);
		listaLibros.add(libroAutor2);

		autor.setLibros(listaLibros);

		this.iLibro2Service.insertar(libro);
		this.iLibro2Service.insertar(libro2);
		this.iAutor2Service.insertar(autor);

		// 2 autores 1 libro

		Libro2 libro3 = new Libro2();
		libro3.setTitulo("Militar");
		libro3.setCantidadpaginas(965);

		Libro2Autor2 libro2Autor22 = new Libro2Autor2();
		Autor2 a1 = new Autor2();
		a1.setNombre("Juakin Softonic");

		libro2Autor22.setAutor(a1);
		libro2Autor22.setLibro(libro3);

		Libro2Autor2 libro2Autor23 = new Libro2Autor2();
		Autor2 a2 = new Autor2();
		a2.setNombre("Ramon Valdez");
		libro2Autor23.setAutor(a2);
		libro2Autor23.setLibro(libro3);

		List<Libro2Autor2> listaAutor = new ArrayList<>();
		listaAutor.add(libro2Autor22);
		listaAutor.add(libro2Autor23);

		libro3.setAutores(listaAutor);

		this.iAutor2Service.insertar(a2);
		this.iAutor2Service.insertar(a1);
		this.iLibro2Service.insertar(libro3);

	}

}
