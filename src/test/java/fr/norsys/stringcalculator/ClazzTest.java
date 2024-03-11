package fr.norsys.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        //Arange
        Clazz clazz = new Clazz();
        //Act
        int result = clazz.add("1\n3;2");
        //Assert
        assertEquals(6, result);
    }
    @Test
    public void should_return_sum_when_input_is_different_delimiters() {
        //Arrange
        Clazz clazz = new Clazz();
        //Act
        int result = clazz.add("//+\n1+2");
        //Assert
        assertEquals(3, result);
    }
   @Test
    public void should_throw_exception_when_negatives_are_given(){
        //Arrange
        Clazz clazz = new Clazz();
        // Act&Assert
        assertThrows(RuntimeException.class, () -> {
           clazz.add("//;\n-1;-2");
       });

   }
    @Test
    public void should_ignore_numbers_bigger_than_1000(){
        //Arrage
        Clazz clazz = new Clazz();
        //Act
        int result = clazz.add("//+\n1001+2");
        //Assert
        assertEquals(2, result);

    }
    @Test
    public void should_accept_delimitors_of_any_length(){
        //Arrage
        Clazz clazz = new Clazz();
        //Act
        int result = clazz.add("//[***]\n1001***2");
        //Assert
        assertEquals(2, result);

    }
}