package fr.norsys.stringcalculator;

import java.util.Collections;
import java.util.List;

public class Clazz {
    public int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty()) {
            return 0;
        }
        else if (stringOfNumbers.endsWith("\n")) {
            throw new IllegalArgumentException("Should not finish with new line");
        }
        String[] numbers = removeNewLinesAndDelimiters(stringOfNumbers);
        return calculate(numbers);
    }
    public String[] removeNewLinesAndDelimiters(String numbers){
        StringBuilder delimiters = new StringBuilder(",");
        if(numbers.startsWith("//")) {
            int startOfDelimiter = 2;
            int endOfDelimiter = 0;

            if(numbers.charAt(2) == '['){
                while (numbers.charAt(startOfDelimiter) == '[') {
                    endOfDelimiter = numbers.indexOf(']', startOfDelimiter);
                    delimiters.append("|").append(numbers, startOfDelimiter + 1, endOfDelimiter);
                    startOfDelimiter = endOfDelimiter + 1;
                }
                numbers = numbers.substring(endOfDelimiter + 1);
            } else {
                int indexOfNewLine= numbers.indexOf("\n");
                delimiters.append("|").append(numbers, startOfDelimiter, indexOfNewLine);
                numbers = numbers.substring(indexOfNewLine +1);
            }
        }
        String numbersWithoutNewLine = numbers.replaceAll("[\n\\s]", "");
        return numbersWithoutNewLine.split(String.valueOf(delimiters));
    }

    public int calculate(String[] numbers){
        int sum = 0;
        int number;
        StringBuilder negativeNumbers = new StringBuilder();
        for (String s : numbers) {
            number = Integer.parseInt(s);
            if(number > 0){
                if(number <= 1000) sum += number;
            }
            else {
                negativeNumbers.append(number).append(" ");
            }
        }
        if(!negativeNumbers.isEmpty()) throw new IllegalArgumentException("Negatives are not allowed : " + negativeNumbers);
        return sum;
    }
}