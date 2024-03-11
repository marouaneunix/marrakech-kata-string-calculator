package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter ="[,\n]";
            String [] numbersCopyParts= numbers.split("\n",2);
            if(numbersCopyParts.length > 1 && numbersCopyParts[0].startsWith("//")){
                delimiter  =numbersCopyParts[0].substring(2);
                numbers=numbersCopyParts[1];
            };
            String[] nums = numbers.split(delimiter);
            int sum = 0;
            ArrayList<String> negativeNums = new ArrayList<>();
            for (String num : nums) {
                var intNum= Integer.parseInt(num.trim());
                if(intNum<0) negativeNums.add(String.valueOf(intNum));
                sum += intNum;
            }
            if(!negativeNums.isEmpty()) throw new RuntimeException("negatives not allowed - "+negativeNums.toString());
            return sum;
        }
    }
}