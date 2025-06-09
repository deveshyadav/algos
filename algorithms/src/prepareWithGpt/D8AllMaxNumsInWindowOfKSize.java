package prepareWithGpt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class D8AllMaxNumsInWindowOfKSize {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1,65,34,56,234,89,765,98,23,12,21,65,543,99));
        List<Integer> res = new ArrayList<>();
        int k = 4;//window size
        res = getMaxNums(arr, k);
        res.forEach(System.out::println);
    }

    private static List<Integer> getMaxNums(List<Integer> arr, int k) {
        List<Integer> res = new ArrayList<>();
        int n = arr.size();
        Deque<Integer> dq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<k;i++){
            int temp = arr.get(i);
            dq.add(temp);
            if(max<temp){
                max = temp;
            }
        }
        res.add(max);
        for(int i=k;i<n;i++){
            int temp = arr.get(i);
            dq.pollFirst();
            dq.addLast(temp);
            res.add(getMax(dq));
        }
        return res;
    }

    private static int getMax(Deque<Integer> dq){
        return dq.stream().max((a,b)->a-b).orElse(0);
    }
}
