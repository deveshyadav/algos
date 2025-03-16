import java.util.ArrayList;
import java.util.Arrays;

public class TrapRainWater {

    public static void main(String[] args) {
        int[] heights =new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int result = rainWater(heights);
        System.out.println("Res is: " + result);
    }

    private static int rainWater(int[] arr) {
        int n = arr.length;
        int x = 0;
        int y = n-1;
        int count = 0;
        int leftMax = arr[x];
        int rightMax = arr[y];

        while(x<y){
            if(arr[x] <= arr[y]) {
                if (arr[x] < leftMax) {
                    count = count + leftMax - arr[x];
                }else{
                    leftMax = arr[x];
                }
                x++;
            }else{
                if (arr[y] < rightMax) {
                    count = count + rightMax - arr[y];
                }else{
                    rightMax = arr[y];
                }
                y--;
            }

        }
        return count;
    }
}
