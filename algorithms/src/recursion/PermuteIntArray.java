package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class PermuteIntArray {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        permute(arr, current, res);
        System.out.println(res);

    }

    private static void permute(ArrayList<Integer> arr, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> res) {
        System.out.println("See result:-" + atomicInteger.incrementAndGet());
        res.forEach(System.out::println);
        if(current.size() == arr.size())
        {
            res.add(new ArrayList<>(current));
        }
        for(int i=0;i<arr.size();i++){
            if(current.contains(arr.get(i))){
                continue;
            }
            current.add(arr.get(i));
            permute(arr, current, res);
            current.remove(current.size()-1);
        }

    }


}
