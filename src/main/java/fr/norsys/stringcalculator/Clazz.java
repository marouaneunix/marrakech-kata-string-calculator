package fr.norsys.stringcalculator;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }else {

            char delimiter = ',';
            if (numbers.startsWith("//"))
            {
                delimiter = numbers.charAt(2);
                numbers = numbers.substring(numbers.indexOf('\n') + 1);
            }
            String[] nums = numbers.split(Character.toString(delimiter));


            int sum =0;
            for(String num : nums){
                sum+=Integer.parseInt(num.trim());
            }
            return sum;
        }

    }
}