package leetcode.two_pointer;

import java.util.Arrays;

public class ThreeNumTargetSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(arr);
        int[][] res = getRes(arr);

        System.out.println("wew" + (res.length == 0));
        for (int[] triplet : res) {
            System.out.println(Arrays.toString(triplet));
        }
    }

    private static int[][] getRes(int[] input) {
        int n = input.length;
        int[][] tempRes = new int[n * n][3]; // worst-case space
        int count = 0;

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && input[i] == input[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = input[i] + input[left] + input[right];

                if (sum == 0) {
                    tempRes[count][0] = input[i];
                    tempRes[count][1] = input[left];
                    tempRes[count][2] = input[right];
                    count++;

                    while (left < right && input[left] == input[left + 1]) left++;
                    while (left < right && input[right] == input[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        // Trim the result to the actual number of triplets
        int[][] res = new int[count][3];
        for (int i = 0; i < count; i++) {
            res[i] = Arrays.copyOf(tempRes[i], 3);
        }

        return res;
    }
}
