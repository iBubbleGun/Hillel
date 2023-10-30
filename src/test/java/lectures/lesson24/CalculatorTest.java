package lectures.lesson24;

import edu.hillel.lectures.lesson24.Calculator;
import edu.hillel.lectures.lesson24.MathOperationsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CalculatorTest {

    private final MathOperationsService mathOperationsServiceMock =
            Mockito.mock(MathOperationsService.class);

    private final MathOperationsService mathOperationsServiceSpy =
            Mockito.spy(MathOperationsService.class);


    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator(mathOperationsServiceMock);
    }

    @Test
    public void testSumNumbers() {
        assertEquals("TestSumNumbers was failed", 2, calculator.sum(1, 1));
    }


    @Test
    public void testSumBigNumbers() {
        assertEquals("TestSumNumbers was failed", 20_000, calculator.sum(10_000, 10_000));
    }

    @Test(expected = ArithmeticException.class)
    public void testDividingNumbers() {
        assertEquals(2, calculator.divide(4, 0));
    }

    @Test
    public void testExternalOperation() {
        Mockito.when(mathOperationsServiceMock.operation(Mockito.anyInt(), Mockito.anyInt())).thenReturn(5);
        assertEquals(10, calculator.externalOperation(2, 2));
        Mockito.verify(mathOperationsServiceMock, Mockito.times(1)).operation(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void testExternalOperationSpy() {
        this.calculator = new Calculator(mathOperationsServiceSpy);
        assertEquals(10, calculator.externalOperation(2, 2));
        Mockito.verify(mathOperationsServiceSpy, Mockito.times(1)).operation(2, 2);
    }
}
