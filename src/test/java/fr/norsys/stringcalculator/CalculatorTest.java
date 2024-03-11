package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void should_return_0_when_input_is_empty() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int result = clazz.add("");
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int result = clazz.add("1");
        assertEquals(1, result);
    }

    @Test
    public void should_return_res_when_input_are_2numbers() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int result = clazz.add("3,2");
        assertEquals(5, result);
    }

    /*
    @Test
    public void should_return_Exception_when_numbres_are_morethan_two() {
        Calculator clazz = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            clazz.add("3,8,6");
        });

    }
    */
    @Test
    public void should_return_res_when_input_are_unkownnumbers() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int result = clazz.add("3,2,5,3,100");
        assertEquals(113, result);
    }

    @Test
    public void should_return_res_when_separators_Lines_occurs() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int result = clazz.add("3\n6,1");
        assertEquals(10, result);
    }

    @Test
    public void should_return_res_when_different_delimiter() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int result = clazz.add("//&\n1&2");
        assertEquals(3, result);
    }

    @Test
    public void should_return_negativeException_when_numbres_are_negativs() throws NegativeNumberException {
        Calculator clazz = new Calculator();

        assertThrows(NegativeNumberException.class, () -> {
            clazz.add("1,-3,-4");
        });
    }

    @Test
    public void should_return_Res_when_numbres_are_biggerThan1000() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int resultat=clazz.add("2,1001");
        assertEquals(2,resultat);
    }

    @Test
    public void should_return_Res_when_delimiter_different_format() throws NegativeNumberException {
        Calculator clazz = new Calculator();
        int resultat=clazz.add("//&&&\n1&&&2&&&3");
        assertEquals(6,resultat);
    }

}