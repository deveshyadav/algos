package leetcode;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args){
       String w1 = "SAM";
       String w2 = "JOHN";
       String store = "JOHNSAM";

       int slen = store.length();
       int wordsLen = w1.length()+w2.length();

       int[] f1 = new int[26];
       int[] f2 = new int[26];

       for(char c:store.toCharArray()) f2[c-'A']++;
       for(char c:(w1+w2).toCharArray()) f1[c-'A']++;

       boolean xx =  Arrays.equals(f1,f2);


        System.out.println(xx ? "ys" :"no");

        int[] a = {1,3,5,2,3,1};
        int k = 3;
        float[] res = new float[a.length - k + 1];

        // Initial sum
        int sum = 0;
        for (int i = 0; i < k; i++) sum += a[i];
        res[0] = Math.round((sum / (float)k) * 100f) / 100f;

        // Slide window
        for (int i = 1; i <= a.length - k; i++) {
            sum = sum - a[i - 1] + a[i + k - 1];
            res[i] = Math.round((sum / (float)k) * 100f) / 100f;
        }

        System.out.println(Arrays.toString(res));

    }


}

