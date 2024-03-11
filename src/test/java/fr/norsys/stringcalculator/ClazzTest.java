package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClazzTest {

  private Clazz clazz;

  @BeforeEach
  public void setup() {
    clazz = new Clazz();
  }

  @Test
  public void should_return_0_when_input_is_empty() {
    //Arrange
    String input ="";
    int result;
    //Act
    result = clazz.add(input);
    //Assert
    assertEquals(0, result);
  }

  @Test
  public void should_return_1_when_input_is_1() {
    //Arrange
    String input ="1";
    int result;
    //Act
    result = clazz.add(input);
    //Assert
    assertEquals(1, result);
  }

  @Test
  public void should_return_3_when_input_is_1_2() {
    //Arrange
    String input ="1,2";
    int result;
    //Act
    result = clazz.add(input);
    //Assert
    assertEquals(3, result);
  }

  @Test
  public void should_return_6_when_input_separated_commas_and_lines() {
    //Arrange
    String input ="1\n2,3";
    int result;
    //Act
    result = clazz.add(input);
    //Assert
    assertEquals(6, result);
  }

  @Test
  public void should_return_3_when_input_is_1_2_and_delimiter_is_dynamic() {
    //Arrange
    String input ="//;\n1;2";
    int result;
    //Act
    result = clazz.add(input);
    //Assert
    assertEquals(3, result);
  }

  @Test
  public void should_throw_exception_when_input_has_negative_number() {
    //Arrange
    String input ="-5,-6";
    Exception exception;
    String expectedMessage;
    String actualMessage;
    //Act
    exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        clazz.add(input);
      }
    );
    expectedMessage = "negative are not allowed :[-5, -6]";
    actualMessage = exception.getMessage();
    //Assert
    assertEquals(expectedMessage, actualMessage);
  }
  @Test
  public void should_return_2_when_input_is_1000_2(){
    //Arrange
    String input = "1001,2";
    int result;
    //Act
    result =clazz.add(input);
    //Assert
    assertEquals(2, result);
  }
  @Test
public void should_return_6_when_delimiter_can_be_any_length(){
    //Arrange
    String input ="//[***]\n1***2***3";
    int result;
    //Act
    result =clazz.add(input);
    //Assert
    assertEquals(6, result);
  }
}
