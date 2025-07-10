package monthmarathon.leetcode.mixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
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
