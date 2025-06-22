package monthmarathon.leetcode.TwoPointer.sixteen_june;

import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,3,1};
        int cont = moveZeroes(arr);
        System.out.println("Required-  " + cont);
    }

    /**
     * Any element can occur at most twice
     * @param arr
     * @return
     */
    private static int moveZeroes(int[] arr) {
        int n = arr.length;
        int j= arr[0] == 0 ? 0 : 1;

        for(int i=j+1;i<n-2;i++){
            if(arr[i]!=0){
                arr[j] = arr[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return j+1;
    }

}
