package monthmarathon.leetcode.bfs;

import java.util.*;

public class ShortPathInBinMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {1,0,1,0}};
        int path = getShortPath(grid);
        System.out.println(path);
    }

    private static int getShortPath(int[][] grid) {
        int n=grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][][] parents = new int[n][n][];
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{0,0});
        parents[0][0] = new int[]{-1,-1};
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] cur  = queue.poll();
            if(cur[0]==n-1 && cur[1]==n-1){
                return path(parents,n-1,n-1);
            }

           for(int[] d:dirs){
               int dm = d[0]+cur[0];
               int dn = d[1]+cur[1];
               if(dm>=0 && dn>=0 && dm<n && dn<n && !visited[dm][dn] && grid[dm][dn] ==0){
                   visited[dm][dn]=true;
                   queue.offer(new int[]{dm,dn});
                   parents[dm][dn] = new int[]{cur[0],cur[1]};
               }
           }
        }

        return -1;



    }

    private static int path(int[][][] parents, int x, int y) {
        List<int[]> path = new ArrayList<>();
        while(x!=-1 && y!=-1){
            path.add(new int[]{x,y});
            int[] cur = parents[x][y];
            x = cur[0];
            y = cur[1];
        }
        return path.size();
    }
}
