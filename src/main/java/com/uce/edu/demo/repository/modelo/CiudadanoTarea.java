package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ciudadanotarea")
public class CiudadanoTarea {

	@Id
	@Column(name = "ciea_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciea_id_seq")
	@SequenceGenerator(name = "ciea_id_seq", sequenceName = "ciea_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "ciea_nombre")
	private String nombre;

	@Column(name = "ciea_apellido")
	private String apellido;

	@Column(name = "ciea_cedula")
	private String cedula;

	@Column(name = "ciea_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@OneToOne(mappedBy = "ciudadano", cascade = CascadeType.ALL)
	private Pasaporte pasaporte;

	@Override
	public String toString() {
		return "CiudadanoTarea [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaNacimiento=" + fechaNacimiento + ", pasaporte=" + pasaporte + "]";
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

}
