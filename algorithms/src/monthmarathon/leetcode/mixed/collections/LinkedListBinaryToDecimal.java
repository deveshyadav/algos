package monthmarathon.leetcode.mixed.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LinkedListBinaryToDecimal {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,1,1,1};
        LinkedList<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedList::new));
        double num = getDecimal(list);
        System.out.println("Decimal: "+num);

    }

    private static double getDecimal(LinkedList<Integer> list) {

        double dec = 0d;
        while(!list.isEmpty()){
            dec = dec*2 + list.pollFirst();

        }
        return dec;
    }

}
