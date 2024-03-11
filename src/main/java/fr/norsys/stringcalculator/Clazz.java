package fr.norsys.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            String customDelimiter = numbers.substring(2, delimiterIndex);
            if (customDelimiter.startsWith("[") && customDelimiter.endsWith("]")) {
                customDelimiter = customDelimiter.substring(1, customDelimiter.length() - 1);
            }
            delimiter = Pattern.quote(customDelimiter);
            numbers = numbers.substring(delimiterIndex + 1);
        }
        Integer[] numbersParsed = Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .filter(n->n<1000)
                .toArray(Integer[]::new);
        if (Arrays.stream(numbersParsed).anyMatch(num -> num < 0)) {
            List<Integer> negativeNum = Arrays.stream(numbersParsed).filter(n->n<0).collect(Collectors.toList());
            throw new IllegalArgumentException("Negative numbers are not allowed " + negativeNum);
        }
        int sum = 0;
        for (int i = 0; i < numbersParsed.length; i++) {
            sum+=numbersParsed[i];
        }

        return sum;
    }
}