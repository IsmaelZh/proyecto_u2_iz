package com.uce.edu.demo.modelo.Cprueba.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("liviano")
public class MatriculaLivianoServiceImpl implements IMatriculaService {

	@Override
	public BigDecimal calcularValor(BigDecimal precio) {
		// TODO Auto-generated method stub
		return precio.multiply(new BigDecimal(14)).divide(new BigDecimal(100));
	}
	
}
