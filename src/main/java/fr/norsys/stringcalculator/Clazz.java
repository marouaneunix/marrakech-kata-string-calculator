package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) throws IllegalArgumentException {
        numbers = numbers.trim();
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.length() == 1){
            return Integer.parseInt(numbers);
        } else if(numbers.startsWith("//")){

//            String[] str = numbers.split("\n");
//            String delimiter = str[0].substring(2);
//            String[] numbersList = str[1].split(delimiter);
//            String patternString = "\\[([^\\]]*)\\]";
//            String patternString = "\\n(.*)";
//            Pattern p = Pattern.compile(patternString);
//            Matcher m = p.matcher(numbers);

            String delimiter = numbers.substring(2,3);

//            if (m.find()){
//                String delimiter = m.group();
            String[] numbersList = numbers.substring(numbers.indexOf("\n")+1).split(Pattern.quote(delimiter));
//                        .replaceAll(Pattern.quote(delimiter), ",")
//                        .split(",");
//            } else {
//                numbersList = numbers.split("[,\n]");
//            }
            return sum(numbersList);
        }
        else {
            String[] numbersList = numbers.split("[,\n]");
            return sum(numbersList);
        }
    }

    public int sum(String... args) {
        int result = 0;
        boolean isNegative = false;
        List<Integer> negativeNumbers = new ArrayList<>();
        for(String str : args) {
            int number = Integer.parseInt(str);
            if(number < 0){
                isNegative = true;
                negativeNumbers.add(number);
            } else {
                result += number;
            }
        }
        if(isNegative)
            throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers);
        return result;
    }
}