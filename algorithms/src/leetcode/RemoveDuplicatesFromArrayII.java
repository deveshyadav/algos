package leetcode;

public class RemoveDuplicatesFromArrayII {

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,1,1,1,1,2,3,3};
        dedupe1(arr);
        for(int num:arr){
            System.out.println(num);
        }
    }

    public static int dedupe1(int[] nums) {
        if(nums.length == 0) return 0;

        int index = 1; // position to place next unique element

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index; // number of unique elements
    }
    private static void dedupe2(int[] arr) {
        if (arr.length <= 2) return;

        int index = 2;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != arr[index - 2]) {
                arr[index++] = arr[i];
            }
        }
    }
}
