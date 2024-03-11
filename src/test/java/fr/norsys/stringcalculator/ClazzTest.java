package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ClazzTest {
    @Test
    public void should_return_0_when_input_is_empty() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("");
        // Assert
        assertEquals(0, result);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("1");
        // Assert
        assertEquals(1, result);
    }

    @Test
    public void should_return_3_when_input_is_1_2() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("1,2");
        // Assert
        assertEquals(3, result);
    }

    @Test
    public void should_return_10_when_input_is_1_2_3_4() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("1,2,3,4");
        // Assert
        assertEquals(10, result);
    }

    @Test
    public void should_return_6_when_input_is_1_new_line_2_3() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("1\n2,3");
        // Assert
        assertEquals(6, result);
    }

    @Test
    public void should_return_3_when_input_is_double_anti_slash_delimiter_new_line_1_2() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("//;\n1;2");
        // Assert
        assertEquals(3, result);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_input_is_negative_number() {
        // Arrange
        Clazz clazz = new Clazz();
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            clazz.add("-1,2,3");
        });
    }

    @Test
    public void should_return_2_when_input_2_and_1001() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("2,1001");
        // Assert
        assertEquals(2, result);
    }

    @Test
    public void should_return_3_when_input_is_double_anti_slash_delimiter_1_2() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("//[***]\n1***2");
        // Assert
        assertEquals(3, result);
    }

    @Test
    public void should_return_6_when_input_is_double_anti_slash_2delimiters_1_2_3() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("//[*][%]\n1*2%3");
        // Assert
        assertEquals(6, result);
    }

    @Test
    public void should_return_6_when_input_is_double_anti_slash_2delimiters_multi_chars_1_2_3() {
        // Arrange
        Clazz clazz = new Clazz();
        // Act
        int result = clazz.add("//[***][%%]\n1***2%%3");
        // Assert
        assertEquals(6, result);
    }

}