package com.calculadora.servicetest;

import com.calculadora.entity.ElementsOperacion;
import com.calculadora.entity.ElementsOperacionDouble;
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
    private BigDecimal sumarExpectedResult;
    private BigDecimal multiplicarExpectedResult;
    private BigDecimal restarExpectedResult;
    private BigDecimal dividirExpectedResult;


    @BeforeEach
    private void initOperadores(){
        operador1 = new BigDecimal(2.08758);
        operador2 = new BigDecimal( 4.058956);
        sumarExpectedResult = operador1.add(operador2,  MathContext.DECIMAL64);
        multiplicarExpectedResult = operador1.multiply(operador2,  MathContext.DECIMAL64);
        restarExpectedResult = operador1.subtract(operador2,  MathContext.DECIMAL64);
        dividirExpectedResult = operador1.divide(operador2,  MathContext.DECIMAL64);
    }
    @Test
    public void testSumar() {
        BigDecimal result = calculadoraService.sumar(operador1,operador2);
        assertEquals(sumarExpectedResult, result);
    }

    @Test
    public void testMultiplicar() {
        BigDecimal result = calculadoraService.multiplicar(operador1,operador2);
        assertEquals(multiplicarExpectedResult, result);
    }


    @Test
    public void testRestar() {
        BigDecimal result = calculadoraService.restar(operador1,operador2);
        assertEquals(restarExpectedResult, result);
    }

    @Test
    public void testDividir() {
        BigDecimal result = calculadoraService.dividir(operador1,operador2);
        assertEquals(dividirExpectedResult, result);
    }


    @Test
    public void testCalcularDividir() {
        BigDecimal result = calculadoraService.calcular(operador1,operador2,"/");
        assertEquals(dividirExpectedResult, result);
    }

    @Test
    public void testCalcularSumar() {
        BigDecimal result = calculadoraService.calcular(operador1,operador2,"+");
        assertEquals(sumarExpectedResult, result);
    }

    @Test
    public void testCalcularMultiplicar() {
        BigDecimal result = calculadoraService.calcular(operador1,operador2,"*");
        assertEquals(multiplicarExpectedResult, result);
    }

    @Test
    public void testCalcularRestar() {
        BigDecimal result = calculadoraService.calcular(operador1,operador2,"-");
        assertEquals(restarExpectedResult, result);
    }

   @Test
    public void testCalcularEntityDividir() {
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"/");
       ElementsOperacion result = calculadoraService.calcular(elementsOperacion);
        assertEquals(dividirExpectedResult, result.getResultado());
    }

    @Test
    public void testCalcularEntitySumar() {
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"+");
        ElementsOperacion result = calculadoraService.calcular(elementsOperacion);
        assertEquals(sumarExpectedResult, result.getResultado());
    }

    @Test
    public void testCalcularEntityMultiplicar() {
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"*");
        ElementsOperacion result = calculadoraService.calcular(elementsOperacion);
        assertEquals(multiplicarExpectedResult, result.getResultado());
    }

    @Test
    public void testCalcularEntityRestar() {
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"-");
        ElementsOperacion result = calculadoraService.calcular(elementsOperacion);
        assertEquals(restarExpectedResult, result.getResultado());
    }


    @Test
    public void testCalcularEntityDoubleDividir() {
        final ElementsOperacionDouble elementsOperacion = new ElementsOperacionDouble(10d, 5d,"/");
        calculadoraService.calcularDouble(elementsOperacion);
        assertEquals(2d, elementsOperacion.getResultado());
    }

    @Test
    public void testCalcularEntityDoubleSumar() {
        final ElementsOperacionDouble elementsOperacion = new ElementsOperacionDouble(10d, 2d,"+");
        calculadoraService.calcularDouble(elementsOperacion);
        assertEquals(12d, elementsOperacion.getResultado());
    }

    @Test
    public void testCalcularEntityDoubleMultiplicar() {
        final ElementsOperacionDouble elementsOperacion = new ElementsOperacionDouble(5d, 5d,"*");
        calculadoraService.calcularDouble(elementsOperacion);
        assertEquals(25d, elementsOperacion.getResultado());
    }

    @Test
    public void testCalcularEntityDoubleRestar() {
        final ElementsOperacionDouble elementsOperacion = new ElementsOperacionDouble(25d, 25.5d,"-");
        calculadoraService.calcularDouble(elementsOperacion);
        assertEquals(-0.5, elementsOperacion.getResultado());
    }


}
