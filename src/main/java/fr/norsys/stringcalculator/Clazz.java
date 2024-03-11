package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",\n";

        if (numbers.startsWith("//")) {
            String[] numbersCopyParts = numbers.split("\n", 2);
            delimiter = numbersCopyParts[0].substring(2).replaceAll("[\\[\\]]", "|");
            numbers = numbersCopyParts[1];
        }
        int sum = 0;
        //split and remove empty cells if ever found
        String[] nums = Arrays.stream(numbers.split("[" + delimiter + "]"))
                .map(String::trim)
                .filter(Predicate.isEqual("")
                        .negate()).toArray(String[]::new);

        ArrayList<Integer> negativeNums = new ArrayList<>();

        for (String num : nums) {
            var intNum = Integer.parseInt(num.trim());
            if (intNum < 0) negativeNums.add(intNum);
            sum += intNum > 1000 ? 0 : intNum;
        }
        if (!negativeNums.isEmpty())
            throw new RuntimeException("negatives not allowed - " + negativeNums.toString());
        return sum;
    }
}