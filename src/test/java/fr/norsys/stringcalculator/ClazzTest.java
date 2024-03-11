package fr.norsys.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClazzTest {

    static Clazz clazz;

    @BeforeAll
    public static void Setup() {
        clazz = new Clazz();

    }


    @Test
    public void should_return_the_given_number_in_parameter(){



        int result = clazz.Add("1");
        assertEquals(1,result);

    }


    @Test
    public void should_return_0_for_an_empty_string(){



        int result = clazz.Add("0");
        assertEquals(0,result);

    }

    @Test
    public void should_return_sum_of_two_numbers_given_as_parameters(){


    int result = clazz.Add("1,2");
    assertEquals(3,result);

    }


    //Q2 Test cases :
    @Test
    public void should_handle_unkown_amount_of_numbers() {
        int result = clazz.Add("1,2,3,4");
        assertEquals(10, result);

    }

    @Test
    public void sum_of_numbers_with_spaces(){
        int result = clazz.Add("1, 2, 3");
        assertEquals(6,result);
    }


    //Q3 Test case
    @Test
    public void addNumbersWithNewLines(){
        int result = clazz.Add("1\n2,3");
        assertEquals(6,result);
    }


    @Test
    public void addNumbersWithNewLinesAndSpaces(){
        int result = clazz.Add("1\n 2 , 3");
        assertEquals(6,result);
    }



    //Q4 Test case

    @Test
    public void addWithDelimiter(){
        int result = clazz.Add("//;\n1;2");
        assertEquals(3,result);
    }



    //Q5 Test case

    @Test
    public void addWithNegativeNumbers(){
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            clazz.Add("1,-2,3,-4");
        });
        assertEquals("negative numbers not allowed:[-2, -4]",exception.getMessage());
    }

    //Q6

    @Test
    public void addNumbersExcludingBiggerThan1000(){
        int result = clazz.Add("2,1001");
        assertEquals(2,result);

    }

}