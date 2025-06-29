package monthmarathon.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,2,3};
        int max = getLISUsingLibBinSearch(arr);
        System.out.println("LIS: " + max);
    }

    //O(n2)
    private static int getLIS(int[] arr) {
        int n = arr.length;
        int max = 1;
        int[] res = new int[n];
        Arrays.fill(res,1);
        for(int i=1;i<n;i++){
            for(int j=0;j< i;j++){
                if(arr[i]>arr[j]){
                    res[i] = Math.max(res[i],res[j]+1);
                }
            }
            max = Math.max(max,res[i]);
        }
        return max;
    }

    //O(nlogn)
    private static int getLISUsingBinSearch(int[] arr){
        List<Integer> tail = new ArrayList<>();
        for(int num:arr){
            int left=0; int right=tail.size();

            while(left<right){
                int mid = (left+right)/2;
                if(tail.get(mid)<num){
                    left = mid+1;
                } else {
                    right = mid;
                }
            }

            if(left == tail.size()){
                tail.add(num);
            } else {
                tail.set(left,num);
            }

        }
        return tail.size();

    }

    //O(nlogn)
    private static int getLISUsingLibBinSearch(int[] arr){
        List<Integer> tail = new ArrayList<>();
        for(int num:arr){
           int ind = Collections.binarySearch(tail, num);
           int fin = ind<0 ? Math.abs(ind)-1 : ind;

            if(fin == tail.size()){
                tail.add(num);
            } else {
                tail.set(fin,num);
            }

        }
        return tail.size();

    }
}
