package lowleveldesign;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHMap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lru = new LinkedHashMap<>(3,0.75f,true){
            @Override
            public boolean removeEldestEntry(Map.Entry<String,Integer> entry){
                return size() > 3;
            }
        };

        lru.put("hey",1);
        lru.put("hey hey",2);
        lru.put("hey hey hey",3);
        lru.put("hey hey hey hey",4);

        lru.forEach((x,y)-> System.out.println(x + " :-> " + y));
    }
}
