package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorstringTest {
    Calculatorstring clazz = new Calculatorstring();
    @Test
    public void should_return_0_when_input_is_empty() {
        int result = clazz.add("");
        assertEquals(0, result);

    }
    @Test
    public void given_a_number_should_return_it(){
        int result = clazz.add("4");
        assertEquals(4, result);
    }

    @Test
    public void given_3_4_numbers_should_return_seven() {
        int result = clazz.add("3,4");
        assertEquals(7, result);
    }
    /*
    ---add-two-numbers---
    @Test
    public void given_a_set_of_numbers_separated_by_commas_numbers_should_return_Exception()  {
        Clazz clazz = new Clazz();
        assertThrows(IllegalArgumentException.class, () -> {
            clazz.add("3,4,5");
        });
    }
     */
    @Test
    public void given_a_set_of_numbers_separated_by_commas_numbers_should_return_the_sum_of_them(){
        int result = clazz.add("3,4,5");
        assertEquals(12, result);
    }
    @Test
    public void given_a_set_of_numbers_separated_by_commas_or_newlines_numbers_should_return_the_sum_of_them() {
        int result = clazz.add("1\n2,3");
        assertEquals(6, result);
    }
    @Test
    public void given_a_bad_usage_of_separators_set_of_numbers_should_return_the_sum_of_numbers(){
        int result = clazz.add("1,\n");
        assertEquals(1, result);
    }
    @Test
    public void given_a_delimiter_return_the_sum_of_numbers(){
        int result = clazz.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void given_a_negative_number_return_exception()   {
        assertThrows(RuntimeException.class, () -> {
            clazz.add("-1,3,,4,6");
        });
    }
    @Test
    public void given_a_set_of_numbers_bigger_that_1000_return_the_sum_of_the_others(){
        int result = clazz.add("2,1001");
        assertEquals(2, result);
    }
    @Test
    public void given_delimiters_of_any_length_return_the_sum_of_numbers(){
        int result = clazz.add("//[***]\n1***2***3");
        assertEquals(6,result) ;
    }
}