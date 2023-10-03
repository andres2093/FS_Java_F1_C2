package com.mathias.junit5app.ejemplo;

import com.mathias.junit5app.ejemplo.models.Cuenta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("param")
public class EjemploPruebasParametrizadasTest {

    private Cuenta cuenta;

    @BeforeEach
    void initMetodoTest() {       //Se inicializan los valores de la cuenta
        this.cuenta = new Cuenta("Ariel", new BigDecimal("1000.12345"));
        System.out.println("Iniciando prueba unitaria parametrizada");
    }


    /*Se Pasan los valores por parametro a 'monto'. En este caso, con @ValueSource y va probando todos los valores indicados
    uno por uno. primero '100',despues '200', y asi.*/
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    //@ParametrizedTest -> personaliza la salida de texto en el dashboard de prueba
    @ValueSource(strings = {"100", "200", "300", "500", "700", "1000.12345"})
    void testDebitoCuentaValueSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    /*Se Pasan los valores por parametro a 'index' y 'monto'. En este caso, con @CsvSource y va probando todos los valores indicados
    uno por uno*/
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000.12345"})
    void testDebitoCuentaCsvSource(String index, String monto) {
        System.out.println(index + " -> " + monto);
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    /*Se Pasan los valores por parametro a 'saldo', 'monto','esperado' y 'actual'. con @CsvSource y va probando todos los valores indicados
    uno por uno. RESPETANDO EL ORDEN DE LOS PARAMETROS*/

    //Este metodo de prueba verifica que el saldo y la persona no sean null, y que no se debite mas dinero del que se tiene en cuenta
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvSource({"200,100,John,Andres", "250,200,Pepe,Pepe", "300,300,maria,Maria", "510,500,Pepa,Pepa", "700,750,Lucas,Luca", "1000.12345,1000.12345,Cata,Cata"})
    void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
        System.out.println(saldo + " -> " + monto);
        cuenta.setSaldo(new BigDecimal(saldo));
        cuenta.debito(new BigDecimal(monto));
        cuenta.setPersona(actual);

        assertNotNull(cuenta.getSaldo());
        assertNotNull(cuenta.getPersona());
        assertEquals(esperado, actual);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

    }

    //Se Pasan los valores por parametro a traves del file /data.csv, y va probando todos los valores indicados
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvFileSource(resources = "/data.csv")
    void testDebitoCuentaCsvFileSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    //Se Pasan los valores por parametro a traves del file /data2.csv, y va probando todos los valores indicados
    //RESPETANDO EL ORDEN DE LOS PARAMETROS
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvFileSource(resources = "/data2.csv")
    void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
        cuenta.setSaldo(new BigDecimal(saldo));
        cuenta.debito(new BigDecimal(monto));
        cuenta.setPersona(actual);

        assertNotNull(cuenta.getSaldo());
        assertNotNull(cuenta.getPersona());
        assertEquals(esperado, actual);

        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }
}
