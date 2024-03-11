package fr.norsys.stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) {
        String delimiter = ",|\n";
        if (numbers.isEmpty()) {
            return 0;
        }

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


        int numbersParsed[] = Arrays.stream(numbers.split(delimiter))
                .mapToInt(Integer::parseInt)
                .filter(number -> number < 1000)
                .toArray();

        int negativeNumbers[] = Arrays.stream(numbersParsed)
                .filter(number -> number < 0)
                .toArray();

        if (negativeNumbers.length > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

        return Arrays.stream(numbersParsed).sum();
    }
}