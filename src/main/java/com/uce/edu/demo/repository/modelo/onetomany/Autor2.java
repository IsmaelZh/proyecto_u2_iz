package com.uce.edu.demo.repository.modelo.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor2")
public class Autor2 {

	@Id
	@Column(name = "aut2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aut2_id_seq")
	@SequenceGenerator(name = "aut2_id_seq", sequenceName = "aut2_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "aut2_nombre")
	private String nombre;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Libro2Autor2> libros;
	
	//Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro2Autor2> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro2Autor2> libros) {
		this.libros = libros;
	}
	
	
}
