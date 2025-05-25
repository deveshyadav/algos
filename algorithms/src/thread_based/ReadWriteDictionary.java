package thread_based;

import java.util.concurrent.ConcurrentHashMap;

public class ReadWriteDictionary {

    ConcurrentHashMap<String,String> dictionary = new ConcurrentHashMap<>();
    private String read(String in){
        return dictionary.get(in);
    }
    private void delete(String in){
        dictionary.remove(in);
    }
    private String addOrUpdate(String key, String in){
        return dictionary.put(key, in);
    }
}
