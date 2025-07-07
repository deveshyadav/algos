package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
