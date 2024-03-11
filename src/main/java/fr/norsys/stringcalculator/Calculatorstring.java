package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculatorstring {
    /* ---add-two-numbers---
         if (nums.length > 2) {
         throw new IllegalArgumentException("La méthode add accepte exactement deux nombres séparés par une virgule.");
         } }*/
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            int startIndex = numbers.indexOf('[');
            if (startIndex != -1) {
                int endIndex = numbers.indexOf(']');
                delimiter = numbers.substring(startIndex + 1, endIndex);
                delimiter = delimiter.replace("[", "\\[").replace("]", "\\]").replace("*", "\\*");
                numbers = numbers.substring(numbers.indexOf("\n") + 1);
            } else {
                delimiter = numbers.substring(2, 3);
                numbers = numbers.substring(numbers.indexOf("\n") + 1);
            }
        }

        String[] nums = numbers.split(delimiter);

        for (String num : nums) {
            if (!num.trim().isEmpty()) {
                int numberInt = Integer.parseInt(num.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                } else if (numberInt <= 1000) {
                    sum += numberInt;
                }
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return sum;
    }
}