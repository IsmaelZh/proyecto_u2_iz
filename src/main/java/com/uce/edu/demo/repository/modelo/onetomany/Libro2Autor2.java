package com.uce.edu.demo.repository.modelo.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro2_autor2")
public class Libro2Autor2 {

	@Id
	@Column(name = "l2a2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "l2a2_id_seq")
	@SequenceGenerator(name = "l2a2_id_seq", sequenceName = "l2a2_id_seq", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "l2a2_id_autor")
	private Autor2 autor;
	
	@ManyToOne
	@JoinColumn(name = "l2a2_id_libro")
	private Libro2 libro;

	// Set y Get
	public Autor2 getAutor() {
		return autor;
	}

	public void setAutor(Autor2 autor) {
		this.autor = autor;
	}

	public Libro2 getLibro() {
		return libro;
	}

	public void setLibro(Libro2 libro) {
		this.libro = libro;
	}
	
}
