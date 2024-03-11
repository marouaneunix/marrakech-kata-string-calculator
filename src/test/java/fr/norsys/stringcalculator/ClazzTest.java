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
    public void should_return_sum_when_input_is_more_than_1_number() {
        Clazz clazz = new Clazz();
        int result = clazz.add("1,2");
        assertEquals(3, result);
    }
}