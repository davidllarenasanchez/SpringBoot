package com.calculadora.controllertest;


import com.calculadora.entity.ElementsOperacion;
import com.calculadora.entity.ElementsOperacionDouble;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CalculadoraControllerIntegrationTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;



    private final BigDecimal operador1 =  new BigDecimal(2.65);
    private final BigDecimal operador2 =  new BigDecimal(5.688987787878745484154181);

    @Test
    public void sumar() {
        /* url = "http://localhost:" + port + "/calculadora/multiplica/sumar/<Operador1>/<Operador2>"
             */
        final BigDecimal expectedResult = operador1.add(operador2, MathContext.DECIMAL64);
        ResponseEntity<BigDecimal> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calculadora/sumar/"+operador1+"/"+operador2,  BigDecimal.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(expectedResult));

    }


    @Test
    public void multiplicar() {
            /* url = "http://localhost:" + port + "/calculadora/multiplicar/<Operador1>/<Operador2>"
             */
        final BigDecimal expectedResult = operador1.multiply(operador2, MathContext.DECIMAL64);

        ResponseEntity<BigDecimal> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calculadora/multiplicar/"+operador1+"/"+operador2, BigDecimal.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(expectedResult));

    }

    @Test
    public void restar() {
        /* url = "http://localhost:" + port + "/calculadora/restar/<Operador1>/<Operador2>"
         */
        final BigDecimal expectedResult = operador1.subtract(operador2, MathContext.DECIMAL64);
        ResponseEntity<BigDecimal> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calculadora/restar/"+operador1+"/"+operador2, BigDecimal.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(expectedResult));

    }

    @Test
    public void dividir() {
        /* url = "http://localhost:" + port + "/calculadora/dividir/<Operador1>/<Operador2>"
         */
        final BigDecimal expectedResult = operador1.divide(operador2, MathContext.DECIMAL64);
        ResponseEntity<BigDecimal> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calculadora/dividir/"+operador1+"/"+operador2, BigDecimal.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(expectedResult));

    }

    @Test
    public void calcularEntitySumar()  {
        /* url = "http://localhost:" + port + "/calculadora/calcularEntity" */

        final BigDecimal expectedResult = operador1.add(operador2, MathContext.DECIMAL64);
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"+");


        ResponseEntity<ElementsOperacion> response = this.restTemplate.postForEntity("http://localhost:" + port + "/calculadora/calcularEntity", elementsOperacion, ElementsOperacion.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(((ElementsOperacion)response.getBody()).getResultado(), equalTo(expectedResult));

    }

    @Test
    public void calcularEntityRestar()  {
        /* url = "http://localhost:" + port + "/calculadora/calcularEntity" */

        final BigDecimal expectedResult = operador1.subtract(operador2, MathContext.DECIMAL64);
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"-");


        ResponseEntity<ElementsOperacion> response = this.restTemplate.postForEntity("http://localhost:" + port + "/calculadora/calcularEntity", elementsOperacion, ElementsOperacion.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(((ElementsOperacion)response.getBody()).getResultado(), equalTo(expectedResult));

    }

    @Test
    public void calcularEntityMultiplicar()  {
        /* url = "http://localhost:" + port + "/calculadora/calcularEntity" */

        final BigDecimal expectedResult = operador1.multiply(operador2, MathContext.DECIMAL64);
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"*");


        ResponseEntity<ElementsOperacion> response = this.restTemplate.postForEntity("http://localhost:" + port + "/calculadora/calcularEntity", elementsOperacion, ElementsOperacion.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(((ElementsOperacion)response.getBody()).getResultado(), equalTo(expectedResult));

    }

    @Test
    public void calcularEntityDividir()  {
        /* url = "http://localhost:" + port + "/calculadora/calcularEntity" */

        final BigDecimal expectedResult = operador1.divide(operador2, MathContext.DECIMAL64);
        final ElementsOperacion elementsOperacion = new ElementsOperacion(operador1, operador2,"/");



        ResponseEntity<ElementsOperacion> response = this.restTemplate.postForEntity("http://localhost:" + port + "/calculadora/calcularEntity", elementsOperacion, ElementsOperacion.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(((ElementsOperacion)response.getBody()).getResultado(), equalTo(expectedResult));

    }


    @Test
    public void calcularEntityDoubleDividir()  {
        /* url = "http://localhost:" + port + "/calculadora/calcularEntity" */

        final BigDecimal expectedResult = operador1.divide(operador2, MathContext.DECIMAL64);
        final ElementsOperacionDouble elementsOperacion = new ElementsOperacionDouble(operador1.doubleValue(), operador2.doubleValue(),"/");



        ResponseEntity<ElementsOperacionDouble> response = this.restTemplate.postForEntity("http://localhost:" + port + "/calculadora/calcularEntity", elementsOperacion, ElementsOperacionDouble.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));


    }

    @Test
    public void calcularEntityDoubleDividirNullOperator1()  {
        /* url = "http://localhost:" + port + "/calculadora/calcularEntity" */

        final BigDecimal expectedResult = operador1.divide(operador2, MathContext.DECIMAL64);
        final ElementsOperacionDouble elementsOperacion = new ElementsOperacionDouble(null, operador2.doubleValue(),"/");



        ResponseEntity<ElementsOperacionDouble> response = this.restTemplate.postForEntity("http://localhost:" + port + "/calculadora/calcularEntity", elementsOperacion, ElementsOperacionDouble.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));


    }

}
