package net.javaguides.orderservice.config;

import java.util.*;

public class ThreeNumberSum {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 8, 14, 0));
        int target = 14;

        // Sort the numbers in ascending order for efficient searching
        Collections.sort(numbers);

        // Use a single HashMap to store both the numbers and their indices
        HashMap<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            int twoNumberSumTarget = target - currentNumber;

            // Iterate through the remaining numbers
            for (int j = i + 1; j < numbers.size(); j++) {
                int complement = twoNumberSumTarget - numbers.get(j);

                // Check if the complement exists in the map
                if (numberMap.containsKey(complement) && numberMap.get(complement) != i && numberMap.get(complement) != j) {
                    System.out.println("3 number sum sets are: " + currentNumber + ", " + numbers.get(j) + ", " + complement);
                    // Break the loop if a solution is found
                    break;
                }

                // Add the current number and its index to the map
                numberMap.put(numbers.get(j), j);
            }
        }
    }
}
