package monthmarathon.leetcode.fifteen_june;

import java.util.Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr =  new int[]{1,8,6,2,5,4,8,3,7};
        int cont = getContainer(arr);
        System.out.println("Biggest container-  " + cont);
    }

    private static int getContainer(int[] arr) {
        int n = arr.length;
        int x = 0;
        int y = n-1;
        int max = 0;
        while(x<y){
            int min = Math.min(arr[x],arr[y]);
            int sum = min * Math.abs(x-y);
            if(sum>max) {
                max = sum;
            }
            if( arr[x]<arr[y]){
                x++;
                while(x<y && arr[x]<=min) x++;
            }
            else {
                y--;
                while(x<y && arr[y]<=min) y--;
            }
        }
        return max;
    }
}
