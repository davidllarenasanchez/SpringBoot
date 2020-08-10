package com.springboot.h2;

import com.springboot.h2.modelo.servicio.CochesService;
import com.springboot.h2.modelo.servicio.ICochesService;
import com.springboot.h2.restservicio.ServicioRestCoches;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ServicioRestCoches.class)
public class ServicioRestCochesUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ICochesService cochesService;

    @Test
    public void getAllCocches() throws Exception{
        mockMvc.perform(get("/allCoches"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json("[]"));
    }



}
