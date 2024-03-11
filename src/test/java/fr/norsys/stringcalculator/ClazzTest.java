package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClazzTest {

    Clazz clazz;
    @BeforeEach
    public void setUp(){
        clazz = new Clazz();
    }
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
    public void should_return_3_when_input_is_1_and_2(){
        int result = clazz.add("1,2");
        assertEquals(3,result);
    }

    @Test
    public void should_return_16_when_input_is_unknown(){
        int result = clazz.add("1,2,2,5,1,2,3");
        assertEquals(16,result);
    }

    @Test
    public void should_be_ok_if_multiple_lines(){
        int result=clazz.add("1\n,2\n,2");
        assertEquals(5,result);
    }

    @Test
    public void should_not_be_ok_if_finish_with_new_line(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            clazz.add("1, \n");
        });
        assertEquals("Should not finish with new line", exception.getMessage());

    }

    @Test
    public void should_accept_delimiter(){
        int result=clazz.add("//;\n1;2");
        assertEquals(3,result);
    }

    @Test
    public void should_accept_any_length_delimiter(){
        int result=clazz.add("//[----]\n1----2----3");
        assertEquals(6,result);
    }
    @Test
    public void should_not_accept_negatives(){
        String negativeNumber = "-1,2,-3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            clazz.add(negativeNumber);
        });
        assertEquals("Negatives are not allowed : -1 -3 ", exception.getMessage());
    }

    @Test
    public void should_ignore_numbers_bigger_than_1000(){
        int result = clazz.add("1,1001");
        assertEquals(1,result);
    }

    @Test
    public void should_accept_multiple_delimiters(){
        int result = clazz.add("//[-][%]\n1-2%3");
        assertEquals(6,result);
    }

    @Test
    public void should_accept_multiple_delimiters_with_longer_length(){
        int result = clazz.add("//[--][%%]\n1--2%%3");
        assertEquals(6,result);
    }
}