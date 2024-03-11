package fr.norsys.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClazzTest {
    @Test
    public void should_return_0_when_input_is_empty() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("");
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("1");
        assertEquals(1, result);
    }

    @Test
    public void should_return_sum_of_numbers_when_input_is_multiple_numbers_and_separated_with_commas() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("3,6,3,1");
        assertEquals(13, result);
    }

    @Test
    public void should_return_sum_of_numbers_when_input_is_multiple_numbers_and_separated_with_commas_or_newline() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void should_return_sum_of_numbers_when_input_starts_with_delimiter_and_newline_then_numbers() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void should_throw_exception_negatives_not_allowed() {
        Clazz clazz = new Clazz();
        Throwable throwable = assertThrowsExactly(Exception.class, () -> clazz.add("-1,2,-2"));
        assertEquals(throwable.getMessage(), "negatives not allowed: -1, -2");
    }

    @Test
    public void should_ignore_numbers_bigger_than_1000() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("1001,2");
        assertEquals(2, result);
    }

    @Test
    public void should_return_sum_of_numbers_when_input_starts_with_delimiter_enclosed_and_newline_then_numbers() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    public void should_return_sum_of_numbers_when_input_starts_with_multiple_delimiters_and_newline_then_numbers() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @Test
    public void should_return_sum_of_numbers_when_input_starts_with_multiple_delimiters_that_contains_multiple_chars_and_newline_then_numbers() throws Exception {
        Clazz clazz = new Clazz();
        int result = clazz.add("//[==][%%%]\n1==2%%%3");
        assertEquals(6, result);
    }
}