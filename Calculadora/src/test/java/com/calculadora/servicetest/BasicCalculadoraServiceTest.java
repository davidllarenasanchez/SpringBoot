package com.calculadora.servicetest;

import com.calculadora.service.CalculadoraService;
import com.calculadora.service.ICalculadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculadoraServiceTest {

    ICalculadoraService calculadoraService = new CalculadoraService();

    private Double operador1;
    private Double operador2;
    private Double sumaExpectedResult;
    private Double multiplicaExpectedResult;


    @BeforeEach
    private void initOperadores(){
        operador1 = 2.0d;
        operador2 = 4.0d;
        sumaExpectedResult = operador1+operador2;
        multiplicaExpectedResult = operador1*operador2;
    }
    @Test
    public void testSuma() {
        Double result = calculadoraService.suma(operador1,operador2);
        assertEquals(sumaExpectedResult, result);
    }

    @Test
    public void testMultiplica() {
        Double result = calculadoraService.multiplicar(operador1,operador2);
        assertEquals(multiplicaExpectedResult, result);
    }


}
