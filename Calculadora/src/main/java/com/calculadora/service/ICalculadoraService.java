package com.calculadora.service;

import com.calculadora.entity.ElementsOperacion;

import java.math.BigDecimal;

public interface ICalculadoraService {

     final static String OPERACION_SUMAR = "+";
     final static String OPERACION_RESTAR = "-";
     final static String OPERACION_MULTIPLICAR = "*";
     final static String OPERACION_DIVIDIR = "/";

     BigDecimal  sumar(final BigDecimal operador1, final BigDecimal operador2);
     BigDecimal  multiplicar(final BigDecimal operador1, final BigDecimal operador2);
     BigDecimal restar( final BigDecimal  operador1, final BigDecimal  operador2);
     BigDecimal dividir( final BigDecimal  operador1, final BigDecimal  operador2);
     BigDecimal calcular( final BigDecimal  operador1, final BigDecimal  operador2, final String operacion);
     ElementsOperacion calcular(final ElementsOperacion elementsOperacion);
}
