import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateFromArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(count);
    }
    public static int removeDuplicates(int[] nums) {
        int count =0;
        int n = nums.length;
        int i =0;
        int j = 1;
        while(j<n-1){
            System.out.println("i: "+i + " j: "+j);
            System.out.println("nums i: "+nums[i] + " nums j: "+nums[j]);
            int cur = nums[i];
            if(cur < nums[j]){
                System.out.println("if cur: "+cur + " nums j: "+nums[j]);
               i++;
               count++;
               cur  = nums[i];
               j++;
            }
            else{
                while(j<n-1 && cur >= nums[j]){
                  j++;
                }
                count++;
                System.out.println("else cur: "+cur + " nums j: "+nums[j]);
                cur = nums[j];
                nums[++i] = cur;
                j = i+1;
                System.out.println("else nums i: "+nums[i] + " nums j: "+nums[j]);
            }
        }
        return count;
    }
}
