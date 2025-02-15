package recursion;

import java.util.ArrayList;

public class CombinationsOfNNumbersKTimes {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(1,n,k,current,res);
        System.out.println(res);
    }

    private static void backtrack(int start, int n, int k, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> res) {
        if(current.size() == k) {
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i=start;i<n;i++){
            current.add(i);
            backtrack(i+1, n ,k, current ,res);
            current.remove(current.size()-1);
        }
    }


}
