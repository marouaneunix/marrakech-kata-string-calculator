package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] split = splitNumbers(numbers);
        checkNegativeNumbers(numbers, split);
        return sumNumbers(split);
    }

    public static void checkNegativeNumbers(String desiredNumbers, String[] split) {
        if (desiredNumbers.contains("-")) {
            ArrayList<String> negativeNumbers = new ArrayList<>();
            for (String s : split) {
                int num = Integer.parseInt(s);
                if (num < 0) {
                    negativeNumbers.add(s);
                }
            }
            if (!negativeNumbers.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
            }

        }
    }

    public static boolean isBiggerThan1000(int number) {
        return number > 1000;
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            int num = Integer.parseInt(s);
            if (!isBiggerThan1000(num)) {
                sum += num;
            }
        }
        return sum;
    }

    private String[] splitNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            return splitWithCustomDelimiter(numbers);
        } else {
            return numbers.split("[,\n]");
        }
    }

    private String[] splitWithCustomDelimiter(String numbers) {
        int customDelimiterIndex = numbers.indexOf("\n");
        String customDelimiter = numbers.substring(3, customDelimiterIndex - 1);
        String desiredNumbers = numbers.substring(customDelimiterIndex + 1);
        return desiredNumbers.split(Pattern.quote(customDelimiter));
    }


}