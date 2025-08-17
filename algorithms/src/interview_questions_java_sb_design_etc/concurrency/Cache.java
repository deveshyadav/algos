package interview_questions_java_sb_design_etc.concurrency;

import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {
    final int capacity;
    final Map<K,Node<K,V>> map;
    final DDL<K,V> ddl;


    Cache(int capacity){
        this.capacity=capacity;
        this.map =  new HashMap<>();
        this.ddl = new DDL<>();
    }

    public static void main(String[] args) {
        Cache<Integer,String> cache = new Cache<>(2);
        cache.put(1, "one");
        cache.put(2, "two");
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(3,"three");
        cache.put(4,"four");
        cache.map.entrySet().forEach(x-> System.out.println(x.getKey() + " ->"+x.getValue().value));

    }

    private V get(K key) {
        if(!map.containsKey(key)){
            return null;
        }
        Node<K,V> node = map.get(key);
        ddl.moveToHead(node);
        return node.value;
    }

    private void put(K key, V value) {
        Node<K,V> node = map.get(key);
        if(node==null){
            if(map.size()>2){
                Node<K,V> removedTail = ddl.removeTail();
                map.remove(removedTail.key);
            }
            Node<K,V> newNode = new Node<>(key,value);
            map.put(key,newNode);
            ddl.addToHead(newNode);
        } else{
            node.value=value;
            ddl.moveToHead(node);
        }

    }


}

class Node<K,V>{
    K key;
    V value;
    Node<K,V> prev;
    Node<K,V> next;

    Node(K key, V value){
        this.key=key;
        this.value=value;
    }
}

class DDL<K,V>{
    Node<K,V> head;
    Node<K,V> tail;
    DDL(){
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.prev = head;
    }
    public void addToHead(Node<K,V> node){
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
    }

    public void removeNode(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node<K,V> removeTail(){
        if(tail.prev == head){
            return null;
        }
        Node<K,V> tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }

    public void moveToHead(Node<K,V> node){
        removeNode(node);
        addToHead(node);
    }

}