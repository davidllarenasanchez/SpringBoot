package com.calculadora.service;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class CalculadoraService implements ICalculadoraService {

    @Override
    public BigDecimal sumar(final BigDecimal operador1, final BigDecimal  operador2) {

        BigDecimal resultado = new BigDecimal(0.0);
        resultado = operador1.add(operador2, MathContext.DECIMAL64);
        return resultado;
    }

    @Override
    public BigDecimal multiplicar( final BigDecimal  operador1, final BigDecimal  operador2)  {

        BigDecimal resultado =  new BigDecimal(0);
        resultado = operador1.multiply(operador2, MathContext.DECIMAL64);
        return resultado;
    }

}
