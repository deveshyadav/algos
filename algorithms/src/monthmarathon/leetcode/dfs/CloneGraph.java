package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            return node1;
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
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
        @Override
        public String toString() {
            return "->" + val + "->" + neighbors;
        }


    }
}
