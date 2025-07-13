package monthmarathon.leetcode.sliding_window.twentyone_june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Time: O(n + m), Space: O(1) — Sliding window with 26-size freq arrays (optimal for lowercase a–z)
 *
 *  Alt: Sort each substring of size m and compare with sorted s2 → Time: O(n * m log m), Space: O(m)
 *  This uses freq arrays for constant-time anagram check vs. sort-based costly comparisons
 */
public class FindAllAnagrams {
    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "ab";
        List<Integer> res = getAllAnagramsIndex(s1,s2);
        res.forEach(System.out::println);



    }

    private static List<Integer> getAllAnagramsIndex(String s1, String s2) {
        int[] freq = new int[26];
        int[] freq1 = new int[26];
        List<Integer> res = new ArrayList<>();

        for(char c:s2.toCharArray()){
            freq[c-'a']++;
        }
        int windowSize = s2.length();

        for(int i=0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;

            if(i>=windowSize){
                freq1[s1.charAt(i-windowSize)-'a']--;
            }

            if(Arrays.equals(freq,freq1)){
                res.add(i-windowSize+1);
            }

        }
        return res;
    }

}
