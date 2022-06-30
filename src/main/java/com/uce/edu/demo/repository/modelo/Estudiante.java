package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

		@Id
		@Column (name = "id")
	    private Integer id;
		
		@Column (name = "nombre")
	    private String nombre;
		
		@Column (name = "apellido")
	    private String apellido;
		
		@Column (name = "edad")
		private Integer edad;
		
		@Column (name = "carrera")
		private String carrera;
		
		@Override
		public String toString() {
			return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
					+ ", carrera=" + carrera + "]";
		}

		//Get y Set 
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

		public Integer getEdad() {
			return edad;
		}

		public void setEdad(Integer edad) {
			this.edad = edad;
		}

		public String getCarrera() {
			return carrera;
		}

		public void setCarrera(String carrera) {
			this.carrera = carrera;
		}
		
	
}
