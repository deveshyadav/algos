package monthmarathon.leetcode.mixed;

import java.util.*;

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
        int n = pqMin.size()+pqMax.size();
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