package sorting;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("threeseven",37);
        map.put("twoseven",27);
        map.put("twoseven2",27);
        map.put("one",1);
        map.put("ona",1);

        for(Map.Entry<String,Integer> entry:map.entrySet()){

            list.add(Arrays.asList(entry.getKey(),String.valueOf(entry.getValue())));

        }

        List<List<String>> ll = list.stream().sorted((x,y)->{
            if(x.get(1).equals(y.get(1))) return x.get(0).compareTo(y.get(0));
            return y.get(1).compareTo(x.get(1));
        }).toList();

        System.out.println(ll);



    }
}
