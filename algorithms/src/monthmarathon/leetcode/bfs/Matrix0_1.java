package monthmarathon.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix0_1 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0},{1},{1}};
        int[][] res = getNumberOfNodesFromSourceToDest(grid);
        for(int i=0;i<grid.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }

    private static int[][] getNumberOfNodesFromSourceToDest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    res[i][j]=0;
                    queue.add(new int[]{i,j});
                } else{
                    res[i][j]=-1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

            for(int[] d:dirs){
                int di = d[0]+x;
                int dj = d[1]+y;

                if(di>=0 && dj>=0 && di<m && dj<n && res[di][dj]==-1){
                    res[di][dj] = res[x][y] + 1;
                    queue.add(new int[]{di,dj});
                }
            }
        }

        return res;
    }
}
