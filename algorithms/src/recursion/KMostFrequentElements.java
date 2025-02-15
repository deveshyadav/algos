package recursion;

import java.util.*;

public class KMostFrequentElements {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,8,12,99,4));
        int k=3;
        ArrayList<Integer> res =  new ArrayList<>(k);
        res = getFrequentElements(arr, k);
        res.forEach(System.out::println);
    }

    private static ArrayList<Integer> getFrequentElements(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int freq = map.getOrDefault(val, 0);
            map.put(val, freq);
        }
        ArrayList<Integer> res = new ArrayList<>(
                map.entrySet().stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()))
                        .limit(k).map(Map.Entry::getKey).toList());
        return res;
    }

}
