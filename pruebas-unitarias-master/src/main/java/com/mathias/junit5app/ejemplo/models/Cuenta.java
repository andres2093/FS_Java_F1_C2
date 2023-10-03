package com.mathias.junit5app.ejemplo.models;

import com.mathias.junit5app.ejemplo.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    private BigDecimal saldo;
    /*BigDecimal es un tipo de dato que se utiliza mucho para operaciones financieras. Ya que hace las operaciones
    aritméticas de forma numérica y no de forma binaria como con tipos de datos primitivos o wrappers.*/
    private Banco banco;

    public Cuenta(String persona, BigDecimal saldo) {
        this.persona = persona;
        this.saldo = saldo;
        this.banco = new Banco();
    }

    public Cuenta() {
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void debito(BigDecimal monto) {
        //si el nuevo saldo es menor a 0, lanza la excepcion personalizada, sino, se asigna el nuevoSaldo a saldo
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new DineroInsuficienteException("Dinero insuficiente");
        }
        this.saldo = nuevoSaldo;
    }

    public void credito(BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
    }

    //comparación por los atributos 'persona' y 'saldo'
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta c)) {
            return false;
        }
        if (this.persona == null || this.saldo == null) {
            return false;
        }
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }
}
