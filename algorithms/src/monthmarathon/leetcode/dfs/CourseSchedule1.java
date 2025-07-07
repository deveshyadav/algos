package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

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
                if (dfs(visited, rec, graph, i)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(boolean[] visited, boolean[] rec, List<Integer>[] graph, int node){

        if(rec[node]) return true;
        if(visited[node]) return false;

        visited[node]=true;
        rec[node]=true;

        for(int n:graph[node]){
            System.out.println("node: "+node + " n: "+n);
            if(dfs(visited,rec,graph,n)) return true;
        }

        rec[node] =false;
        return false;
    }
}
