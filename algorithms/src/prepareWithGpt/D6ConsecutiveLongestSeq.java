package prepareWithGpt;

import java.util.*;

public class D6ConsecutiveLongestSeq {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,4,5,6,9,10,11,12,13,14,15,16,17);
        int res = consecutiveLongestSeq(list);
        System.out.println(res);
    }

    private static int consecutiveLongestSeq(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        int maxLen = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                maxLen = Math.max(maxLen, streak);
            }
        }

        return maxLen;
    }

}
