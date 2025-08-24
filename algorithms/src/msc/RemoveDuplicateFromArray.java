package msc;

import java.util.Arrays;

public class RemoveDuplicateFromArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(count);
    }
    public static int removeDuplicates(int[] nums) {
        int count =0;
        int n = nums.length;
        int i =0;
        int j = 1;
        while(j<n-1){
            int cur = nums[i];
            if(cur < nums[j]){
               i++;
               count++;
               cur  = nums[i];
               j++;
            }
            else{
                while(j<n-1 && cur >= nums[j]){
                  j++;
                }
                count++;
                cur = nums[j];
                nums[++i] = cur;
                j = i+1;
            }
        }
        return count;
    }
}
