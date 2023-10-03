package com.mathias.junit5app.ejemplo.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    List<Cuenta> cuentas;
    private String nombre;

    public Banco() {
        cuentas = new ArrayList<>();
    }
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addCuenta(Cuenta cuenta) {
        //agrega una cuanta al listado cuentas y a la vez, la instancia cuenta, agrega al banco con su metodo set
        cuentas.add(cuenta);
        cuenta.setBanco(this);
    }

    //metodo que resta saldo de la cuenta origen y suma a la cuenta destino
    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto) {
        origen.debito(monto);
        destino.credito(monto);
    }
}
