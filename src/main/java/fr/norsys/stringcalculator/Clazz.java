package fr.norsys.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Clazz {

  public int add(String numbers) {

    if (numbers.isEmpty()) {
      return 0;
    }

    String delimiter = "[,\n]";
    int sum = 0;
    List<Integer> negatives = new ArrayList<>();


    if (numbers.startsWith("//")) {
      if(numbers.charAt(2) == '['){
        int startOfDelimiter = numbers.indexOf("[");
        int endOfDelimiter = numbers.indexOf("]");
        delimiter = Pattern.quote(numbers.substring(startOfDelimiter+1, endOfDelimiter));
        numbers = numbers.substring(endOfDelimiter + 2);
        //delimiter = Pattern.quote(delimiter);
      }else{
        delimiter = numbers.substring(2, 3);
        numbers = numbers.substring(4);
      }

    }

    String[] nums = numbers.split(delimiter);
    for (String num : nums) {
      int number = Integer.parseInt(num);
      if (number > 1000) {
        continue;
      } else if (number < 0) {
        negatives.add(number);
      } else {
        sum += number;
      }
    }
    if (!negatives.isEmpty()) {
      throw new IllegalArgumentException(
        "negative are not allowed :" + negatives
      );
    }
    return sum;
  }
}
