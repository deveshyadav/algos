package monthmarathon.leetcode.mixed.collections;

import java.util.*;

/**
 * Problem: Find Median from Data Stream (LeetCode 295)
 * Goal: Continuously add numbers and return the median in O(log n) per insertion.
 *
 * Approach: Two Heaps (Max-Heap + Min-Heap)
 * 1. Max-Heap (pqMax):
 *    - Stores the smaller half of numbers
 *    - Top (peek) gives the largest of the smaller half
 * 2. Min-Heap (pqMin):
 *    - Stores the larger half of numbers
 *    - Top (peek) gives the smallest of the larger half
 *
 * Insertion Logic:
 * - If new number <= pqMax.peek() → add to pqMax; else add to pqMin
 * - Rebalance heaps to maintain size property:
 *   - pqMax can have at most 1 extra element (odd size → median is from pqMax)
 *   - If pqMax.size() > pqMin.size() + 1 → move from pqMax → pqMin
 *   - If pqMin.size() > pqMax.size() → move from pqMin → pqMax
 *
 * Median Calculation:
 * - If both heaps are equal in size → median = (pqMax.peek() + pqMin.peek()) / 2.0
 * - Otherwise → median = pqMax.peek() (since pqMax is allowed to have 1 extra element)
 *
 * Time Complexity:
 * - addNum(): O(log n) — heap insertion & possible rebalancing
 * - findMedian(): O(1) — just peek heap tops
 *
 * Space Complexity: O(n) — for storing all elements in heaps
 *
 * Alternative Approaches:
 * 1. Balanced BST (like TreeMap or AVL tree)
 *    - Median can be tracked using size-balanced tree
 *    - Higher complexity to implement
 * 2. Simple sorting after every insertion
 *    - O(n log n) per add → inefficient for streaming data
 */
public class MedianFinder {
    List<Integer> result;

    PriorityQueue<Integer> pqMin = new PriorityQueue<>();
    PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        String[] inst = new String[]{"MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian"
                ,"addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum"
                ,"findMedian","addNum","findMedian","addNum","findMedian","addNum"
                ,"findMedian","addNum","findMedian"};
        List<Integer> ls = Arrays.asList(
                null, 6, null, 10, null, 2, null, 6, null, 5, null, 0,
                null, 6, null, 3, null, 1, null, 0, null, 0, null
        );


        MedianFinder mn = new MedianFinder();
        List<Double> res = mn.execInst(inst, ls);
        System.out.println(res);

    }

    private List<Double> execInst(String[] inst, List<Integer> list) {

        MedianFinder mn = new MedianFinder();
        List<Double> res = new ArrayList<>();
        for(int i=0;i<inst.length;i++){
            switch (inst[i]){
                case "MedianFinder"-> {
                    res.add(null);
                }
                case "addNum" -> {
                    mn.addNum(list.get(i));
                    res.add(null);
                }
                case "findMedian" -> res.add(mn.findMedian());
            }
        }
        return res;
    }


    public MedianFinder() {
        pqMin = new PriorityQueue<>();
        pqMax = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if(pqMax.isEmpty() || num<=pqMax.peek()){
            pqMax.offer(num);
        } else {
            pqMin.offer(num);
        }

        if(pqMin.size() +1 < pqMax.size()){
            pqMin.offer(pqMax.poll());
        } else if(pqMin.size()>pqMax.size()){
            pqMax.offer(pqMin.poll());
        }

    }

    public double findMedian() {
        double temp;
        if(pqMax.size() == pqMin.size()){
            temp =  (pqMax.peek() + pqMin.peek()) /2.0;
        } else {
            temp = pqMax.peek();
        }
        System.out.println("temp->"+temp);
        return temp;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */