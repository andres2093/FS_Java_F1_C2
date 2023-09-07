package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CalculadoraE2Test {

    @Mock
    CalculadoraDao calculadoraDao;

    @InjectMocks
    CalculadoraE2 calculadoraE2;

    @BeforeEach
    void setUp(){
        given(calculadoraDao.findValorConstante()).willReturn(3);
    }

    @Test
    void suma() {
        int esperado = 8;
        assertEquals(esperado, calculadoraE2.suma(3, 2));
    }

    @Test
    void resta() {
        int esperado = 4;
        assertEquals(esperado, calculadoraE2.resta(3, 2));
    }

    @Test
    void multiplica() {
        int esperado = 9;
        assertEquals(esperado, calculadoraE2.multiplica(3, 2));
    }
}