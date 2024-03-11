package fr.norsys.stringcalculator;
import java.util.ArrayList;
import java.util.List;
public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }else {
            String[] nums;
            String delimiter = ",";
            if (numbers.startsWith("//"))
            {
                if(numbers.indexOf('\n')==3){
                    delimiter = String.valueOf(numbers.charAt(2));
                    System.out.println("first delim"+delimiter);
                }else{
                    delimiter = numbers.substring(2,numbers.indexOf('\n'));
//                  delimiter = delimiter.substring(1,delimiter.indexOf(']'));
                    System.out.println("second delim"+delimiter);
                    delimiter.replaceAll("[\\[\\]]","");
                }
                numbers = numbers.substring(numbers.indexOf('\n') + 1);
            }
                nums = numbers.split("[,\n" + delimiter + "]");
            for (String num:nums){
                if(!num.isEmpty()){
                    System.out.print(num);
                    System.out.print("-");
                }
            }
            int sum =0;
            List<Integer> negatives = new ArrayList<>();
            for(String num : nums){
                if(!num.isEmpty()){
                    int number = Integer.parseInt(num.trim());
                    if(number >= 1000){
                        number = 0;
                    }if(number<0){
                        negatives.add(number);
                    }
                    sum+=number;
                }
            }if (!negatives.isEmpty()){
                throw new IllegalArgumentException("Negatives not allowed: " + negatives);
            }
            return sum;
        }
    }
}