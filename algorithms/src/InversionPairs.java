
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InversionPairs {

    public static int mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return 0; // Base case: List with 0 or 1 element has 0 inversion pairs
        }

        // Divide the list into two halves
        int middle = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, middle));
        List<Integer> right = new ArrayList<>(list.subList(middle, list.size()));

        // Recursively sort each half and count inversions
        int leftInversions = mergeSort(left);
        int rightInversions = mergeSort(right);

        // Merge the sorted halves and count inversions during merging
        int mergeInversions = merge(left, right);

        // Return the total inversions
        return leftInversions + rightInversions + mergeInversions;
    }

    private static int merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        int inversions = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
                inversions += left.size() - leftIndex; // Count inversions
            }
        }

        // Copy any remaining elements from left or right
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));

        return inversions;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        int inversionCount = mergeSort(numbers);
        System.out.println("Number of inversion pairs: " + inversionCount);
    }


}
