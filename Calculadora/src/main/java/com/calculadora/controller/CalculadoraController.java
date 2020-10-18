package com.calculadora.controller;

import com.calculadora.service.ICalculadoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ICalculadoraService calculadoraService;

    @GetMapping("/suma")
    public Double suma(@RequestParam("operador1") String value1, @RequestParam("operador2") String value2){
        Double operador1 = Double.parseDouble(value1);
        Double operador2 = Double.parseDouble(value2);
        return calculadoraService.suma(operador1,operador2);
    }

    @GetMapping("/multiplica/{operador1}/{operador2}")
    public Double multiplica(@PathVariable Double operador1, @PathVariable Double operador2){
        return calculadoraService.multiplicar(operador1,operador2);
    }


}
