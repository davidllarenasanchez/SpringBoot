package com.calculadora.service;


import com.calculadora.entity.ElementsOperacion;
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

    @Override
    public BigDecimal restar(final BigDecimal operador1, final BigDecimal operador2) {
        BigDecimal resultado = new BigDecimal(0);
        resultado = operador1.subtract(operador2, MathContext.DECIMAL64);
        return resultado;
    }

    @Override
    public BigDecimal dividir( final BigDecimal  operador1, final BigDecimal  operador2)  {
        BigDecimal resultado = new BigDecimal(0);
        resultado = operador1.divide(operador2, MathContext.DECIMAL64);
        return resultado;

    }

    @Override
    public BigDecimal calcular(BigDecimal operador1, BigDecimal operador2, String operacion) {
        BigDecimal resultado = new BigDecimal(0);
        if(OPERACION_SUMAR.equalsIgnoreCase(operacion)){
            resultado = this.sumar(operador1,operador2);
        }
        if(OPERACION_RESTAR.equalsIgnoreCase(operacion)){
            resultado = this.restar(operador1,operador2);
        }
        if(OPERACION_MULTIPLICAR.equalsIgnoreCase(operacion)){
            resultado =  this.multiplicar(operador1,operador2);
        }
        if(OPERACION_DIVIDIR.equalsIgnoreCase(operacion)){
            resultado = this.dividir(operador1,operador2);
        }

        return resultado;
    }

    @Override
    public BigDecimal calcular(ElementsOperacion elementsOperacion) {
        BigDecimal resultado = new BigDecimal(0);
        final String operacion = elementsOperacion.getOperacion();
        if(OPERACION_SUMAR.equalsIgnoreCase(operacion)){
            resultado = this.sumar(elementsOperacion.getOperador1(),elementsOperacion.getOperador2());
        }
        if(OPERACION_RESTAR.equalsIgnoreCase(operacion)){
            resultado = this.restar(elementsOperacion.getOperador1(),elementsOperacion.getOperador2());
        }
        if(OPERACION_MULTIPLICAR.equalsIgnoreCase(operacion)){
            resultado =  this.multiplicar(elementsOperacion.getOperador1(),elementsOperacion.getOperador2());
        }
        if(OPERACION_DIVIDIR.equalsIgnoreCase(operacion)){
            resultado = this.dividir(elementsOperacion.getOperador1(),elementsOperacion.getOperador2());
        }
        return resultado;
    }

}
