package fr.norsys.stringcalculator;

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
            for (String num : nums) {
                System.out.println(num);
                sum += Integer.parseInt(num.trim());
            }
            return sum;
        }
    }
}