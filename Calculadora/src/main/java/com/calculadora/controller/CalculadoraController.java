package com.calculadora.controller;

import com.calculadora.entity.ElementsOperacion;
import com.calculadora.service.ICalculadoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController implements ICalculadoraController{

    private final Logger log =LoggerFactory.getLogger(this.getClass());



    @Autowired
    ICalculadoraService calculadoraService;


    @Override
    public BigDecimal multiplicar(BigDecimal operador1, BigDecimal operador2) {

        BigDecimal resultado = null;
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

    @Override
    public BigDecimal sumar(BigDecimal operador1, BigDecimal operador2) {
        BigDecimal resultado = null;
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

    @Override
    public BigDecimal restar(BigDecimal operador1, BigDecimal operador2) {
        BigDecimal resultado = null;
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

    @Override
    public BigDecimal dividir(BigDecimal operador1, BigDecimal operador2) {
        BigDecimal resultado = null;
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

    @Override
    public ResponseEntity<?> calcular(Optional<BigDecimal> operador1, Optional<BigDecimal> operador2, Optional<String> operacion) {
        BigDecimal resultado = new BigDecimal(0);
        Map<String, Object> response = new HashMap<>();

        try {
            resultado = calculadoraService.calcular(operador1.get(),operador2.get(), operacion.get());
        }
        catch(ArithmeticException e) {
            log.error(e.getMessage());
            response.put("mensaje", "Error en los parametros recibidos no deben ser null y los operadores deben ser numéricos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

        }
        catch (Exception ex){
                log.error(ex.getMessage());
                response.put("mensaje", "Error en los parametros recibidos no deben ser null y los operadores deben ser numéricos");
                response.put("error", ex.getMessage());
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<BigDecimal>(resultado, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> calcularEntity(ElementsOperacion elementsOperacion, BindingResult result) {
        BigDecimal resultado = new BigDecimal(0);
        Map<String, Object> response = new HashMap<>();

        try {
            resultado = calculadoraService.calcular(elementsOperacion);
        }
        catch(ArithmeticException | RestClientException e) {
            log.error(e.getMessage());
            response.put("mensaje", "Error en los parametros recibidos no deben ser null y los operadores deben ser numéricos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

        }
        catch (Exception ex){
            log.error(ex.getMessage());
            response.put("mensaje", "Error en los parametros recibidos no deben ser null y los operadores deben ser numéricos");
            response.put("error", ex.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<BigDecimal>(resultado, HttpStatus.OK);
    }
}
