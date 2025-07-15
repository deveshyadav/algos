package monthmarathon.leetcode.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Merge Intervals (LeetCode 56)
 * Goal: Merge all overlapping intervals and return the resulting non-overlapping intervals.
 *
 * Approach: Sorting + Single Pass Merge
 * 1. Sort intervals by start time
 * 2. Initialize 'start' and 'end' with the first interval
 * 3. Traverse all remaining intervals:
 *    - If current interval overlaps (curStart <= end):
 *        end = max(end, curEnd) → extend the merged interval
 *    - Else:
 *        Add [start, end] to result and reset start, end to current interval
 * 4. After loop ends, add the last interval
 *
 * Time Complexity: O(n log n)
 * - Sorting dominates; single pass after sorting is O(n)
 *
 * Space Complexity: O(n)
 * - Result list stores merged intervals; can be O(1) if done in-place with careful manipulation
 *
 * Alternative Approach:
 * - Sweep Line Algorithm (more complex, unnecessary for this standard problem)
 */
public class MergeSubRanges {
    public static void main(String[] args) {
        int[][] inp = new int[][]{{2,4},{5,5}};
        int[][] res = mergedIntervals(inp);
        for(int[] i:res)
            System.out.println(Arrays.toString(i));
    }

    private static int[][] mergedIntervals(int[][] inp) {
        int n = inp.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(inp, (a,b) ->Integer.compare( a[0],b[0]));
        int start = inp[0][0];
        int end = inp[0][1];
        for(int i=1;i<n;i++){
            int curStart = inp[i][0];
            int curEnd = inp[i][1];
            if(curStart<=end){
                end = Math.max(end,curEnd);
            }
            else{
                res.add(Arrays.asList(start,end));
                start=curStart;
                end=curEnd;
            }
        }

        res.add(Arrays.asList(start,end));
        return res.stream().map(x->x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
