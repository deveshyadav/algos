package monthmarathon.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinTImeUpgradeServers {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,7};
        int total = 12;
        int minTime = getMinTimeProcessingAllReq(total,arr);
        System.out.println(minTime);
    }

    private static int getMinTimeProcessingAllReq(int total, int[] arr) {
        int high = Integer.MIN_VALUE;

        for(int i:arr){
            if(high<i) high = i;
        }
        high = high*total;
        int low = 1;
        int mid = 1;

        while(low<high){
            mid = (low+high)/2;

            int sum=0;
            for(int i:arr){
                sum+= mid/i;
            }

            if(total <= sum) {
                high=mid;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }
}
