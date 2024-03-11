package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Clazz {
    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String num : numbers.split("[,\n" + delimiter + "]")) {
            int n = Integer.parseInt(num.trim());
            if (n < 0) {
                negatives.add(n);
            } else if (n <= 1000) {
                sum += n;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed:" + negatives);
        }

        return sum;
    }

}