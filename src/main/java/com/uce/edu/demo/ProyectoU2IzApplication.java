package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		// 1 Autor con 2 libros
//		Autor2 autor = new Autor2();
//		autor.setNombre("Marco Herrera");
//
//		Libro2 libro = new Libro2();
//		libro.setTitulo("Sendo en un bar");
//		libro.setCantidadpaginas(268);
//		
//		Libro2Autor2 libroAutor = new Libro2Autor2();
//		libroAutor.setAutor(autor);
//		libroAutor.setLibro(libro);
//
//		Libro2 libro2 = new Libro2();
//		libro2.setTitulo("Longebo");
//		libro2.setCantidadpaginas(378);
//		
//		Libro2Autor2 libroAutor2 = new Libro2Autor2();
//		libroAutor2.setAutor(autor);
//		libroAutor2.setLibro(libro2);
//
//		List<Libro2Autor2> listaLibros = new ArrayList<>();
//
//		listaLibros.add(libroAutor);
//		listaLibros.add(libroAutor2);
//
//		autor.setLibros(listaLibros);
//
//		this.iLibro2Service.insertar(libro);
//		this.iLibro2Service.insertar(libro2);
//		this.iAutor2Service.insertar(autor);
//
//		// 2 autores 1 libro
//
//		Libro2 libro3 = new Libro2();
//		libro3.setTitulo("Militar");
//		libro3.setCantidadpaginas(965);
//
//		Autor2 a1 = new Autor2();
//		a1.setNombre("Juakin Softonic");
//		
//		Libro2Autor2 libro2Autor22 = new Libro2Autor2();
//		libro2Autor22.setAutor(a1);
//		libro2Autor22.setLibro(libro3);
//
//		Autor2 a2 = new Autor2();
//		a2.setNombre("Ramon Valdez");
//		
//		Libro2Autor2 libro2Autor23 = new Libro2Autor2();
//		libro2Autor23.setAutor(a2);
//		libro2Autor23.setLibro(libro3);
//
//		List<Libro2Autor2> listaAutor = new ArrayList<>();
//		listaAutor.add(libro2Autor22);
//		listaAutor.add(libro2Autor23);
//
//		libro3.setAutores(listaAutor);
//
//		this.iAutor2Service.insertar(a2);
//		this.iAutor2Service.insertar(a1);
//		this.iLibro2Service.insertar(libro3);

		Factura fact = this.facturaService.consultar(1);
		
		LOG.info("Numero de factura: " + fact.getNumero());
		LOG.info("Fecha de factura: " + fact.getFecha());
		LOG.info("Cliente: " + fact.getCliente().getNumeroTarjeta());
		
		List<DetalleFactura> detalles = fact.getDetalles();
		for (DetalleFactura i : detalles)
		LOG.info("Detalle: " + i);
	}

}
