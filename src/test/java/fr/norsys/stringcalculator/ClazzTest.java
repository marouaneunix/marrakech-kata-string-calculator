package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClazzTest {
    static Clazz clazz;

    @BeforeAll
    public static void setUp() {
        clazz = new Clazz();
    }

    @Test
    public void givenEmptyInput_whenAdd_thenReturns0() {
        // Given
        String input = "";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void givenSingleNumberInput_whenAdd_thenReturnsSameNumber() {
        // Given
        String input = "1";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void givenTwoNumbersSeparatedByComma_whenAdd_thenReturnsSum() {
        // Given
        String input = "1,2";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(3, result);
    }

    @Test
    public void givenMultipleNumbersSeparatedByComma_whenAdd_thenReturnsSum() {
        // Given
        String input = "1,2,3";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(6, result);
    }

    @Test
    public void givenNumbersSeparatedByNewLine_whenAdd_thenReturnsSum() {
        // Given
        String input = "1\n2\n3\n10";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(16, result);
    }

    @Test
    public void givenInputWithCustomDelimiter_whenAdd_thenReturnsSum() {
        // Given
        String input = "//[;]\n1;2;3";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(6, result);
    }

    @Test
    public void givenInputWithNegativeNumbers_whenAdd_thenThrowsException() {
        // Given
        String input = "-1,2,-4";

        // When, Then
        assertThrows(IllegalArgumentException.class, () ->
                clazz.add(input)
        );
    }

    @Test
    public void givenInputWithNegativeNumbersAndCustomDelimiter_whenAdd_thenThrowsException() {
        // Given
        String input = "//[%%]\n-1%%2%%-4";

        // When, Then
        assertThrows(IllegalArgumentException.class, () ->
                clazz.add(input)
        );
    }

    @Test
    public void givenInputWithNumbersGreaterThan1000_whenAdd_thenIgnoresAndReturnsSum() {
        // Given
        String input = "2,1001,8,2003";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(10, result);
    }

    @Test
    public void givenInputWithNumbersGreaterThan1000AndCustomDelimiter_whenAdd_thenIgnoresAndReturnsSum() {
        // Given
        String input = "//[;]\n2;1001;8;2003";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(10, result);
    }

    @Test
    public void givenInputWithDelimiterOfAnyLength_whenAdd_thenReturnsSum() {
        // Given
        String input = "//[***]\n1***2***3";

        // When
        int result = clazz.add(input);

        // Then
        assertEquals(6, result);
    }
}
