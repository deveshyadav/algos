package monthmarathon.leetcode.sliding_window.twentyone_june;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        int target =7;
        int size = getMinSubArray(arr, target);
        System.out.println("Result: "+size);
    }
//{2,3,1,2,4,3}
    private static int getMinSubArray(int[] arr, int target) {
        int left=0;
        int n= arr.length;
        int right=0;
        int curSum =0;
        int minSize=n+1;
        while(right<n){
            curSum = curSum+arr[right];

            while(curSum>= target){
                minSize = Math.min(minSize, right-left+1);
                curSum = curSum - arr[left];
                left++;
            }
            right++;
        }
        return minSize==n+1? 0 : minSize;
    }


}
