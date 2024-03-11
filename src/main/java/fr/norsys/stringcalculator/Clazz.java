package fr.norsys.stringcalculator;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else {
            String [] items=numbers.split(",");
            int sum=0;
            for(String item:items){
                sum+=Integer.parseInt(item);
            }
            return sum;
        }
    }
}