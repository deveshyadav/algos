package monthmarathon.leetcode.TwoPointer.fifteen_june;

/**
 * Compute total rainwater trapped between elevation bars
 * Time: O(n), Space: O(1) — Two-pointer approach using leftMax and rightMax
 * At each step, water trapped = min(max_left, max_right) - height[i]
 * Moves the pointer with smaller height to ensure valid min boundary
 *
 * Alt: Use prefix/suffix max arrays → Time: O(n), Space: O(n)
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr =  new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int total = getRainWater(arr);
        System.out.println("Trapped water-  " +total);
    }

    private static int getRainWater(int[] arr) {
        int n = arr.length;
        int x = 0;
        int y= n-1;
        int leftMax =0;
        int rightMax =0;
        int count=0;
        while(x<y){
            if(arr[x] <= arr[y]){
                if(arr[x]<leftMax){
                    count += leftMax-arr[x];
                } else{
                    leftMax = arr[x];
                }
                x++;
            } else {
                if(rightMax > arr[y]){
                    count += rightMax - arr[y];
                } else{
                    rightMax = arr[y];
                }
                y--;
            }
        }
        return count;
    }


}
