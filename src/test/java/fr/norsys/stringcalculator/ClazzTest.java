package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ClazzTest {

    Clazz clazz = new Clazz();

    @Test
    public void should_return_0_when_input_is_empty() {
        int result = clazz.add("");
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        int result = clazz.add("1");
        assertEquals(1, result);
    }
    @Test
    public void should_return_2_when_input_is_2() {
        int result = clazz.add("2");
        assertEquals(2, result);
    }
    @Test
    public void should_return_the_same_number_as_input() {
        int result = clazz.add("5");
        assertEquals(5, result);
    }
    @Test
    public void should_return_the_sum_of_two_numbers() {
        int result = clazz.add("5,5");
        assertEquals(10, result);
    }
    @Test
    public void should_return_the_sum_of_two_numbers_split_with_new_line() {
        int result = clazz.add("5\n5");
        assertEquals(10, result);
    }
    @Test
    public void should_return_the_sum_of_three_numbers() {
        int result = clazz.add("5,5,5");
        assertEquals(15, result);
    }
    @Test
    public void should_return_the_sum_of_three_numbers_with_different_delimiter() {
        int result = clazz.add("5,5\n5");
        assertEquals(15, result);
    }
    @Test
    public void should_return_the_sum_of_four_numbers() {
        int result = clazz.add("5,5,5,5");
        assertEquals(20, result);
    }
    @Test
    public void should_return_the_sum_of_four_numbers_split_with_new_lines() {
        int result = clazz.add("5\n5\n5\n5");
        assertEquals(20, result);
    }
    @Test
    public void should_return_the_sum_of_two_numbers_split_with_a_delimiter() {
        int result = clazz.add("//*\n5*5");
//        assertThrows(IllegalArgumentException.class, () -> {clazz.add("//-\n5--5");});
        assertEquals(10, result);
    }
    @Test
    public void should_return_throw_an_exception_if_numbers_negative() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {clazz.add("-5,7\n-5");});
        assertEquals(throwable.getMessage(), "negatives not allowed: [-5, -5]");
    }
}