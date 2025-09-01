package testing;

import java.util.HashMap;
import java.util.Map;

public class TestingLfuCache<K, V> {
    int capacity;
    int minFrq;
    Map<K, Node<K, V>> keyNodeMap;
    Map<Integer, DLL<K, V>> freqMap;

    TestingLfuCache(int capacity) {
        this.capacity = capacity;
        this.minFrq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public V get(K key) {
        if (!keyNodeMap.containsKey(key)) return null;
        Node<K, V> node = keyNodeMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(K key, V val) {
        if (capacity == 0) return;

        if (keyNodeMap.containsKey(key)) {
            Node<K, V> node = keyNodeMap.get(key);
            node.val = val;
            updateFreq(node);
            return;
        }

        if (keyNodeMap.size() == capacity) {
            DLL<K, V> list = freqMap.get(minFrq);
            Node<K, V> lfuNode = list.removeTail();
            keyNodeMap.remove(lfuNode.key);
            System.out.println("Evicted LFU: " + lfuNode.key + " with freq " + lfuNode.freq);
        }

        Node<K, V> newNode = new Node<>(key, val);
        keyNodeMap.put(key, newNode);
        freqMap.computeIfAbsent(1, f -> new DLL<>()).addToHead(newNode);
        minFrq = 1;
        printCache("Put " + key + " = " + val);
    }

    private void updateFreq(Node<K, V> node) {
        int freq = node.freq;
        DLL<K, V> oldList = freqMap.get(freq);
        oldList.remove(node);

        if (freq == minFrq && oldList.isEmpty()) {
            minFrq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new DLL<>()).addToHead(node);
        printCache("Updated freq of " + node.key + " to " + node.freq);
    }

    private void printCache(String operation) {
        System.out.println("After: " + operation);
        for (Map.Entry<K, Node<K, V>> entry : keyNodeMap.entrySet()) {
            Node<K, V> node = entry.getValue();
            System.out.println("Key: " + node.key + ", Value: " + node.val + ", Freq: " + node.freq);
        }
        System.out.println("----");
    }

    public static void main(String[] args) {
        TestingLfuCache<Integer, String> cache = new TestingLfuCache<>(5);
        cache.put(1, "one1");
        cache.put(2, "one2");
        cache.put(3, "one3");
        cache.put(4, "one4");
        cache.put(5, "one5");
        cache.get(3);
        cache.get(2);
        cache.get(3);
        cache.put(6, "one6"); // eviction will happen here
    }
}

class Node<K, V> {
    int freq;
    K key;
    V val;
    Node<K, V> next;
    Node<K, V> prev;

    Node(K key, V val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLL<K, V> {
    Node<K, V> head;
    Node<K, V> tail;

    DLL() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node<K, V> removeTail() {
        if (isEmpty()) return null;
        Node<K, V> node = tail.prev;
        remove(node);
        return node;
    }
}
