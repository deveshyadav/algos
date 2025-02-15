package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<String>> arrayLists = towerOfHanoi(n);
        System.out.println(arrayLists);

    }

    private static ArrayList<ArrayList<String>> towerOfHanoi(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        tohrec(n, "1", "3", "2", res);
        return res;
    }

    private static void tohrec(int n, String source, String dest, String aux, ArrayList<ArrayList<String>> res){
        if(n==0){
            return;
        }
        tohrec(n-1, source, aux, dest, res);
        res.add(new ArrayList<>(Arrays.asList(source, dest)));
        tohrec(n-1, aux, dest, source, res);
    }
}