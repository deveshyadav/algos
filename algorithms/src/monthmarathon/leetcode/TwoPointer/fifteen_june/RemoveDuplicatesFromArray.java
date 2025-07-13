package monthmarathon.leetcode.TwoPointer.fifteen_june;

/**
 * Remove duplicates from sorted array, allowing at most 1 occurrence
 * Time: O(n), Space: O(1) — In-place write of unique values only
 * Moves pointer j when a new unique value is found
 * Same pattern generalizes to allow K duplicates
 *
 */
public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        int[] arr =  new int[]{1,1,1,2,2,2,3,4,5,5,5,6};
        int cont = removeDupli(arr);
        System.out.println("Unique elements-  " + cont);
    }

    private static int removeDupli(int[] arr) {
        int n = arr.length;
        int j=0;
        for(int i=1;i<n;i++) {
            if(arr[i]!=arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
}
