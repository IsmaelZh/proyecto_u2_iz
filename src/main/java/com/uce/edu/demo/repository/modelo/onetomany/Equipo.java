package com.uce.edu.demo.repository.modelo.onetomany;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {

	@Id
	@Column(name = "equi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equi_id_seq")
	@SequenceGenerator(name = "equi_id_seq", sequenceName = "equi_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "equi_nombre")
	private String nombre;
	
	@Column(name = "equi_fecha_creacion")
	private LocalDateTime fechacreacion;
	
	@Column(name = "equi_localidad")
	private String localidad;
	
	@OneToMany(mappedBy = "equipo")
	private List<Jugador> jugadores;

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", fechacreacion=" + fechacreacion + ", localidad="
				+ localidad + "]";
	}

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

	public LocalDateTime getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDateTime fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	
	
	
}
