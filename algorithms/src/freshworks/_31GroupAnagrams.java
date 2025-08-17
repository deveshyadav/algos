package freshworks;

import java.util.*;

public class _31GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = new String[]{"tea", "ate", "set", "ste", "red", "tes"};
        List<List<String>> res = getAnagrams(arr);
        System.out.println(res);

    }

    private static List<List<String>> getAnagrams(String[] arr) {

        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String str:arr){
            char[] cr = str.toCharArray();
            Arrays.sort(cr);
            map.computeIfAbsent(Arrays.toString(cr), x-> new ArrayList<>()).add(str);
        }

        return map.values().stream().toList();
    }
}
