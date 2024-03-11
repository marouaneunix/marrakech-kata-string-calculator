package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        List<Integer> negativeNumbers = new ArrayList<>();
        String delimiter = ",";
        Pattern pattern = Pattern.compile("//");
        Matcher matcher = pattern.matcher(numbers);
        boolean matchFound = matcher.find();
        String[] splitNumbers;

        if (matchFound) {
            int start = numbers.indexOf("/") + 1;
            int end = numbers.indexOf("\n");
            delimiter = numbers.substring(start + 1, end);

            if (delimiter.contains("[") && delimiter.contains("]")) {
                delimiter = delimiter.substring(1, delimiter.length() - 1);
                numbers = numbers.substring(3 + delimiter.length() + 2);
            } else {
                numbers = numbers.substring(2 + delimiter.length() + 1);
            }

            splitNumbers = numbers.split(delimiter);
        } else {
            splitNumbers = numbers.split("[" + delimiter + "\n" + "]");
        }


        int sum = 0;

        for (String number : splitNumbers) {
            int num = Integer.parseInt(number);

            if (num < 0) {
                negativeNumbers.add(num);
            }

            if (num < 1000) {
                sum += num;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
        }

        return sum;
    }
}