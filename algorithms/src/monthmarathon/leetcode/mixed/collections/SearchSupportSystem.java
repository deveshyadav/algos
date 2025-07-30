package monthmarathon.leetcode.mixed.collections;

import java.util.*;

public class SearchSupportSystem {
    public static void main(String[] args) {
        String[] products = new String[]{"bags","baggage","banner","box","cloths"};
        String str = "bags";

        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.merge(1,1,Integer::sum);
        map.merge(2,1,Integer::sum);
        System.out.println(map);

        //Integer dd = map.computeIfPresent(2, (k,v) -> v == 1 ? null : v - 1);

        //System.out.println(dd);
        List<List<String>> res = getSearchedStrings(str,products);
        System.out.println(res);

    }

    private static List<List<String>> getSearchedStrings(String str, String[] products) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        char[] arr = str.toCharArray();
        int n = arr.length;


        for(int i=0;i<n;i++) {
            List<String> tmpRes = new ArrayList<>();
            String temp = str.substring(0,i+1);
            int count = 0;
            for (String prod : products) {
                if(count>=3) break;
                boolean matched =doesMatch(prod,temp,i);
                if(matched) {
                    tmpRes.add(prod);
                    count++;
                }
            }
            res.add(tmpRes);
        }
        return res;
    }

    private static boolean doesMatch(String prod, String temp, int i) {
        return i < prod.length() && temp.equals(prod.substring(0, i + 1));
    }

}
