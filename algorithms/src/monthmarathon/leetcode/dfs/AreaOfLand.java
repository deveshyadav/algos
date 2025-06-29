package monthmarathon.leetcode.dfs;

public class AreaOfLand {
    static int maxA =0;
    public static void main(String[] args) {
        int[][] arr = new int[][]
                {       {1,1,1,1,0},
                        {1,0,0,0,1},
                        {0,0,1,1,1},
                        {0,0,1,1,1},
                        {1,1,0,1,1},

                } ;
        int maxArea = getArea(arr);
        System.out.println("Maxarea:-"+maxArea);
    }

    private static int getArea(int[][] arr) {
        int m = arr.length;
        int n= arr[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && arr[i][j]==1) {
                    int area = dfs(i, j, arr, visited);
                    maxA = Math.max(maxA,area);
                }
            }
        }
        return maxA;
    }

    private static int dfs(int i, int j, int[][] arr, boolean[][] visited){
        int area = 1;
        int m = arr.length;
        int n = arr[0].length;
        visited[i][j]=true;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] d:dirs){
            int ni = i+d[0];
            int nj= j+d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj] && arr[ni][nj]==1){
                area = area + dfs(ni,nj,arr,visited);
            }
        }
        return area;
    }

}
