package com.calculadora.controller;

import com.calculadora.entity.ElementsOperacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;


import java.math.BigDecimal;
import java.util.Optional;


@RequestMapping("/default")
public interface ICalculadoraController {

    @GetMapping("/multiplicar/{operador1}/{operador2}")
    BigDecimal multiplicar(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2);

    @GetMapping("/sumar/{operador1}/{operador2}")
    public BigDecimal sumar(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2);

    @GetMapping("/restar/{operador1}/{operador2}")
    public BigDecimal restar(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2);


    @GetMapping("/dividir/{operador1}/{operador2}")
    public BigDecimal dividir(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2);

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestParam("operador1")Optional<BigDecimal> operador1, @RequestParam("operador2") Optional<BigDecimal> operador2, @RequestParam("operacion") Optional<String> operacion);

    @PostMapping("/calcularEntity")
    public ResponseEntity<?> calcularEntity(@RequestBody ElementsOperacion elementsOperacion, BindingResult result);

}
