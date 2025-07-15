package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Course Schedule (LeetCode 207)
 * Goal: Determine if it is possible to finish all courses given prerequisites, i.e., check if the directed graph has a cycle.
 *
 * Approach: DFS Cycle Detection in Directed Graph
 * - Build a graph: graph[from].add(to)
 * - Use two boolean arrays:
 *   1. visited[node]: Marks if the node has been completely processed
 *   2. rec[node]: Recursion stack; tracks the current DFS path to detect back edges
 * - DFS Logic:
 *   1. If node already in rec → cycle exists → return true
 *   2. If node already visited → no need to reprocess → return false
 *   3. Mark visited and add to rec
 *   4. DFS to all neighbors; if any DFS returns true → cycle found
 *   5. After processing, remove from rec (rec[node] = false)
 *
 * Time Complexity: O(V + E) — Each node and edge visited once
 * Space Complexity: O(V) — visited[], rec[], and DFS recursion stack
 *
 * Alternative Approach: Kahn’s Algorithm (Topological Sort)
 * - Count in-degrees for each node
 * - Push nodes with in-degree 0 into a queue, reduce in-degree of neighbors
 * - If processed nodes = total courses → possible to finish (no cycle)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) — in-degree array and queue
 */
public class CourseSchedule1 {
    public static void main(String[] args) {
        int[][] pre = new int[][]{{0,1},{0,2},{1,3}};
        int courses = 4;
        System.out.println("Possible: " + canFinish(courses, pre));
    }

    private static boolean canFinish(int courses, int[][] pre) {
        List<Integer>[] graph = new ArrayList[courses];
        for(int i = 0; i< courses; i++) graph[i] = new ArrayList<>();
        for(int[] ar: pre){
            int to = ar[0];
            int from = ar[1];
            graph[from].add(to);
        }

        boolean[] visited = new boolean[courses];
        boolean[] rec = new boolean[courses];
        for(int i = 0; i< courses; i++){
            if(!visited[i]) {
                if (dfsHasCycle(visited, rec, graph, i)) return false;
            }
        }
        return true;
    }

    private static boolean dfsHasCycle(boolean[] visited, boolean[] rec, List<Integer>[] graph, int node){

        if(rec[node]) return true;
        if(visited[node]) return false;

        visited[node]=true;
        rec[node]=true;

        for(int n:graph[node]){
            System.out.println("node: "+node + " n: "+n);
            if(dfsHasCycle(visited,rec,graph,n)) return true;
        }

        rec[node] =false;
        return false;
    }
}
