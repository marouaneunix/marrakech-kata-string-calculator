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
}