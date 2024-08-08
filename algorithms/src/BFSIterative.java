import java.util.*;

public class BFSIterative {
    private Map<Integer, List<Integer>> adjList;

    public BFSIterative() {
        adjList = new HashMap<>();
    }

    // Adds an edge to the graph
    public void addEdge(int u, int v, boolean isDirected) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        if (!isDirected) {
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For undirected graph
        }
    }

    // BFS implementation
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node); // Process the node

            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSIterative graph = new BFSIterative();
        graph.addEdge(0, 1, false); // false for undirected
        graph.addEdge(0, 2, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 0, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 3, false);

        System.out.println("BFS starting from node 2:");
        graph.bfs(2);
    }
}
