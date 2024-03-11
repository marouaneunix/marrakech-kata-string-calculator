package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClazzTest {
    @Test
    public void should_return_0_when_input_is_empty() {
        Clazz clazz = new Clazz();
        int result = clazz.add("");
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        Clazz clazz = new Clazz();
        int result = clazz.add("1");
        assertEquals(1, result);
    }

    @Test
    public void should_return_3_when_input_is_1_and_2() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//1, 2");

        assertEquals(3, result);
    }

    @Test
    public void should_return_6_when_input_is_1_n2_3() {
        Clazz clazz = new Clazz();
        int result = clazz.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    public void should_throw_an_exception_unique_negative() {

        Clazz clazz = new Clazz();

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clazz.add("-1\n2,3");
        });

        Assertions.assertEquals("Negatives not allowed: [-1]", thrown.getMessage());

    }

    @Test
    public void should_throw_an_exception_multiple_negative() {

        Clazz clazz = new Clazz();

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clazz.add("-1\n-2,-3");
        });

        Assertions.assertEquals("Negatives not allowed: [-1, -2, -3]", thrown.getMessage());

    }

    @Test
    public void should_return_2_when_input_is_2_and_1001() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//2\n1003");

        assertEquals(2, result);
    }

}