package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2IzApplication.class, args);
	}

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IHabitacionService habitacionService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Hotel hotel = new Hotel();
		hotel.setNombre("Transilvania");
		hotel.setDireccion("Rumania");

		// this.hotelService.insertar(hotel);

		Habitacion habi = new Habitacion();
		habi.setNumero("A198");
		habi.setPiso("10");
		habi.setTipo("Familiar");

		// this.habitacionService.insertar(habi);

		Hotel hotel1 = new Hotel();
		hotel1.setId(1);

		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumero("A1");
		habitacion1.setPiso("2");
		habitacion1.setTipo("matrimonial");
		habitacion1.setHotel(hotel1);

		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumero("A2");
		habitacion2.setTipo("solitario");
		habitacion2.setPiso("2");
		habitacion2.setHotel(hotel1);

		this.habitacionService.insertar(habitacion1);

	}

}
