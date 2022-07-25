package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IJugadorRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Jugador;

@Service
public class JuagdorServiceImpl implements IJugadorService {

	@Autowired
	private IJugadorRepository iJugadorRepository;
	
	@Override
	public void insertar(Jugador jugador) {
		// TODO Auto-generated method stub
		this.iJugadorRepository.insertar(jugador);
	}

	@Override
	public Jugador buscar(String nombre) {
		// TODO Auto-generated method stub
		return this.iJugadorRepository.buscar(nombre);
	}

	@Override
	public void actualizar(Jugador jugador) {
		// TODO Auto-generated method stub
		this.iJugadorRepository.actualizar(jugador);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.iJugadorRepository.eliminar(nombre);
	}

}
