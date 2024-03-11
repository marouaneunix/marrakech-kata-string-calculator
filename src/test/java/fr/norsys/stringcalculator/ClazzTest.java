package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void should_return_25_when_input_is_multiple_numbers_5() {
        Clazz clazz = new Clazz();
        int result = clazz.add("5,5,5,5,5");
        assertEquals(25, result);
    }

    @Test
    public void should_return_3_when_input_is_1_new_lines_2() {
        Clazz clazz = new Clazz();
        int result = clazz.add("1\n2");
        assertEquals(3, result);
    }

    @Test
    public void should_return_6_when_input_is_1_new_lines_2_comas_3() {
        Clazz clazz = new Clazz();
        int result = clazz.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void should_return_3_when_input_is_double_slash_comas_new_lines_1_comas_2() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//,\n1,2");
        assertEquals(3, result);
    }

    @Test
    public void should_return_5_when_input_is_double_slash_delimiter_new_lines_2_delimiter_3() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//;\n2;3");
        assertEquals(5, result);
    }

    @Test
    public void should_return_exception_message_when_input_is_negativeNum() {
        Clazz clazz = new Clazz();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> clazz.add("-5"));
        assertEquals("Negatives not allowed: [-5]", exception.getMessage());
    }

    @Test
    public void should_return_exception_message_when_input_is_negativeNum_comas_negativeNum() {
        Clazz clazz = new Clazz();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> clazz.add("-5,-2"));
        assertEquals("Negatives not allowed: [-5, -2]", exception.getMessage());
    }

    @Test
    public void should_return_2_when_input_is_2_comas_1000() {
        Clazz clazz = new Clazz();
        int result = clazz.add("2,1000");
        assertEquals(2, result);
    }

    @Test
    public void should_return_2_when_input_is_double_slash_delimiter_new_lines_2_delimiter_1000() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//;\n2;1000");
        assertEquals(2, result);
    }

    @Test
    public void should_return_5_when_input_is_double_slash_duplicate_delimiter_new_lines_2_duplicate_delimiter_3() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[***]\n2***3");
        assertEquals(5, result);
    }

    @Test
    public void should_return_9_when_input_is_double_slash_delimiter_new_lines_2_delimiter_3_delimiter_4() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[***]\n2***3***4");
        assertEquals(9, result);
    }
    @Test
    public void should_return_6_when_input_is_1_2_3_with_Two_delimiters() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[*][,]\n1*2,3");
        assertEquals(6, result);
    }

    @Test
    public void should_return_15_when_input_is_1_2_3_4_5_with_Two_delimiters_and_multiple_numbers() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[*][,]\n1*2,3*4,5");
        assertEquals(15, result);
    }

    @Test
    public void should_return_10_when_input_is_1_2_3_4_with_multiple_delimiters() {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[*][,][;]\n1*2,3;4");
        assertEquals(10, result);
    }




}