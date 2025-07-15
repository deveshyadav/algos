package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Clone Graph (LeetCode 133)
 * Goal: Return a deep copy of an undirected connected graph, preserving all nodes and edges.
 *
 * Approach: DFS with HashMap
 * - Use a HashMap<Node, Node> to store original → cloned node mappings
 * - For each node:
 *   1. If already cloned, return from map (prevents cycles/infinite recursion)
 *   2. Otherwise, clone the current node and put it in map
 *   3. Recursively clone all neighbors and add to cloned.neighbors list
 *
 * Time Complexity: O(V + E) — Each node and edge is visited once
 * Space Complexity: O(V) — HashMap to store clones + recursion stack (worst case)
 *
 * Alternative: BFS Iterative Approach
 * - Use a queue to traverse nodes level by level
 * - Clone nodes when first seen and push into queue
 * - For each neighbor, either clone or fetch from map, then link to current clone
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
public class CloneGraph {

    static Map<Node, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Node node1= new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        Node node4= new Node(4);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);

        Node cloned = cloneGraph(node1);
        System.out.println(cloned);

    }

    private static Node cloneGraph(Node node1) {
        if(node1 ==null ) return null;

        if(map.containsKey(node1))
        {
            return map.get(node1);
        }

        Node cloned = new Node(node1.val);
        map.put(node1,cloned);
        List<Node> neig = node1.neighbors;
        for(Node n:neig){
            cloned.neighbors.add(cloneGraph(n));
        }
        return cloned;

    }


    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        @Override
        public String toString() {
            return STR."->\{val}->\{neighbors}";
        }


    }
}
