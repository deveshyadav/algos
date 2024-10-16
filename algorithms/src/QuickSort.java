package net.javaguides.orderservice.config;

import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 8, 14, 0));
        quicksort(numbers ,0, numbers.size());
        System.out.println(numbers);
    }

    private static void quicksort(List<Integer> numbers, int low, int high) {
        if(low < high) {
            int pivot = partition(numbers ,low, high);
            quicksort(numbers, low, pivot - 1);
            quicksort(numbers, pivot + 1, high);
        }
    }

    private static int partition(List<Integer> numbers, int start, int end) {
        int pivot = numbers.get(start);
        int i = start+1;
        for (int j = start+1; j < end; j++) {
            if(numbers.get(j) < pivot) {
                swap(numbers, i, j);
                i++;
            }
        }
        swap(numbers, start, i-1);
        return i-1;
    }

    private static void swap(List<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}
