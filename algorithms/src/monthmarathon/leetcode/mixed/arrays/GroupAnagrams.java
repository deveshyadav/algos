package monthmarathon.leetcode.mixed.arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagrams = getGroupedAnagrams(arr);
        System.out.println(anagrams);
    }

    private static List<List<String>> getGroupedAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:arr){
            char[] cr = str.toCharArray();
            Arrays.sort(cr);
            map.computeIfAbsent(Arrays.toString(cr), x-> new ArrayList<>()).add(str);
        }

        return map.values().stream().toList();
    }

}
