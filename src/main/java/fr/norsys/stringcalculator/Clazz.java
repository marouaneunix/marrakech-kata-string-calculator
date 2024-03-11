package fr.norsys.stringcalculator;

import java.util.Arrays;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        Integer[] numbersParsed = Arrays.stream(numbers.split(",|\n"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int sum = 0;

        for (int i = 0; i < numbersParsed.length; i++) {
            sum+=numbersParsed[i];
        }

        return sum;

    }
}