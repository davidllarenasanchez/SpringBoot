package com.calculadora.entity;

import java.io.Serializable;


public class ElementsOperacionDouble implements Serializable {

    private static final long serialVersionUID = 1L;

    public ElementsOperacionDouble(Double operador1, Double operador2, String operacion) {
        super();
        this.operador1 = operador1;
        this.operador2 = operador2;
        this.operacion = operacion;
    }

    private Double operador1;

    public Double getOperador1() {
        return operador1;
    }

    public void setOperador1(Double operador1) {
        this.operador1 = operador1;
    }

    public Double getOperador2() {
        return operador2;
    }

    public void setOperador2(Double operador2) {
        this.operador2 = operador2;
    }

    private Double operador2;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    private String operacion;

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    private Double resultado;


}

