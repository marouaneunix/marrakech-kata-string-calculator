package fr.norsys.stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";
        if(numbers.startsWith("//")){
            delimiter=numbers.substring(2,numbers.indexOf("\n"));
            numbers=numbers.substring(numbers.indexOf("\n")+1);
            if(delimiter.startsWith("[") && delimiter.endsWith("]")){
                delimiter = delimiter.substring(1, delimiter.length() - 1);
                String[] delimiters = delimiter.split("\\]\\[");
                delimiter = "";
                for (String delim : delimiters) {
                    delimiter += Pattern.quote(delim) + "|";
                }
                delimiter = delimiter.substring(0, delimiter.length() - 1);
            }else {
                delimiter=Pattern.quote(delimiter);
            }
        }


        int numbersParsed[] = strToArrOfNumbers(numbers,delimiter);
        checkNegatives(numbersParsed);


        return Arrays.stream(numbersParsed).sum();
    }

        private int[] strToArrOfNumbers(String numbers,String delimiter){
            return Arrays.stream(numbers.split(delimiter))
                    .mapToInt(Integer::parseInt)
                    .filter(n->n<1000)
                    .toArray();
        }
        private void checkNegatives(int numbersParsed[]){
            if (Arrays.stream(numbersParsed).anyMatch(num -> num < 0)) {
                int[] negativeNumbers = Arrays.stream(numbersParsed).filter(n->n<0).toArray();
                throw new IllegalArgumentException("Negative numbers are not allowed " + negativeNumbers);
            }
        }
}