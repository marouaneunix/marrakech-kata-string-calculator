package fr.norsys.stringcalculator;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }else {
            String[] nums = numbers.split("[,\n]");
            int sum =0;
            for(String num : nums){
                sum+=Integer.parseInt(num.trim());
            }
            return sum;
        }

    }
}