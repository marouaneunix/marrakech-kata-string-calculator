package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter = ",|\n";
            String numbersWithoutDelimiterPrefix = numbers;

            if (numbers.startsWith("//")) {
                int delimiterIndex = numbers.indexOf("\n");
                delimiter = numbers.substring(2, delimiterIndex);
                numbersWithoutDelimiterPrefix = numbers.substring(delimiterIndex + 1);
            }

            String[] numberArray = numbersWithoutDelimiterPrefix.split(delimiter);
            int sum = 0;
            List<Integer> negativeNumbers = new ArrayList<>();
            for (String number : numberArray) {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    negativeNumbers.add(num);
                }
                else if(num <= 1000){
                    sum += num;
                }

            }

            if (!negativeNumbers.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
            }

            return sum;
        }
    }
}
