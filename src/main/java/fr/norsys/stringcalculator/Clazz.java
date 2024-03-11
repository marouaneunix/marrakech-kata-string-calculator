package fr.norsys.stringcalculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) throws Exception {
        if (numbers.isEmpty()) {
            return 0;
        }

        Matcher negativeNumbersmatcher = Pattern.compile("-\\d+").matcher(numbers);
        StringBuilder negativeNumbers = new StringBuilder();

        while (negativeNumbersmatcher.find()) {
            negativeNumbers.append(negativeNumbersmatcher.group()).append(", ");
        }
        if (!negativeNumbers.isEmpty()) {
            // remove the last ", "
            String outputNumbers = negativeNumbers.substring(0, negativeNumbers.length() - 2);
            throw new Exception("negatives not allowed: " + outputNumbers);
        }

        List<String> separatedNumbers;

        // numbers = //[delimiter]\n[numbers…]
        if (numbers.startsWith("//")) {
            numbers = numbers.replace("//", "");
            String[] separatedDelimiterAndNumbers = numbers.split("\n");
            String unprocessedDelimiters = separatedDelimiterAndNumbers[0];
            String delimiterPattern;

            if (numbers.startsWith("[")) {
                // remove [] from [*]
                unprocessedDelimiters = unprocessedDelimiters.substring(1).substring(0, unprocessedDelimiters.length() - 2);
                List<String> delimiters = List.of(unprocessedDelimiters.split("]\\["));

                delimiterPattern = "(" +
                        delimiters.stream()
                                .map(Pattern::quote)
                                .reduce("", (d1, d2) -> d1 + "|" + d2)
                                // remove unneeded | at the beginning
                                .substring(1)
                        + ")";
            } else {
                // in this case there is only one delimiter //;;\n1;;3
                delimiterPattern = unprocessedDelimiters;
            }

            separatedNumbers = List.of(separatedDelimiterAndNumbers[1].split(delimiterPattern));
        } else {
            separatedNumbers = List.of(numbers.split("[,\n]"));
        }

        return separatedNumbers
                .stream()
                .mapToInt(Integer::parseInt)
                .filter(v -> v <= 1000)
                .sum();
    }
}