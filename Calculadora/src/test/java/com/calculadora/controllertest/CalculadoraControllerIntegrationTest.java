package com.calculadora.controllertest;


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




}
