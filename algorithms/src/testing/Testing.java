package testing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 */
public class Testing {


    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,7};
        int[] arr2 = new int[]{4,9,11};

        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] res  =new int[n1+n2];

        int x=0;
        int y=0;
        int z=0;
        while(x<n1 && y<n2){
            if(arr1[x]<arr2[y]){
                res[z] = arr1[x];
                x++;
                z++;
            } else {
                res[z] = arr2[y];
                y++;
                z++;
            }
        }

        if(x<n1-1){
            while(x<n1){
                res[z] = arr1[x];
                x++;
                z++;
            }
        } else {
            while(y<n2){
                res[z] = arr2[y];
                z++;
                y++;
            }
        }

        System.out.println(Arrays.toString(res));

    }


}
