package fr.norsys.stringcalculator;

import java.util.Arrays;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        Integer[] numbersParsed = Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int sum = 0;

        for (int i = 0; i < numbersParsed.length; i++) {
            sum+=numbersParsed[i];
        }

        return sum;

    }
}