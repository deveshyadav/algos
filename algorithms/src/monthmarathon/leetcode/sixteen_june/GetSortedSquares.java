package monthmarathon.leetcode.sixteen_june;

import java.util.Arrays;

public class GetSortedSquares {
    public static void main(String[] args) {
        int[] arr =  new int[]{-4,-2,-1,2,3};
        int[] cont = getSortedSqrs(arr);
        System.out.println("Result-  " + Arrays.toString(cont));
    }

    private static int[] getSortedSqrs(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int left = 0;
        int right = n-1;

        while(left<=right){
            int sleft = arr[left]*arr[left];
            int sright = arr[right]*arr[right];

            if(sleft<sright){
                res[right-left] = sright;
                right--;
            } else{
                res[right-left] = sleft;
                left++;
            }
        }
        return res;
    }
}
