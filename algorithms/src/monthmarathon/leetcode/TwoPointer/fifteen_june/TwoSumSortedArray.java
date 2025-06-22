package monthmarathon.leetcode.TwoPointer.fifteen_june;

import java.util.*;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr  = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        int target = 11;
        Arrays.stream(get2Sum(target, arr)).forEach(System.out::println);
    }

    private static int[] get2Sum(int target, ArrayList<Integer> arr) {
        int n = arr.size();
        int left = 0;
        int right= n-1;
        while(left<right){
            int sum  = arr.get(left) + arr.get(right);
            if(arr.get(left) + arr.get(right) == target){
                return new int[]{arr.get(left), arr.get(right)};
            }
            else if(sum > target) right --;
            else{
                left ++;
            }
        }
        return new int[]{};
    }
}
