package fr.norsys.stringcalculator;

public class Clazz {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        else {
        String[] nums = numbers.split(",");
        if (nums.length > 2) {
            throw new IllegalArgumentException("Input must contain exactly two numbers separated by a comma");
        }

        return nums.length == 2 ? Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]):Integer.parseInt(nums[0]);
        }
    }
}