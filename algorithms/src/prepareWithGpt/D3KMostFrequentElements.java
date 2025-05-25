package prepareWithGpt;

import java.util.*;

public class D3KMostFrequentElements {

    public static void main(String[] args) {
        List<Integer> arr= List.of(1,1,1,5,5,2,4,78,78,3);
        int k= 3;
        ArrayList<Integer> result= getResult(arr,k);
        result.forEach(System.out::println);
    }

    private static ArrayList<Integer> getResult(List<Integer> arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:arr){
            int value = map.getOrDefault(i, 0);
            map.put(i,++value);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq =
                new PriorityQueue<>((e1,e2)-> e2.getValue()-e1.getValue());

        pq.addAll(map.entrySet());
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<k && !pq.isEmpty();i++){
            res.add(pq.poll().getKey());
        }

        return  res;
    }
}
