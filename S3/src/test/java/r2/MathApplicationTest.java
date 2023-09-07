package r2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    @Mock
    CalculadoraService calcService;

    @InjectMocks
    MathApplication mathApplication;

    @Test
    public void add() {
        when(calcService.add(10.0, 20.0)).thenReturn(30.00);
        assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
        verify(calcService).add(10.0, 20.0);
    }

    @Test
    void subtract() {
        when(calcService.subtract(10.0, 20.0)).thenReturn(-10.00);
        assertEquals(mathApplication.subtract(10.0, 20.0), -10.0, 0);
        verify(calcService).subtract(10.0, 20.0);
    }

    @Test
    void multiply() {
        when(calcService.multiply(10.0, 20.0)).thenReturn(200.00);
        assertEquals(mathApplication.multiply(10.0, 20.0), 200.0, 0);
        verify(calcService).multiply(10.0, 20.0);
    }

    @Test
    void divide() {
        when(calcService.divide(20.0, 20.0)).thenReturn(1.0);
        assertEquals(mathApplication.divide(20.0, 20.0), 1.0, 0);
        verify(calcService).divide(20.0, 20.0);
    }
}