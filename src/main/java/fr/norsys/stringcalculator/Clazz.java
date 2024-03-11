package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        List<Integer> negatives = new ArrayList<>();

        String[] nums;

        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, numbers.indexOf("\n"));
            if(delimiter.startsWith("[")){
                String delim = delimiter.substring(delimiter.indexOf("[")+1,delimiter.indexOf("]"));
                nums = numbers.substring(numbers.indexOf("\n")+1).split("\\Q"+delim+"\\E");
            }
            else {
                nums = numbers.substring(numbers.indexOf("\n") + 1).split(delimiter);
            }
        } else {
            nums = numbers.split("[,\n]");
        }

        int sum = Arrays.stream(nums)
                .mapToInt(Integer::parseInt)
                .peek(num -> {
                    if (num < 0) {
                        negatives.add(num);
                    }
                })
                .filter(num->num<=1000)
                .sum();

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers arent allowed: " + negatives);
        }

        return sum;
    }

}