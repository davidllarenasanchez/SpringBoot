package com.calculadora.service;

import java.math.BigDecimal;

public interface ICalculadoraService {

     BigDecimal  sumar(final BigDecimal operador1, final BigDecimal operador2);
     BigDecimal  multiplicar(final BigDecimal operador1, final BigDecimal operador2);
     BigDecimal restar( final BigDecimal  operador1, final BigDecimal  operador2);
     BigDecimal dividir( final BigDecimal  operador1, final BigDecimal  operador2);
}
