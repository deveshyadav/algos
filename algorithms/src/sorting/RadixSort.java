package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3,-1,8,4,-9,10};
        //System.out.println(countingSort(Arrays.asList(arr)));]
        //ArrayList<Integer> arr1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static ArrayList<Integer> countingSort(ArrayList<Integer> arr)
    {
        int max = Collections.max(arr);
        int min = Collections.min(arr);
        int range = max - min + 1;
        int[] count = new int[range];
        Arrays.fill(count, 0);
        for(int num:arr){
            count[num-min] ++;
        }
        for(int i=0; i<count.length;i++){
            count[i] += count[i-1];
        }

        int[] output = new int[arr.size()];

        for(int i=arr.size()-1;i>=0;i--) {
            output[count[arr.get(i)-min-1]]  = arr.get(i);
            count[arr.get(i)-min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.size());
         return null;
    }
}
