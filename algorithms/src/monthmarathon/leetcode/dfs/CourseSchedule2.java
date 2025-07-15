package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Course Schedule II (LeetCode 210)
 * Goal: Return a possible order to finish all courses given prerequisites; return empty if impossible.
 *
 * Approach: DFS-based Topological Sort with Cycle Detection
 * - Build a graph: graph[from].add(to)
 * - Use two boolean arrays:
 *   1. visited[node]: Marks if node is already processed
 *   2. rec[node]: Recursion stack to detect cycles
 * - DFS Logic:
 *   1. If node already in rec → cycle → return true (no valid ordering)
 *   2. If node already visited → skip
 *   3. Mark visited and add to rec
 *   4. DFS to all neighbors; if any DFS finds a cycle → propagate true
 *   5. After processing, remove from rec and add node to result list (postorder)
 * - Reverse result list at the end → gives topological ordering
 *
 * Time Complexity: O(V + E) — Each node and edge visited once
 * Space Complexity: O(V) — visited[], rec[], and DFS recursion stack
 *
 * Alternative: Kahn’s Algorithm (BFS Topological Sort)
 * - Use in-degree array + queue to build ordering
 * - Time: O(V + E), Space: O(V)
 */
public class CourseSchedule2 {

    public static void main(String[] args) {
        int courses=2;
        int[][] arr = new int[][]{ {0, 1},
                {1,0}};
         int[] topology = getSequenceOfCourses(courses, arr);
        System.out.println(Arrays.toString(topology));
        //System.out.println(topology);
    }

    private static int[] getSequenceOfCourses(int courses, int[][] arr) {
        List<Integer>[] graph = new ArrayList[courses];

        for(int i=0;i<courses;i++) graph[i]=new ArrayList<>();

        for(int[] ar:arr){
            int to = ar[0];
            int from = ar[1];
            graph[from].add(to);
        }

        boolean[] visited = new boolean[courses];
        boolean[] rec = new boolean[courses];

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<courses;i++){
            if(!visited[i]) {
                 if(dfsHasCycle(visited, rec, graph, i, res)) return new int[0];
            }
        }

        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean dfsHasCycle(boolean[] visited, boolean[] rec, List<Integer>[] graph, int node, List<Integer> res){
        if(rec[node]) return true;
        if(visited[node]) return false;

        visited[node]=true;
        rec[node]=true;

        for(Integer i:graph[node]){
            if(dfsHasCycle(visited,rec,graph,i, res)) return true;
        }

        rec[node]=false;
        res.add(node);
        return false;
    }
}
