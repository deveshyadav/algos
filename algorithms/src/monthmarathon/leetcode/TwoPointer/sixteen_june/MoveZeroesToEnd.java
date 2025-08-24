package monthmarathon.leetcode.TwoPointer.sixteen_june;

import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] arr =  new int[]{0,1,0,2,3,1};
        moveZeroes(arr);
        System.out.println("Required-  " + Arrays.toString(arr));
    }


    private static void moveZeroes(int[] arr) {
        int j= 0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[j++] = arr[i];

            }
        }

        while(j<n){
            arr[j++]=0;
        }
    }

}
