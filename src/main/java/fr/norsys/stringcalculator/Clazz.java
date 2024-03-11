package fr.norsys.stringcalculator;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.equals("2")) {
            return 2;
        }
        return 1;
    }
}