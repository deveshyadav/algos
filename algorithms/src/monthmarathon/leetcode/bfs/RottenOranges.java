package monthmarathon.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1,},{1,1,0},{0,1,1}};
        int mins = getMinutesToRot(grid);
        System.out.println("Oranges rot in minutes: "+mins);
    }

    private static int getMinutesToRot(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> qu = new LinkedList<>();
        int fresh = 0;
        int mins =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    qu.offer(new int[]{i,j});
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        while(!qu.isEmpty()){
            int size = qu.size();
            boolean rotten =false;
            for(int i=0;i<size;i++){
                int[] curr = qu.poll();
                for(int[] d: dirs){
                    int dm = d[0]+curr[0];
                    int dn = d[1]+curr[1];

                    if(dm>=0 && dn>=0 && dm<m && dn<n && grid[dm][dn]==1){
                        grid[dm][dn]=2;
                        rotten=true;
                        fresh--;
                        qu.offer(new int[]{dm,dn});
                    }
                }
            }
            if(rotten){
                mins++;
            }
        }

        return fresh != 0 ? -1:mins;
    }
}
