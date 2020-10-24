package com.calculadora.entity;

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

    private BigDecimal operador1;

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

    private BigDecimal operador2;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    private String operacion;

    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    private BigDecimal resultado;


}

