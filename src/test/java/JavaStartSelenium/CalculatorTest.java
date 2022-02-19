package JavaStartSelenium;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/** Zadanie 6.1 testy klasy Calculator */

public class CalculatorTest {

    Calculator calculator = new Calculator();

    public static final int FIRST_NUMBER = 3;
    public static final int SECOND_NUMBER = 4;

    private int correctExpectedResult = 7;
    private int incorrectExpectedResult = 6;

    @Test
    public void sumTwoNumbersAssertEquals() {
        int actualResult = calculator.add(FIRST_NUMBER, SECOND_NUMBER);
        assertEquals(actualResult, correctExpectedResult);
    }

    @Test
    public void sumTwoNumbersAssertTrue() {
        int actualResult = calculator.add(FIRST_NUMBER, SECOND_NUMBER);
        assertTrue(correctExpectedResult == actualResult);
    }

    @Test
    public void sumTwoNumbersAssertFalse() {
        int actualResult = calculator.add(FIRST_NUMBER, SECOND_NUMBER);
        assertFalse(incorrectExpectedResult == actualResult);
    }
}
