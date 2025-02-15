package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeArrayIntersectiobn {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 5, 8, 9));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 5, 9));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(5, 8, 9));
        ArrayList<Integer> res = intersec(arr1, arr2, arr3);
        res.forEach(System.out::println);
    }

    private static ArrayList<Integer> intersec(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3) {

        int p1 = 0, p2 = 0, p3 = 0;
        int a = arr1.size();
        int b = arr2.size();
        int c = arr3.size();
        int e1 = 0, e2 = 0, e3 = 0;
        ArrayList<Integer> r1 = new ArrayList<>();
        while (p1 < a && p2 < b && p3 < c) {
            // Compare elements at the pointers
            int val1 = arr1.get(p1);
            int val2 = arr2.get(p2);
            int val3 = arr3.get(p3);

            if (val1 == val2 && val1 == val3) {
                // If elements match in all three arrays, add to result
                r1.add(val1);
                p1++;
                p2++;
                p3++;
            } else if (val1 <= val2 && val1 <= val3) {
                // Move pointer p1 if arr1[p1] is the smallest
                p1++;
            } else if (val2 <= val1 && val2 <= val3) {
                // Move pointer p2 if arr2[p2] is the smallest
                p2++;
            } else {
                // Move pointer p3 if arr3[p3] is the smallest
                p3++;
            }
        }

        // If no intersection, return -1
        if (r1.isEmpty()) {
            r1.add(-1);
        }

        return r1;
    }
}
