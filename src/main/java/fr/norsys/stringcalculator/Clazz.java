package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clazz {
    public int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        }

        List<Integer> negatives = new ArrayList<>();
        String[] nums;

        if (numbers.startsWith("//")) {
            if(numbers.chars().filter(d -> d == '[').count()>1){

                String delimiters = numbers.substring(numbers.indexOf("["),numbers.indexOf("\n"));

                int delimitersCount = delimiters.split("]").length;

                List<String> delimiterList = new ArrayList<>();

                for (int i=0;i<delimitersCount;i++){
                    String delimiter = delimiters.substring(delimiters.indexOf("[")+1,delimiters.indexOf("]"));
                    delimiterList.add("\\Q"+delimiter+"\\E");
                    delimiters = delimiters.substring(delimiters.indexOf("]")+1);
                }

                String delimiter = delimiterList.toString();
                delimiter = delimiter.replace(",","");
                delimiter = delimiter.replace(" ","|");
                delimiter = delimiter.replace("[", "");
                delimiter = delimiter.replace("]", "");
                System.out.println(delimiter);
                nums = numbers.substring(numbers.indexOf("\n")+1).split(delimiter);

            }else{

                String delimiterPlacement = numbers.substring(2, numbers.indexOf("\n"));

                if(delimiterPlacement.startsWith("[")){

                    String delimiter = delimiterPlacement.substring(delimiterPlacement.indexOf("[")+1,delimiterPlacement.indexOf("]"));
                    nums = numbers.substring(numbers.indexOf("\n")+1).split("\\Q"+delimiter+"\\E");
                }
                else {
                    nums = numbers.substring(numbers.indexOf("\n") + 1).split(delimiterPlacement);
                }
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