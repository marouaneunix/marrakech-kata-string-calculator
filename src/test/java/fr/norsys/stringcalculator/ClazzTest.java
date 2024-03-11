package fr.norsys.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClazzTest {

    @Test
    void should_return_0_when_input_is_empty() {
        Clazz clazz = new Clazz();
        int result = clazz.add("");
        assertEquals(0, result);
    }

    @Test
    void should_return_1_when_input_is_1() {
        Clazz clazz = new Clazz();
        int result = clazz.add("1");
        assertEquals(1, result);
    }

    @Test
    void should_return_3_when_input_is_1_2(){
        Clazz clazz = new Clazz();
        int result = clazz.add("1,2");
        assertEquals(3, result);
    }

    @Test
    void should_return_sum_when_input_contains_comma(){
        Clazz clazz = new Clazz();
        int result = clazz.add("5,5,6,4");
        assertEquals(20, result);
    }

    @Test
    void should_return_sum_when_input_contains_new_line_and_comma(){
        Clazz clazz = new Clazz();
        int result = clazz.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    void should_return_3_when_input_contains_delimiter(){
        Clazz clazz = new Clazz();
        int result = clazz.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    void should_throw_an_illegal_argument_exception_when_passing_negatives_with_custom_delimiter(){
        Clazz clazz = new Clazz();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> clazz.add("//;\n1;2;-3;-4"));
        String expectedMessage = "Negative numbers arent allowed: [-3, -4]";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void should_throw_an_illegal_argument_exception_when_passing_negatives_with_default_delimiter(){
        Clazz clazz = new Clazz();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> clazz.add("1,2\n-3,-4"));
        String expectedMessage = "Negative numbers arent allowed: [-3, -4]";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void should_return_2_when_input_is_1001_2(){
        Clazz clazz = new Clazz();
        assertEquals(2,clazz.add("1001,2"));
    }

    @Test
    void should_return_6_when_using_3stars_delimiter_1_2_3(){
        Clazz clazz = new Clazz();
        int result = clazz.add("//[***]\n1***2***3");
        assertEquals(6,result);
    }

}