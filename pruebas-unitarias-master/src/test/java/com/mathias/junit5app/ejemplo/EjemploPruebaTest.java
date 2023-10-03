package com.mathias.junit5app.ejemplo;

import com.mathias.junit5app.ejemplo.exceptions.DineroInsuficienteException;
import com.mathias.junit5app.ejemplo.models.Banco;
import com.mathias.junit5app.ejemplo.models.Cuenta;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

//Clase general de las pruebas
class EjemploPruebaTest {
    private Cuenta cuenta;

    //Este método se invoca al principio de cada metodo de prueba
    @BeforeEach
    void initMetodoTest() {
        /*Inicializacion de cuenta, OJO, porque esta inicializacion se va a estar usando a lo largo de toda la
         clase PruebaEjemploTest  */

        /*Se utiliza un BigDecimal, porque es mas preciso en operaciones aritmeticas, BigDecimal, hace operaciones de manera
        numérica y no, de manera binaria, como los tipos de datos primitivos o wrapper.Ademas de manejar numeros muchisimo mas grandes*/

        this.cuenta = new Cuenta("Matias", new BigDecimal("1000.12345"));

        System.out.println("Iniciando la prueba unitaria.");
    }

    //metodo que se invoca al finalizar cada metodo de prueba
    @AfterEach
    void endEach() {
        System.out.println("Finalizando el metodo de prueba.");
    }

