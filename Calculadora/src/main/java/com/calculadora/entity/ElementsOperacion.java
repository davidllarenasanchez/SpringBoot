package com.calculadora.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ElementsOperacion implements Serializable {

    private static final long serialVersionUID = 1L;

    public ElementsOperacion(BigDecimal operador1, BigDecimal operador2, String operacion) {
        super();
        this.operador1 = operador1;
        this.operador2 = operador2;
        this.operacion = operacion;
    }
    @NotNull(message ="no puede estar vacio")
    private BigDecimal operador1;

    @NotNull(message ="no puede estar vacio")
    private BigDecimal operador2;

    @NotEmpty(message ="no puede estar vacio")
    private String operacion;

    private BigDecimal resultado;

    public BigDecimal getOperador1() {
        return operador1;
    }

    public void setOperador1(BigDecimal operador1) {
        this.operador1 = operador1;
    }

    public BigDecimal getOperador2() {
        return operador2;
    }

    public void setOperador2(BigDecimal operador2) {
        this.operador2 = operador2;
    }



    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }



    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }




}

