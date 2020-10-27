package com.calculadora.controller;

import com.calculadora.entity.ElementsOperacion;
import com.calculadora.entity.ElementsOperacionDouble;
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

    Map<String, Object> response = new HashMap<>();



    @Autowired
    ICalculadoraService calculadoraService;

    /** Metodos sumar, restar, multiplicar, dividir Start end-points sencillos: un metodo de tipo get por cada operación devolviendo nulo en los casos que
      se de alguna excepcion
     */
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

    /* Final end-points sencillos: un metodo de tipo get por cada operación devolviendo nulo en los casos que
      se de alguna excepcion
     */

    /** Calcular un metodo de tipo post que recibe los operandos de tipo BigDecimal y el tipo de operación +,*,-, /
        Devuelve un ResponseEntity
        tiene controles para que en caso de una excepción en alguna de las operaciones o si la entidad recibida es nula
         Devoviendo en este caso  un mensaje de error y un HttpStatus.BAD_REQUEST
     */

    @Override
    public ResponseEntity<?> calcular(Optional<BigDecimal> operador1, Optional<BigDecimal> operador2, Optional<String> operacion) {
        BigDecimal resultado = null;

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

        if(null == resultado){
            log.error("elements operation is null");
            response.put("mensaje", "Error en los parametros recibidos no deben ser null y los operadores deben ser numéricos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<BigDecimal>(resultado, HttpStatus.OK);

    }
    /* Final end-point: un metodo de tipo post que recibe los operandos de tipo BigDecimal y el tipo de operación +,*,-, /
     */


    /** calcularEntity:   un metodo de tipo post que recibe una entidad cuyos miembros son los operandos de tipo BigDecimal y el tipo de operación +,*,-, /
        Devuelve un ResponseEntity
        tiene controles para que en caso de una excepción en alguna de las operaciones o si la entidad recibida es nula
         Devoviendo en este caso  un mensaje de error y un HttpStatus.BAD_REQUEST

         En caso de que la operacion sea correcta devuelve un ReponseEntity con el resultado y  HttpStatus.OK
     */

    @Override
    public ResponseEntity<?> calcularEntity(ElementsOperacion elementsOperacion, BindingResult result) {


        try {
            calculadoraService.calcular(elementsOperacion);
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

        if(null == elementsOperacion.getResultado()){
            log.error("elements operation is null");
            response.put("mensaje", "Error en los parametros recibidos no deben ser null y los operadores deben ser numéricos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ElementsOperacion>(elementsOperacion, HttpStatus.OK);
    }

    /* Final end-point: un metodo de tipo post que recibe una entidad cuyos miembros son los operandos de tipo BigDecimal y el tipo de operación +,*,-, /
    */


     /** calcularEntityDouble: Start end-point: un metodo de tipo post que recibe una entidad cuyos miembros son los operandos de tipo Double y el tipo de operación +,*,-, /
        Devuelve un ResponseEntity
        tiene controles para que en caso de una excepción en alguna de las operaciones o si la entidad recibida es nula
         Devoviendo en este caso  un mensaje de error y un HttpStatus.BAD_REQUEST

         En caso de que la operacion sea correcta devuelve un ReponseEntity con el resultado y  HttpStatus.OK
     */

    @Override
    public ResponseEntity<?> calcularEntityDouble(ElementsOperacionDouble elementsOperacionDouble, BindingResult result) {


        try {
            calculadoraService.calcularDouble(elementsOperacionDouble);
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
        if(null == elementsOperacionDouble.getResultado()){
            log.error("elements operation is null");
            response.put("mensaje", "Error en los parametros recibidos no deben ser null y los operadores deben ser numéricos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ElementsOperacionDouble>(elementsOperacionDouble, HttpStatus.OK);
    }

    /* Final end-point: un metodo de tipo post que recibe una entidad cuyos miembros son los operandos de tipo Double y el tipo de operación +,*,-, /
     */
}
