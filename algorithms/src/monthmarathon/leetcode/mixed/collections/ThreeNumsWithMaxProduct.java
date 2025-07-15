package monthmarathon.leetcode.mixed.collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class ThreeNumsWithMaxProduct {
    public static void main(String[] args) {
        int[] inp = new int[]{-1,-2,-3,-4};

        PriorityQueue<Integer> pqMin = new PriorityQueue<>(3);
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(3, Collections.reverseOrder());


        for(int i:inp){
            pqMin.offer(i);
            pqMax.offer(i);
        }

        int n1 = pqMin.poll();
        int n2 = pqMin.poll();

        int a1 = pqMax.poll();
        int a2 = pqMax.poll();
        int a3 = pqMax.poll();


        int negMax = Math.abs(n1*n2);
        int posMax = a1*a2;

        if((negMax > posMax && n1>0) || negMax * a1 > posMax * a3) {
            System.out.println("if: "+negMax * a1);
        } else {

            System.out.println("else: "+posMax * a3);
        }
    }
}