    //Este método se muestra al iniciar los casos de prueba
    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    //Este método se muestra al finalizar todos los casos de prueba
    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test");
    }



    @Nested             //se declara cuando utilizamos clases internas dentro de la clase de pruebas
    @DisplayName("probando atributos de la cuenta")
    class CuentaTestNombreSaldo {

        @Test
        @DisplayName("Checkeando el nombre")
        void testNombreCuenta() {
            String esperado = "Matias";   //Indicamos el nombre que esperamos
            String real = cuenta.getPersona(); //Se guarda el nombre que se asigno (en este caso, en la linea 25)
            assertNotNull(real, () -> "la cuenta no puede ser nula");  //Verifica que el valor 'real', no sea un nulo
            assertEquals(esperado, real, () -> "El nombre de la cuenta no fue el que se esperaba: " + esperado + ". Actual: " + real);
            assertTrue(real.equals("Matias"), () -> "Nombre de cuenta esperada debe ser igual a la real");
            //en ves de usar assertTrue, se puede usar assertEquals, de hecho, si ponen el cursor sobre assertTrue, les va a decir
            //que se puede utilizar tambien assertEquals
            //las funciones anónimas que ven, son opcionales, es para dar un msj mas personalizado en caso que el valor 'real', no sea el 'esperado'
        }

        @Test
        @DisplayName("el saldo, que no sea null, mayor que cero, valor esperado")
        void testSaldoCuenta() {
            assertNotNull(cuenta.getSaldo());               //verifica que el saldo no sea nulo
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0); //Compara si getSaldo es menor a 0
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0); //Compara si getSaldo es mayor a 0

            //AssertFalse -> como la condicion proporcionada da false, porque getSaldo() no es menor a 0, Da true
        }

        @Test
        @DisplayName("testeando referencias que sean iguales con el metodo equals")
        void testReferenciaCuenta() {
            Cuenta cuenta = new Cuenta("Gerardo Manzanarez", new BigDecimal("8900.9997"));
            Cuenta cuenta2 = new Cuenta("Gerardo Manzanarez", new BigDecimal("8900.9997"));
            // assertNotEquals(cuenta2, cuenta);
            assertEquals(cuenta2, cuenta);
            //Compara dos cuentas por sus atributos 'persona' y 'saldo'. Para eso, se sobreescribe el metodo Equals
        }
    }

    /*
    Esta anotacion se utiliza para indicar que es una clase prueba. Si se quiere, puede utilizar
    instancias declaradas en otras clases, como por ej, la instancia cuenta, esta instanciada al principio
    de la clase PruebaEjemploTest
    */
    @Nested
    class CuentaOperacionesTest {

        /*Las etiquetas @Tag filtran qué pruebas se ejecutan para un plan de prueba determinado. Por ejemplo, un equipo de desarrollo puede etiquetar las pruebas
         *con valores como "rápido", "lento", etc. y luego proporcionar una lista de etiquetas que se incluirán o excluirán del plan
         *de prueba actual, potencialmente dependientes. sobre el entorno actual.*/

        @Tag("cuenta") //Etiqueta de la clase prueba
        @Test
        @DisplayName("Testeo debito/cuenta")
            //Nombre que se le da a la prueba
        void testDebitoCuenta() {               //Testea que el debito de la cuenta no sea null y que no se debite una cantidad mayor al saldo
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
            //intValue()->devuelve la parte entera
            //toPlainString() ->metodo propio de BigDecimal. Convierte el valor getSaldo() a String plano. Asemeja al toString()

        }

        @Tag("cuenta")
        @Test
            //Testea que el saldo no sea null y que se acredite la suma + el monto
        void testCreditoCuenta() {
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Tag("banco")
        @Test
            //Se prueba el metodo transferir
        void testTransferenciaDineroCuenta() {
            Cuenta cuenta1 = new Cuenta("Lujan Miranda", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Andres Arguello", new BigDecimal("1500.8989"));

            Banco banco = new Banco();
            banco.setNombre("Banco del Estado");
            banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
            assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
            //se valida la resta del saldo a la cuenta 2
            assertEquals("3000", cuenta1.getSaldo().toPlainString());
            //se valida la suma del saldo a la cuenta 1
        }

        @Tag("cuenta")
        @Tag("error")
        @Test
            //prueba la exception personalizada 'DineroInsuficienteException'
        void testDineroInsuficienteExceptionCuenta() {
            //Recuerden que la cuenta tiene asignada (en la linea 25) '1000.12345'. Entonces, no se puede debitar '1500'

            //se captura la exception con assertThrows(nombre_clase.class, funcion anonima que debita en este caso 1500 de la cuenta)
            Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
                cuenta.debito(new BigDecimal(1500));
            });
            String actual = exception.getMessage(); //se captura el msj de la exception
            String esperado = "Dinero insuficiente en la clase";
            assertEquals(esperado, actual);
            //se valida que el exception.getMessage(), se igual a 'Dinero insufieciente'
        }

        @Tag("cuenta")
        @Tag("banco")
        @Test
        @DisplayName("probando realciones entre las cuentas y el banco con asserAll")
            //con assertAll, podemos probar todos los metodos dentro de una sola invocacion
            //Lo van a entender mejor en el modulo 3 que viene, ya que utiliza programacion funcional
        void testRelacionBancoCuentas() {
            Cuenta cuenta1 = new Cuenta("Maria", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

            Banco banco = new Banco();
            banco.addCuenta(cuenta1);
            banco.addCuenta(cuenta2);
            banco.setNombre("Banco del Estado");
            banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
            assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(),
                            () -> "el valor del saldo de la cuenta2 no es el esperado."),
                    () -> assertEquals("3000", cuenta1.getSaldo().toPlainString(),
                            () -> "el valor del saldo de la cuenta1 no es el esperado."),
                    () -> assertEquals(2, banco.getCuentas().size(), () -> "el banco no tienes las cuentas esperadas"),
                    () -> assertEquals("Banco del Estado", cuenta1.getBanco().getNombre()),
                    () -> assertEquals("Andres", banco.getCuentas().stream()
                            .filter(c -> c.getPersona().equals("Andres"))
                            .findFirst()
                            .get().getPersona()),
                    () -> assertTrue(banco.getCuentas().stream()
                            .anyMatch(c -> c.getPersona().equals("Jhon Doe"))));
        }
    }

    @DisplayName("probando debito cuenta repetir")
    @RepeatedTest(value = 5, name = "{displayName} - Repeticion numero {currentRepetition} de {totalRepetitions}")
    //En este caso, repite 5 veces el metodo de prueba.
    //imprime en el dashboard mediante el atributo name = 'DisplayName' + la secuencia de repeticion + el valor total de la repeticion
    void testDebitoCuentaRepetir(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 3) {
            System.out.println("estamos en la repeticion " + info.getCurrentRepetition());
        }
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

}