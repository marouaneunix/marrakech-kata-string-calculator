package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static int add(String numbers) throws NegativeNumberException {

        int sum=0;
        if (numbers.startsWith("//")) {
            String delimiteur = numbers.substring(2,numbers.indexOf("\n"));
            System.out.println(delimiteur);
            if(delimiteur.startsWith("[")){
                delimiteur=delimiteur.substring(1,delimiteur.indexOf("]"));
            }
            numbers = numbers.substring(numbers.indexOf("\n") + 1).replaceAll(delimiteur, ",");
        }
        numbers = numbers.replaceAll("\n", ",");
        String [] numbersSplited= numbers.split(",");
        List<Integer> negativNumbers=new ArrayList<>();
        //question 4
        if (numbers.isEmpty()) {
            return 0;
        }
       /* if(numbersSplited.length>2){
            throw new IllegalArgumentException();
        }*/
        else
        {
            for (String number : numbersSplited) {
                int parsingnumber= Integer.parseInt(number);
                if( parsingnumber < 0) {
                    negativNumbers.add(parsingnumber);
                }
                if(parsingnumber > 1000){
                    parsingnumber=0;
                }
                sum += parsingnumber;
            }
        }

        if (negativNumbers.size() > 1) throw new NegativeNumberException("Negatives not allowed: " + negativNumbers);

        else return sum;
    }

}