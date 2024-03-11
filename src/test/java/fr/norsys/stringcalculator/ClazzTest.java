package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ClazzTest {
    @Test
    public void should_return_0_when_input_is_empty() {
        //Arrange
        Clazz clazz = new Clazz();
        //Act
        int result = clazz.add("");
        //Assert
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        //Arrange
        Clazz clazz = new Clazz();
        //Act
        int result = clazz.add("1");
        //Assert
        assertEquals(1, result);
    }

    @Test
    public void should_not_return_an_error_when_we_have_multiple_numbers() {
        //Arrange
        Clazz clazz = new Clazz();
        //Act
        int result = clazz.add("1,2,3,4,5");
        //Assert
        assertEquals(1+2+3+4+5, result);
    }

    @Test void should_handle_lines_between_numbers(){
        //Arrange
        Clazz clazz = new Clazz();

        //Act
        int result =clazz.add("1\n2,3");

        //assert
        assertEquals(1+2+3, result);
    }

  /*
  * the following input is NOT ok: “1,\n” (split with , and when we want to calculate he found only the line (\n))
  */


    @Test void should_handle_lines_betweendd_numbers(){
        //Arrange
        Clazz clazz = new Clazz();

        //Act
        int result =clazz.add("//,\n1,2");

        //assert
        assertEquals(1+2, result);
    }



}