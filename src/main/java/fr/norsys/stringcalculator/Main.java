package fr.norsys.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String numbers = "//[--]\n5--5";
        String patternStr = "^\\[(.)*]";
//        String patternString = "\\n(.*)";
        Pattern p = Pattern.compile(patternStr);
        Matcher m = p.matcher(numbers);
//        boolean b = m.matches();
        if(m.find()){
            System.out.println(m.group());
        }
    }
}
