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
              // delimiter= delimiter.startsWith("[") && delimiter.endsWith("]")?delimiter.substring(1,delimiter.length()-1):delimiter;
                numbers=numbersCopyParts[1];
            };
            String[] nums = numbers.split(delimiter);
            int sum = 0;
            ArrayList<String> negativeNums = new ArrayList<>();
            for (String num : nums) {
                var intNum= !num.isEmpty() ? Integer.parseInt(num.trim()):0;
                if(intNum<0) negativeNums.add(String.valueOf(intNum));
                sum += intNum>1000 ?0: intNum;
            }
            if(!negativeNums.isEmpty()) throw new RuntimeException("negatives not allowed - "+negativeNums.toString());
            return sum;
        }
    }
}