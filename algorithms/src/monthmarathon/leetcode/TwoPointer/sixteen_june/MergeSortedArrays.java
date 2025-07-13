package monthmarathon.leetcode.TwoPointer.sixteen_june;

import java.util.Arrays;

/**
 * Merge two sorted arrays nums1 and nums2 into nums1 in-place
 * Time: O(m + n), Space: O(1) — Start from the end to avoid overwriting
 * Place larger elements from nums1/right of nums2 at the end
 * If any elements remain in nums2, copy them to the front of nums1
 * Problem: LeetCode 88 — Merge Sorted Array
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 =  new int[]{4,5,6,0,0,0};
        int[] arr2 =  new int[]{1,2,3};
        int[] res = merge(arr1, arr1.length- arr2.length, arr2, arr2.length);
        System.out.println("Required-  " + Arrays.toString(res));
    }

    static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1;
        int right = n-1;
        while(left>=0 && right>=0){
            if(nums1[left] < nums2[right]){
                nums1[left+right+1] = nums2[right];
                right--;
            } else{
                nums1[left+right+1] = nums1[left];
                left--;
            }
        }
        if(right>=0){
            System.arraycopy(nums2,0,nums1,0, right+1);
        }

        return nums1;
    }
}
