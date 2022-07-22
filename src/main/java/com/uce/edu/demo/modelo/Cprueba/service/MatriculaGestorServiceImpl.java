package com.uce.edu.demo.modelo.Cprueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Cprueba.Matricula;
import com.uce.edu.demo.modelo.Cprueba.Propietario;
import com.uce.edu.demo.modelo.Cprueba.Vehiculo;
import com.uce.edu.demo.modelo.Cprueba.repository.IMatriculaRepository;
import com.uce.edu.demo.modelo.Cprueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.modelo.Cprueba.repository.IVehiculoJpaRepository;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {
	
	@Autowired
	private IPropietarioJpaRepository iPropietarioRepository;
	
	@Autowired
	private IVehiculoJpaRepository iVehiculoRepository;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;
	
	@Autowired
	public IMatriculaRepository iMatriculaRepository;
	
	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario propietario = this.iPropietarioRepository.consultarPorCedula(cedula);
		Vehiculo vehiculo = this.iVehiculoRepository.buscarPorPlaca(placa);
		BigDecimal valorMatricula;
		
		if(vehiculo.getTipo().equals("Liviano")) {
			
			valorMatricula = this.matriculaServiceLiviano.calcularValor(vehiculo.getPrecio());
			
		}else {
			
			valorMatricula = this.matriculaServicePesado.calcularValor(vehiculo.getPrecio());
		}
		
		if(valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal descuento = valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula = valorMatricula.subtract(descuento);
		}
		
		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(valorMatricula);
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);
		
		this.iMatriculaRepository.crear(matricula);
		
	}
	
}
