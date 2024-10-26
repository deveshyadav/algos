import java.util.ArrayList;
import java.util.Collections;

public class SegregateEvenAndOddNums {

    static ArrayList<Integer> segregateEvensAndOdds(ArrayList<Integer> numbers) {
        int left = 0;                 // Start pointer
        int right = numbers.size() - 1; // End pointer

        while (left < right) {
            // Move left pointer until we find an odd number
            while (left < right && numbers.get(left) % 2 == 0) {
                left++;
            }

            // Move right pointer until we find an even number
            while (left < right && numbers.get(right) % 2 != 0) {
                right--;
            }

            // Swap the odd and even numbers
            if (left < right) {
                Collections.swap(numbers, left, right);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Original List: " + numbers);
        ArrayList<Integer> result = segregateEvensAndOdds(numbers);
        System.out.println("Segregated List: " + result);
    }
}
