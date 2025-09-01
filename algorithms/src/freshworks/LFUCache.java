package freshworks;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private final int capacity;
    private int minFreq = 0;
    private final Map<Integer, Node> nodes = new HashMap<>();
    private final Map<Integer, DList> freq = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0) return -1;
        Node n = nodes.get(key);
        if (n == null) return -1;
        touch(n); // bump frequency and move node
        return n.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node n = nodes.get(key);

        if (n != null) { // update existing
            n.val = value;
            touch(n);
            return;
        }

        if (nodes.size() == capacity) { // evict LFU
            DList dl = freq.get(minFreq);
            Node evict = dl.removeLast();
            nodes.remove(evict.key);
        }

        Node nn = new Node(key, value);
        nodes.put(key, nn);
        freq.computeIfAbsent(1, k -> new DList()).addFirst(nn);
        minFreq = 1; // new key always has freq=1
    }

    private void touch(Node n) {
        DList cur = freq.get(n.f);

        cur.remove(n);
        if (cur.size == 0 && n.f == minFreq) minFreq++;
        n.f++;
        freq.computeIfAbsent(n.f, k -> new DList()).addFirst(n);
    }

    private static class Node {
        int key, val, f = 1;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; }
    }

    private static class DList {
        Node head = new Node(-1, -1), tail = new Node(-1, -1);
        int size = 0;
        DList() { head.next = tail; tail.prev = head; }

        void addFirst(Node n) {
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
            size++;
        }

        void remove(Node n) {
            n.prev.next = n.next; n.next.prev = n.prev;
            n.prev = n.next = null;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node n = tail.prev;
            remove(n);
            return n;
        }
    }

    // Example driver
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 10); // {1:10,f=1}
        cache.put(2, 20); // {1:10,f=1},{2:20,f=1}
        System.out.println(cache.get(1)); // 10 (f=2 now)
        cache.put(3, 30); // evict key=2 (LFU)
        System.out.println(cache.get(2)); // -1 (evicted)
        System.out.println(cache.get(3)); // 30
    }
}