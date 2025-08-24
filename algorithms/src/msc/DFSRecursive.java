package msc;

import java.util.*;

public class DFSRecursive {
    private Map<Integer, List<Integer>> adjList;

    public DFSRecursive() {
        adjList = new HashMap<>();
    }

    // Adds an edge to the graph
    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For undirected graph
    }

    // Recursive DFS helper function
    private void dfsRecursive(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.println(node);  // Process the node

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // DFS function that initializes the visited set and starts the recursive DFS
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    public static void main(String[] args) {
        DFSRecursive graph = new DFSRecursive();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("DFS starting from node 2:");
        graph.dfs(2);
    }
}
