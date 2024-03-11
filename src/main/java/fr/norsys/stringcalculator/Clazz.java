package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        if (numbers.startsWith("//")) {
            numbers = replaceCustomDelimiter(numbers);
        }

        sum = calculateSum(numbers, negativeNumbers);

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

        return sum;
    }

    private String replaceCustomDelimiter(String numbers) {
        return numbers.replace("//", "");
    }

    private int calculateSum(String numbers, List<Integer> negativeNumbers) {
        String[] parts = numbers.split("[,\n]");
        int sum = 0;

        for (String part : parts) {
            int num = Integer.parseInt(part.trim());

            if (num < 0) {
                negativeNumbers.add(num);
            }

            if (num <= 1000) {
                sum += num;
            }
        }

        return sum;
    }

}
