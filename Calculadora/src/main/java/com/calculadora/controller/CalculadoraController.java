package com.calculadora.controller;

import com.calculadora.service.ICalculadoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ICalculadoraService calculadoraService;

    @GetMapping("/sumar/{operador1}/{operador2}")
    public BigDecimal sumar(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2){
        BigDecimal resultado = new BigDecimal(0);
        try{
            resultado = calculadoraService.sumar(operador1,operador2);
            return resultado;
        }catch (ArithmeticException aex){
            return resultado;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return resultado;
        }
    }

    @GetMapping("/multiplicar/{operador1}/{operador2}")
    public BigDecimal multiplicar(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2){
        BigDecimal resultado = new BigDecimal(0);
        try{
            resultado = calculadoraService.multiplicar(operador1,operador2);
            return resultado;
        }catch (ArithmeticException aex){
            return resultado;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return resultado;
        }
    }

    @GetMapping("/restar/{operador1}/{operador2}")
    public BigDecimal restar(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2){
        BigDecimal resultado = new BigDecimal(0);
        try{
            resultado = calculadoraService.restar(operador1,operador2);
            return resultado;
        }catch (ArithmeticException aex){
            return resultado;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return resultado;
        }

    }


    @GetMapping("/dividir/{operador1}/{operador2}")
    public BigDecimal dividir(@PathVariable BigDecimal operador1, @PathVariable BigDecimal operador2){
        BigDecimal resultado = new BigDecimal(0);
        try{
            resultado = calculadoraService.dividir(operador1,operador2);
            return resultado;
        }catch (ArithmeticException aex){
            return resultado;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return resultado;
        }

    }

}
