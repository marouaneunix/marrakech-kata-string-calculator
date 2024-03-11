package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ClazzTest {
    @Test
    public void should_return_0_when_input_is_empty() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("");
        // assert
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("1");
        // assert
        assertEquals(1, result);
    }

    @Test
    public void should_return_3_when_input_is_1_2() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("1,2");
        // assert
        assertEquals(3, result);
    }

    @Test
    public void should_return_the_sum_of_unknown_amount_of_numbers() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("1,2,3,4,5,6,7,8,9,10");
        // assert
        assertEquals(55, result);
    }

    @Test
    public void should_return_the_sum_of_numbers_separated_with_new_lines_or_commas() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("1\n2,3,4\n5,6,7,8,9,10");
        // assert
        assertEquals(55, result);
    }

    @Test
    public void should_return_the_sum_of_1_and_2_with_the_new_delimiter() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("//;\n1;2");
        // assert
        assertEquals(3, result);
    }

    @Test
    public void should_throw_exception_if_one_of_the_inputs_is_negative() {
        // arrange
        Clazz clazz = new Clazz();
        // act & assert
        assertThrows(RuntimeException.class, () -> clazz.add("-1,-2"));
    }

    @Test
    public void should_return_3_when_input_is_2_1_1000() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("2,1,1000");
        // assert
        assertEquals(3, result);
    }

    @Test
    public void should_return_the_sum_of_1_and_2_with_the_new_delimiter_of_any_length() {
        // arrange
        Clazz clazz = new Clazz();
        int result;
        // act
        result = clazz.add("//[::]\n1::2");
        // assert
        assertEquals(3, result);
    }

}