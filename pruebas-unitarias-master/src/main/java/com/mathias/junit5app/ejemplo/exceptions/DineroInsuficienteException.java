package com.mathias.junit5app.ejemplo.exceptions;

public class DineroInsuficienteException extends RuntimeException {

    //Muestra el msj de error por medio del constructor padre -> RunTimeException
    public DineroInsuficienteException(String msg){
        super(msg);
    }
}
