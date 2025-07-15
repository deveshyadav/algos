package monthmarathon.leetcode.dfs;

/**
 * Problem: Max Area of Island (LeetCode 695)
 * Goal: Find the largest connected area (4-directionally) of 1s in a grid
 *
 * Approach: DFS traversal
 * - Iterate through each cell
 * - If cell = 1 and not visited, perform DFS to count connected 1s
 * - Track maximum area
 *
 * DFS Logic:
 * - Mark current cell as visited
 * - Explore neighbors in 4 directions (up, down, left, right)
 * - Sum areas from all valid neighbors recursively
 *
 * Time Complexity: O(m * n) — Each cell visited once
 * Space Complexity: O(m * n) — Visited matrix + recursion stack (worst case)
 *
 * Alternative Approach: BFS traversal (queue-based)
 * Time Complexity: O(m * n) — Same as DFS
 * Space Complexity: O(min(m, n)) to O(m * n) — Queue size in worst case
 *
 * Another Alternative: In-place modification (mark visited cells as 0 instead of separate visited matrix)
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) extra (apart from recursion stack)
 */
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
