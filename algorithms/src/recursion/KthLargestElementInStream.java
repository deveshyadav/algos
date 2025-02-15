package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInStream {
    public static void main(String[] args) {
        ArrayList<Integer> initial = new ArrayList<>(Arrays.asList(2,1));
        ArrayList<Integer> append = new ArrayList<>(Arrays.asList(1,1,1,1));
        ArrayList<Integer> res = kth_largest(2, initial, append);
        res.forEach(System.out::println);
    }

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = getPq(initial_stream, k);
        append_stream.forEach(x -> {
            checkAndAdd(x, pq, k);
            res.add(pq.peek());
        });
        return res;
    }


    static PriorityQueue<Integer> getPq(ArrayList<Integer> arr, Integer k) {
        int n = arr.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int val : arr) {
            checkAndAdd(val, pq ,k);
        }
        System.out.println("PQ is:-");
        pq.forEach(System.out::println);
        System.out.println("PQ done");
        return pq;
    }

    static void checkAndAdd(int val, PriorityQueue<Integer> pq, int k) {
        pq.add(val);
        if (pq.size() > k)
            pq.poll();
    }
}
