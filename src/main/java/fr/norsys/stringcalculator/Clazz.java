package fr.norsys.stringcalculator;

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
                nums = numbers.split(Character.toString(delimiter));
            }else {
                nums = numbers.split("[,\n]");
            }



            int sum =0;
            for(String num : nums){
                sum+=Integer.parseInt(num.trim());
            }
            return sum;
        }

    }
}