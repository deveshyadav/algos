package monthmarathon.leetcode.dfs;

import java.util.*;

/**
 * Problem: Detect Cycle in Graph (Directed & Undirected)
 * Goal: Determine whether a graph contains a cycle.
 *
 * 1) Undirected Graph (DFS Approach)
 * - Build adjacency list for the graph
 * - Use DFS to traverse; pass the parent node to avoid false cycle detection
 * - If we reach a visited node that is not the parent → cycle exists
 * Time Complexity: O(V + E) — Each vertex and edge visited once
 * Space Complexity: O(V) — visited[] + recursion stack (worst case)
 *
 * 2) Undirected Graph (Union-Find / Disjoint Set)
 * - Initially, every vertex is its own parent
 * - For each edge, find parents of both vertices:
 *   - If parents are the same → they’re already connected → cycle exists
 *   - Otherwise, union the two sets
 * Time Complexity: O(E * α(V)) ≈ O(E) — α is inverse Ackermann (almost constant)
 * Space Complexity: O(V) — parent[] array
 *
 * 3) Directed Graph (DFS + Recursion Stack)
 * - Use two arrays:
 *   - visited[]: Marks if a node has been processed
 *   - recStack[]: Tracks the current DFS path
 * - If during DFS we reach a node already in recStack → cycle exists (back edge)
 * Time Complexity: O(V + E) — Each vertex and edge visited once
 * Space Complexity: O(V) — visited[], recStack[], recursion stack
 *
 * Alternative for Directed Graph:
 * - Kahn’s Algorithm (BFS Topological Sort)
 *   - If after processing, not all nodes are included in topological order → cycle exists
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
public class GraphCycleDetection {

    public static void main(String[] args) {
        // ---------- Undirected Graph Example ----------
        int[][] undirectedEdges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {2, 4} // forms a cycle
        };
        System.out.println("Undirected (DFS): " + hasCycleUndirectedDFS(5, undirectedEdges));


        //#################################
        System.out.println("Undirected (Union-Find): " + hasCycleUndirectedUnionFind(5, undirectedEdges));
        //#################################

        // ---------- Directed Graph Example ----------
        int[][] directedEdges = {
                {0, 1}, {1, 2}, {2, 0} // forms a cycle
        };
        System.out.println("Directed (DFS): " + hasCycleDirectedDFS(3, directedEdges));
    }

    // ---------------- UNDIRECTED GRAPH: DFS ----------------
    public static boolean hasCycleUndirectedDFS(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfsUndirected(i, -1, graph, visited)) return true;
        }
        return false;
    }

    private static boolean dfsUndirected(int node, int parent, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        for (int nei : graph[node]) {
            if (!visited[nei]) {
                if (dfsUndirected(nei, node, graph, visited)) return true;
            } else if (nei != parent) {
                return true;
            }
        }
        return false;
    }


    // ---------------- DIRECTED GRAPH: DFS ----------------
    public static boolean hasCycleDirectedDFS(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) graph[e[0]].add(e[1]);

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfsDirected(i, graph, visited, recStack)) return true;
        }
        return false;
    }

    private static boolean dfsDirected(int node, List<Integer>[] graph, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int nei : graph[node]) {
            if (!visited[nei] && dfsDirected(nei, graph, visited, recStack)) return true;
            else if (recStack[nei]) return true; // back edge → cycle
        }

        recStack[node] = false;
        return false;
    }



    // ---------------- UNDIRECTED GRAPH: UNION-FIND ----------------
    public static boolean hasCycleUndirectedUnionFind(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] e : edges) {
            int p1 = find(parent, e[0]);
            int p2 = find(parent, e[1]);
            if (p1 == p2) return true; // same set → cycle
            parent[p1] = p2;
        }
        return false;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}

