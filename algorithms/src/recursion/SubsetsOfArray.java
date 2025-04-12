package recursion;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SubsetsOfArray {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        String str = "str";
        ArrayList<String> arr = str.chars()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toCollection(ArrayList::new));

        arr.forEach(System.out::println);
        ArrayList<String> res = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        permute(arr, current, res, 0);
        System.out.println(res);

    }


private static void permute(ArrayList<String> arr, StringBuilder current, ArrayList<String> res, int size) {
    //System.out.println("See result:-" + atomicInteger.incrementAndGet());
    //res.forEach(System.out::println);
    res.add(current.toString());

    for(int i=size;i<arr.size();i++){
        current.append(arr.get(i));
        permute(arr, current, res, i+1);
        current.deleteCharAt(current.length()-1);
    }

}



}
