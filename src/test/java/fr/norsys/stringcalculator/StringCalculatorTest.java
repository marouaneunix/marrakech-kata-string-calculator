package fr.norsys.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void should_return_0_when_input_is_empty() {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("1");
        assertEquals(1, result);
    }

    @Test
    public void should_return_2_when_input_is_2() {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("2");
        assertEquals(2, result);
    }

    @Test
    public void should_return_given_number_when_input_is_a_number_other_than_1_or_2() {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("3");
        assertEquals(3, result);
    }

    @Test
    public void should_return_sum_of_two_numbers_when_input_has_two_numbers_separated_by_comma() {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("1,2");
        assertEquals(3, result);
    }

    @Test
    public void should_return_sum_of_unknown_amount_of_numbers_as_input_separated_by_comma()
    {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("1,2,3,4,5,6");
        assertEquals(21, result);
    }

    @Test
    public void should_return_sum_of_unknown_amount_of_numbers_as_input_separated_by_comma_and_or_new_line()
    {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("1\n2,3,4,5,6,\n");
        assertEquals(21, result);
    }

    @Test
    public void should_return_sum_of_unknown_amount_of_numbers_as_input_separated_by_different_delimiters()
    {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("//;\n1;2;3");
        assertEquals(6, result);
    }

    @Test
    public void should_return_sum_of_unknown_amount_of_numbers_as_input_and_ignore_negative_number()
    {
        StringCalculator StringCalculator = new StringCalculator();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("//;\n1;2;3;-4;-5");
        });

        String expectedMessage ="negatives not allowed - [-4, -5]";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void should_ignore_numbers_bigger_than_1000()
    {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("//;\n1;2;3;1001;2000");
        assertEquals(6, result);
    }

    @Test
    public void should_support_different_delimiters_with_any_length()
    {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    public void should_allow_multiple_delimiters()
    {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }
    @Test
    public void should_allow_multiple_delimiters_with_any_length()
    {
        StringCalculator StringCalculator = new StringCalculator();
        int result = StringCalculator.add("//[****][%%%%][&]\n1****2%%%3");
        assertEquals(6, result);
    }

}