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
    public void should_return_3_when_input_is_1_comas_2() {
        Clazz clazz = new Clazz();
        int result = clazz.add("1,2");
        assertEquals(3, result);
    }

    @Test
    public void should_return_25_when_input_is_5_comas_5_comas_5_comas_5_comas_5_amout_numbers() {
        Clazz clazz = new Clazz();
        int result = clazz.add("5,5,5,5,5");
        assertEquals(25, result);
    }

}