package msc;/*public class Main {
    public static void main1(String[] args){
        A a = new B();
        System.out.println(a.x);
    }
}*/

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaThreadsQuiz
{
    public static void main(String[] args) throws InterruptedException {
        int[][] pair = {{5,1}, {4,5},{9,4},{11,9},{9,4}};
        int[][] newPair = reorder(pair);
        for (int[] num:newPair)
        {
            System.out.println(Arrays.toString(num));
        }
    }

    private static int[][] reorder(int[][] pair) {
        int n = pair.length;
       // Math.pow()

        final int maxx = Arrays.stream(pair).mapToInt(row->row[0]).max().orElseThrow(IllegalArgumentException::new);
        long count = Arrays.stream(pair).map(row->row[0]).filter( v->v== maxx).count();
        if(count >1) return null;

        Map<Integer, Integer> map = Arrays.stream(pair)
                .collect(Collectors.toMap(
                        row -> row[0],
                        col -> col[1],
                        (existing, replacement) -> existing // keep the existing value and ignore the duplicate
                ));

        int tmp1 = maxx;


        for(int i=0; i<n; i++)
        {
            pair[i][0] = tmp1;
            pair[i][1] = map.get(tmp1);
            tmp1 = map.get(tmp1);
        }
        return pair;
    }
}
