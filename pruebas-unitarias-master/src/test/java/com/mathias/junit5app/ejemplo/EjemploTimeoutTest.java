package com.mathias.junit5app.ejemplo;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeout;

@Tag("timeout")
public class EjemploTimeoutTest {

    //Clase que prueba el tiempo de duración de las pruebas de distintas maneras

    @Test
    @Timeout(1)//indica que espera un tiempo de demora maximo, de 1 segundo
    void pruebaTimeout() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);// tiempo en milisegundos
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void pruebaTimeout2() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(900);
    }

    @Test
    void testTimeoutAssertions() {
        assertTimeout(Duration.ofSeconds(5), () -> {
            TimeUnit.MILLISECONDS.sleep(4000);
        });
    }
}
