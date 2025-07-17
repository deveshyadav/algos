package interview_questions_java_sb_design_etc.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ReadWriteDictionary {

    ConcurrentHashMap<String,String> dictionary = new ConcurrentHashMap<>();
    private String read(String key){
        return dictionary.get(key);
    }
    private void delete(String key){
        dictionary.remove(key);
    }
    private String addOrUpdate(String key, String in){
        return dictionary.put(key, in);
    }
}
