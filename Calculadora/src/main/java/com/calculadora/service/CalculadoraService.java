package com.calculadora.service;


import org.springframework.stereotype.Service;

@Service
public class CalculadoraService implements ICalculadoraService {

    @Override
    public Double suma(final Double operador1, final Double operador2) {
        return (operador1 + operador2);
    }

    @Override
    public Double multiplicar( final Double operador1, final Double operador2) {
        return (operador1 * operador2);
    }
}
