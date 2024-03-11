package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clazz {
    public int add(String numbers) {

        String delimitor="";

        if (numbers.isEmpty()) {
            return 0;
        }
        else {
            Pattern pattern = Pattern.compile("//");
            Matcher m = pattern.matcher(numbers);

            if (m.find()) {
                    delimitor= String.valueOf(numbers.charAt(2));
            if(delimitor.startsWith("[")){
                    delimitor=numbers.substring(numbers.indexOf("["),numbers.indexOf("]")+1);
                    numbers=numbers.substring(delimitor.length()+2);
                }
                 else
                     numbers = numbers.substring(3);
            }

            String[] items = numbers.split("["+delimitor+"\n;,]");
            int sum = 0;
            List<Integer> negatives=new ArrayList<>();

            for (String item : items) {
                if (item.isEmpty())
                    item = "0";
                if(Integer.parseInt(item)<0)
                    negatives.add(Integer.valueOf(item));
                else{
                    if(Integer.parseInt(item)<1000)
                        sum += Integer.parseInt(item);
                }
            }
            if(negatives.isEmpty())
              return sum;
            else{

                String exceptionMessage="negatives aren't allowed : ";

                for(Integer negative:negatives)
                    exceptionMessage+=negative+" ";
                throw new RuntimeException(exceptionMessage);

            }
        }
    }
}