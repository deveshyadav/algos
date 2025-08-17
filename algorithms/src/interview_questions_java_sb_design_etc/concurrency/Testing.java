package interview_questions_java_sb_design_etc.concurrency;

import java.util.HashMap;
import java.util.Map;

public class Testing<K,V> {

    int capactiy =2;
    Map<K,Node1<K,V>> map = new HashMap<>();
    DlinkedList<K,V> dll = new DlinkedList<>();
    public static void main(String[] args) {
        Testing<Integer,String> cache = new Testing<>();
        cache.put(1,"one");
        cache.put(2,"two");
        cache.put(3,"three");
        cache.put(4,"four");
        cache.put(1,"one");
        cache.get(1);


        cache.map.entrySet().forEach(x-> System.out.println(x.getKey() + " -"+x.getValue().value));


    }

    public void put(K key, V value){

        if(!map.containsKey(key)){
            System.out.println("Size "+map.size());
            if(map.size()>=2){
                Node1<K,V> node = dll.removeTail();
                map.remove(node.key);
            }
            Node1<K,V> Node1  = new Node1<>(key,value);
            dll.addToHead(Node1);
            map.put(key,Node1);

        } else {

            Node1<K,V> existing  = map.get(key);
            existing.value = value;
            dll.moveToHead(existing);
        }

    }

    public V get(K key){
        if(!map.containsKey(key)){
            return null;
        }
       // System.out.println("Bewfor Head val is "+dll.head.next.value);
        Node1<K,V> Node1  = map.get(key);
        dll.moveToHead(Node1);
       // System.out.println("After Head val is "+dll.head.next.value);
        return Node1.value;
    }

}

class Node1<K,V>{
    K key;
    V value;
    Node1<K,V> prev;
    Node1<K,V> next;
    Node1(K key, V value){
        this.key=key;
        this.value=value;
    }
}

class DlinkedList<K,V>{
    Node1<K,V> head;
    Node1<K,V> tail;

    DlinkedList(){
        head = new Node1<>(null,null);
        tail = new Node1<>(null,null);
        head.next = tail;
        tail.prev = head;

    }

    void addToHead(Node1<K,V> Node1){
        head.next.prev = Node1;
        Node1.next = head.next;
        head.next = Node1;
        Node1.prev = head;
        System.out.println("Head val is "+head.value);
    }

    void moveToHead(Node1<K,V> Node1){
        removeNode1(Node1);
        addToHead(Node1);
        System.out.println("Head val is "+head.value);

    }
    void removeNode1(Node1<K,V> Node1){
        Node1.prev.next = Node1.next;
        Node1.next.prev = Node1.prev;
    }

     Node1<K,V> removeTail(){
        if(tail.prev == head){
            return null;
        }
        Node1<K,V> prev = tail.prev;
        removeNode1(prev);

     return prev;
    }
}
