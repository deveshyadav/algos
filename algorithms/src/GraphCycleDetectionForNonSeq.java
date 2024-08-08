 import java.util.*;

 public class GraphCycleDetectionForNonSeq{
    private final int vertices;
    private final LinkedList<Integer>[] adjList;

    public GraphCycleDetectionForNonSeq(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (detectCycle(i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycle(int node, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) {
            return true; // Node is already in the recursion stack, cycle detected
        }
        if (visited[node]) {
            return false; // Node has already been visited, no cycle from this node
        }

        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : adjList[node]) {
            if (detectCycle(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[node] = false; // Remove the node from the recursion stack
        return false;
    }

    public static void main(String[] args) {
        GraphCycleDetection graph = new GraphCycleDetection(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); // This edge creates a cycle

        if (graph.hasCycle()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}

