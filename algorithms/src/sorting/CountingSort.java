package sorting;

import java.util.ArrayList;
import java.util.Collections;

class CountingSort {

    public static ArrayList<Integer> counting_sort(ArrayList<Integer> arr) {
        int minVal = Collections.min(arr);
        int maxVal = Collections.max(arr);

        //Create count array of size maxVal - minVal + 1
        int[] countArr = new int[maxVal - minVal + 1];

        // Store the count of each element, shifted by minVal
        for (int num : arr) {
            countArr[num - minVal]++;
        }

        // Create a new ArrayList for the sorted output
        ArrayList<Integer> outputArr = new ArrayList<>(arr.size());

        // Sort the input array
        // Sort the input array
        //int index = 0;
        for (int i = minVal; i <= maxVal; i++) {
            while (countArr[i - minVal] > 0) {
                outputArr.add(i);
                countArr[i - minVal]--;
                // index++;
            }
        }
        return outputArr;
    }
}
