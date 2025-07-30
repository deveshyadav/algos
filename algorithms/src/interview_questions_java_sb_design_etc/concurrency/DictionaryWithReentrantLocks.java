package interview_questions_java_sb_design_etc.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DictionaryWithReentrantLocks {

    public static void main(String[] args) {
        ReadWriteMap<String, String> dictionary = new ReadWriteMap<>();

        // Writer thread
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String key = "word" + i;
                String value = "definition" + i;
                dictionary.put(key, value);
                System.out.println("Writer added: " + key + " -> " + value);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        });

        // Reader thread
        Thread reader = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String key = "word" + i;
                String value = dictionary.get(key);
                System.out.println("Reader read: " + key + " -> " + value);
                try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            }
        });

        writer.start();
        reader.start();

        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ReadWriteMap<K,V> {
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();
    Map<K,V> map = new HashMap<>();

    public V get(K k){

        readLock.lock();
        try {
            return map.get(k);
        } finally{
            readLock.unlock();
        }
    }

    public void put(K k, V v){
        writeLock.lock();

        try{
            map.put(k,v);
        }finally {
            writeLock.unlock();
        }
    }

    public void getVal(){

    }
}
