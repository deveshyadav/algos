package monthmarathon.leetcode.TwoPointer.fifteen_june;

/**
 * Find max water container formed by two lines in the height array
 * Time: O(n), Space: O(1) — Two-pointer approach, shrinking from both ends
 * At each step, keep max area = min(height[x], height[y]) * width
 * Skip over heights ≤ current min to reduce redundant checks
 *
 * Alt: Brute-force all pairs → Time: O(n²), Space: O(1)
 */
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
