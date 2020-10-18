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

import java.util.List;

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

    @Test
    public void suma() {
        /* url = "http://localhost:" + port + "/calculadora/multiplica/suma?operador1=<Value1>&operador2=<Value1>"
              Values tested:  Operador1 = 2  & Operador2 = 2,  Result should be 4.0.
             */
        ResponseEntity<Double> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calculadora/suma?operador1=2&operador2=2",  Double.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(4.0));

    }

    @Test
    public void multiplica() {
            /* url = "http://localhost:" + port + "/calculadora/multiplica/<Operador1>/<Operador2>"
              Values tested:  Operador1 = 3  & Operador2 = 3,  Result should be 9.0.
             */
        ResponseEntity<Double> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calculadora/multiplica/3/3", Double.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(9.0));

    }



}
