package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void should_return_2_when_input_is_2() {
        Clazz clazz = new Clazz();
        int result = clazz.add("2");
        assertEquals(2, result);
    }

    @Test
    public void should_return_given_number_when_input_is_a_number_other_than_1_or_2() {
        Clazz clazz = new Clazz();
        int result = clazz.add("3");
        assertEquals(3, result);
    }
}