package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7,3,9,9,1,0,3));
        System.out.println(kthLargest(arr, 3));
    }

    private static Integer kthLargest(ArrayList<Integer> arr, int k) {

        int n = arr.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0;i<k;i++){
            pq.add(arr.get(i));
        }
        for(int i=k;i<n;i++){
            //System.out.println("Now pq is:- ");
            //pq.forEach(System.out::println);
            if(!pq.isEmpty()) {
                int val = arr.get(i);
                if(pq.peek() < val){
                    pq.add(val);
                }
            }
            if(pq.size() > k)
                pq.poll();
        }
    return pq.peek();
    }
}
