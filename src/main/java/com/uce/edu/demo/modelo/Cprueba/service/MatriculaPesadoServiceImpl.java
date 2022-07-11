package com.uce.edu.demo.modelo.Cprueba.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("pesado")
public class MatriculaPesadoServiceImpl implements IMatriculaService {

	@Override
	public BigDecimal calcularValor(BigDecimal precio) {
		// TODO Auto-generated method stub
		return precio.multiply(new BigDecimal(12)).divide(new BigDecimal(100));
	}

}
