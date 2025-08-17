package freshworks;

public class _27TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = getTrappedWater(arr);
        System.out.println(res);
    }

    private static int getTrappedWater(int[] arr) {
        int n = arr.length;
        int left = 0; int right = n-1;
        int leftMax = 0; int rightMax = 0;
        int count=0;
        while(left<right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=leftMax){
                    leftMax = arr[left];
                } else {
                    count += leftMax-arr[left];
                }
                left++;
            } else {
                if(rightMax>arr[right]){
                    count += rightMax-arr[right];
                } else {
                    rightMax = arr[right];
                }
                right--;
            }
        }
        return count;
    }
}
