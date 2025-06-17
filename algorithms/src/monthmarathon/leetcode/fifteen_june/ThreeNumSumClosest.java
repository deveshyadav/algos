package monthmarathon.leetcode.fifteen_june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ThreeNumSumClosest {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int target = 7;
        Arrays.sort(arr);
        ArrayList<Integer> input  = new ArrayList<>(IntStream.of(arr).boxed().toList());
        int res = getRes(input, target);
        System.out.println("Result is-"+res);
    }

    private static int getRes(ArrayList<Integer> input, int target) {
        int n = input.size();
        int bestSum = input.get(0)+input.get(1)+input.get(2);
        int bestDiff = target - bestSum;

        for(int i=0;i<n-3;i++){

            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = input.get(i) + input.get(left) + input.get(right);
                int diff = Math.abs(target-sum);
                if(diff < bestDiff) {
                    bestDiff = diff;
                    bestSum = sum;
                }

                if(sum>target) right--;
                else if(sum < target) left ++;
                else {
                    System.out.println("return1");
                    return bestSum;
                }

            }

        }
        System.out.println("return2");
        return bestSum;
    }


}
