package com.calculadora.servicetest;

import com.calculadora.service.CalculadoraService;
import com.calculadora.service.ICalculadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculadoraServiceTest {

    ICalculadoraService calculadoraService = new CalculadoraService();

    private BigDecimal operador1;
    private BigDecimal operador2;
    private BigDecimal sumaExpectedResult;
    private BigDecimal multiplicaExpectedResult;


    @BeforeEach
    private void initOperadores(){
        operador1 = new BigDecimal(2.08758);
        operador2 = new BigDecimal( 4.058956);
        sumaExpectedResult = operador1.add(operador2,  MathContext.DECIMAL64);
        multiplicaExpectedResult = operador1.multiply(operador2,  MathContext.DECIMAL64);
    }
    @Test
    public void testSumar() {
        BigDecimal result = calculadoraService.sumar(operador1,operador2);
        assertEquals(sumaExpectedResult, result);
    }

    @Test
    public void testMultiplicar() {
        BigDecimal result = calculadoraService.multiplicar(operador1,operador2);
        assertEquals(multiplicaExpectedResult, result);
    }



}
