package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfElementsStream {

    /*
    Given a list of numbers, the task is to insert these numbers into a stream and find the median
    of the stream after each insertion. If the median is a non-integer, consider it’s floor value.c
    The median of a sorted array is defined as the middle element when the number of elements is odd
    and the mean of the middle two elements when the number of elements is even.
    */

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,7,9,2,4,6));
        ArrayList mediansList = getMedians(arr);
        mediansList.forEach(System.out::println);
    }

    private static ArrayList getMedians(ArrayList<Integer> arr) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int num:arr){
            addNum(left, right, num);
            balanceHeaps(left, right);
            res.add(getMedian(left ,right));
        }
        return res;
    }

    private static Integer getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if(left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2;
        }
        else return left.peek();
    }

    private static void balanceHeaps(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
    if(left.size()>right.size()+1) {
        right.add(left.poll());
    }
    else if(right.size()>left.size()) {
        left.add(right.poll());
    }

    }

    private static void addNum(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {
        if(left.isEmpty() || left.peek()>num) {
            left.add(num);
        } else {
            right.add(num);
        }
    }

    /* Using insertion sort and having n2 time

    private static ArrayList getMedians(ArrayList<Integer> arr) {
       //arr.forEach(System.out::println);
        //System.out.println("Printed original");
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.size();
        List<Integer> list = new ArrayList<>();

        for(int num:arr){
            addWithSort(list, num);
            list.forEach(System.out::println);
            System.out.println("Printed list");
            int n1 = list.size();
            if(n1==1) {
                res.add(list.get(0));
               // System.out.println("Continue");
                continue;
            }
            if(n1%2==0) {
                res.add((list.get(n1/2-1)+list.get(n1/2))/2);
            } else {
                res.add(list.get(n1/2));
            }
        }
        return res;
    }


    static void addWithSort(List<Integer> list, int num){
        list.add(num);
        int size = list.size();
        if(size == 1) return;
        int j = size-1;
        while(j>0)
        {
            if(list.get(j-1)<list.get(j))
                return;

            swap(list, j, j-1);
            j--;
        }
    }

    static void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }*/

}
