package leetcode;

import java.util.*;

public class KMostFrequentString {

    public static void main(String[] args) {
        String[] arr = new String[]{"aaaa","bbbb","aaaa","bbbb", "c","c",};
        List<String> res = getKMostFreqStrings(arr, 2);
        System.out.println(res);
    }

    private static List<String> getKMostFreqStrings(String[] arr, int k) {
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            map.put(s,map.getOrDefault(s,0)+1);
            m.putIfAbsent(s,i);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((a,b) -> {
            if(map.get(b)-map.get(a) !=0) return map.get(b)-map.get(a);
            return m.get(a)-m.get(b);
        });

       return keyList.subList(0,k);
    }
}
