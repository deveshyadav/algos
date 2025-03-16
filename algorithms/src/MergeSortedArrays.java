import java.util.*;
import java.util.stream.Collectors;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        int m = 1; int n = 1;
        merge(nums1, m, nums2 ,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int t = m+n-1;
        int i=m-1;
        int j=n-1;
        Set<Integer> set =Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        set.forEach(System.out::println);
        while(j >=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[t--] = nums1[i--];
            }
            else{
                nums1[t--] = nums2[j--];
            }

        }

    }
}
