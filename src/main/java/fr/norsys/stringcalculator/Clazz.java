package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }else {
            String[] nums;
            char delimiter = ',';
            if (numbers.startsWith("//"))
            {
                delimiter = numbers.charAt(2);
                numbers = numbers.substring(numbers.indexOf('\n') + 1);
//                nums = numbers.split(Character.toString(delimiter));
            }
//            else {
                nums = numbers.split("[,\n" + delimiter + "]");
//            }



            int sum =0;
            List<Integer> negatives = new ArrayList<>();
            for(String num : nums){
                int number = Integer.parseInt(num.trim());
                if(number<0){
                    negatives.add(number);
                }
                sum+=number;
            }
            if (!negatives.isEmpty()){
                throw new IllegalArgumentException("Negatives not allowed: " + negatives);
            }
            return sum;
        }

    }
}