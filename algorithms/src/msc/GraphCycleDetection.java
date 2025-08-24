package msc;

import java.util.*;

public class GraphCycleDetection {
    //private final int vertices; This can be used and no source destination mapping is
    // required if vertices are sequential. Instead internalVertexId is used which is increased on each
    // new non-sequential vertex is mapped
    private final Map<Integer, LinkedList<Integer>> adjList;
    private final Map<Integer, Integer> vertexMap; // Mapping actual vertex IDs to internal IDs
    private int internalVertexId;

    public GraphCycleDetection(int vertices) {
        //this.vertices = vertices;
        this.adjList = new HashMap<>();
        this.vertexMap = new HashMap<>();
        this.internalVertexId = 0;
    }

    public void addEdge(int source, int destination) {
        source = mapVertex(source);
        destination = mapVertex(destination);
        adjList.putIfAbsent(source, new LinkedList<>());
        adjList.get(source).add(destination);
    }

    private int mapVertex(int vertex) {
        return vertexMap.computeIfAbsent(vertex, k -> internalVertexId++);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[internalVertexId];
        boolean[] recursionStack = new boolean[internalVertexId];

        for (int i = 0; i < internalVertexId; i++) {
            if (detectCycle(i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycle(int node, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        recursionStack[node] = true;

        LinkedList<Integer> neighbors = adjList.get(node);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                if (detectCycle(neighbor, visited, recursionStack)) {
                    return true;
                }
            }
        }

        recursionStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        GraphCycleDetection graph = new GraphCycleDetection(5);
        graph.addEdge(100, 200);
        graph.addEdge(200, 300);
        graph.addEdge(300, 100);
        graph.addEdge(400, 500);

        if (graph.hasCycle()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does not contain cycle");
        }
    }
}
