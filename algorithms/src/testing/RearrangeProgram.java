package testing;

import java.util.Arrays;

/**
 * list = {1,0,3,4,2,-2,-2,-3,0,2,1}
 * o/p list = {remaining numbers,0,0}
 */
public class RearrangeProgram {
    public static void main(String[] args) {

        int[] arr = new int[]{1,0,3,4,2,-2,-2,-3,0,2,1};//1,3,4,5,-2,-2,-3,2,1,0,0
        int n = arr.length;
        int left=0;
        for(int right=0;right<n;right++){
            if(arr[right]!=0){
                arr[left] = arr[right];
                left++;
            }
        }

        //System.out.println(Arrays.toString(arr));
        while(left<n){
            arr[left]=0;
            left++;
        }

        System.out.println(Arrays.toString(arr));

    }
}
