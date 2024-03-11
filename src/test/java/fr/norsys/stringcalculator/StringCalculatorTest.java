package fr.norsys.stringcalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    public void Should_ReturnsZero_when_Add_EmptyString() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void Should_ReturnSame_Number_when_Add_SingleNumber() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("5");
        assertEquals(5, result);
    }

    // test :Allow the Add methode to hundle an unkown amount of numbers
    @Test
    public void Should_ReturnsSum_when_Add_TwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("3,5");
        assertEquals(8, result);
    }

    @Test
    public void Should_ReturnsSum_when_Add_MultipleNumbers1() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3\n6");
        assertEquals(12, result);
    }
    @Test
    public void Should_ReturnsSum_when_Add_MultipleNumbers2() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,\n");
        assertEquals(1, result);
    }
    @Test
    public void Test_question_4() {
    StringCalculator calculator = new StringCalculator();
    assertEquals(6, calculator.add("1,2\n3"));
    // Test avec un délimiteur personnalisé
    assertEquals(3, calculator.add("//;\n1;2"));
    }
    @Test
    void test_Add_With_Negative_Numbers() {
        StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2,-3"));
        assertEquals("Negatives not allowed: [-1, -3]", exception.getMessage());
    }
    @Test
    void test_Add_With_Negative_Numbers_And_Custom_Delimiter() {
        StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("//;\n-1;8;-7"));
        assertEquals("Negatives not allowed: [-1, -7]", exception.getMessage());
    }

    @Test
    void test_Add_Without_Negative_Numbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(23, calculator.add("8,10,5"));
    }

    @Test
    void test_Add_Without_Negative_Numbers_AndCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(23, calculator.add("//;\n8;10;5"));
    }
    @Test
    void test_Add_With_Numbers_Bigger_Than_1000() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("2,1001"));
    }
    @Test
    void test_AddWithNumbersBiggerThan1000And_Delimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1001;3"));
    }
    @Test
    void test_Add_Without_NumbersBiggerThan1000() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1005, calculator.add("2,3,1000"));
    }

    @Test
    void test_Add_Without_Numbers_Bigger_Than1000And_Delimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1005, calculator.add("//;\n2;3;1000"));
    }

}
