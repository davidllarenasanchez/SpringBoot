package com.calculadora.controllertest;


import com.calculadora.controller.CalculadoraController;
import com.calculadora.service.ICalculadoraService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculadoraController.class)
public class CalculadoraControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ICalculadoraService calculadoraService;


    @Test
    public void sumar() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/sumar/0/0")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void multiplicar() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/multiplicar/0/0")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }


    @Test
    public void restar() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/restar/0/0")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void dividir() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/dividir/0/0")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

}
