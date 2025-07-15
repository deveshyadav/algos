package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Number of Islands (LeetCode 200)
 * Goal: Count the number of connected groups of 1s (islands) in a 2D grid
 *
 * Approach: DFS Traversal (Building a Forest of TreeNodes)
 * - Iterate over all cells in the grid
 * - If cell = 1 and not visited:
 *   1. Perform DFS to traverse the entire island
 *   2. Build a TreeNode structure where each node represents a grid cell
 *   3. Add the root of this DFS tree to a forest list
 * - Finally, return forest.size() (total islands)
 *
 * DFS Logic:
 * - Mark current cell as visited
 * - Explore 4-directional neighbors (up, down, left, right)
 * - For every valid neighbor, recursively call DFS and add it as a child in the current TreeNode
 *
 * Time Complexity: O(m * n) — Every cell is visited once
 * Space Complexity: O(m * n)
 * - visited matrix + DFS recursion stack (in worst case, entire grid is 1s)
 * - Additional space to store TreeNode forest (O(m * n))
 *
 * Alternative Approaches:
 * 1. In-place DFS (modifies grid instead of using visited) → O(1) extra space apart from recursion stack
 * 2. BFS using a queue → same time complexity, iterative, avoids deep recursion
 * 3. Union-Find (Disjoint Set) → Efficient for very large grids; O(m * n * α(m*n)), where α is inverse Ackermann
 *
 * Note:
 * Building the forest (TreeNode representation) is extra; not needed for simple island counting.
 * Standard solutions just increment a counter per DFS/BFS call.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,1}
        };

        //List<TreeNode> forest = buildForest(grid);
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        List<TreeNode> forests = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    TreeNode root = dfs(i,j,grid);
                    forests.add(root);
                }
            }
        }
        return forests.size();
    }

    private static TreeNode dfs(int i, int j, char[][] grid) {
        TreeNode root = new TreeNode(i,j);
        grid[i][j]=0; // Marked 0 to be considered visited
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m=grid.length;
        int n=grid[0].length;

        for(int[] d:dirs){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && grid[ni][nj]==1){
                root.children.add(dfs(ni,nj,grid));
            }
        }
        return root;
    }

    static class TreeNode{
        int x;
        int y;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    private static List<TreeNode> buildForest(char[][] grid) {
        List<TreeNode> forests = new ArrayList<>();
        int m = grid.length;;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    TreeNode root = dfs(i,j,grid);
                    forests.add(root);
                }
            }
        }
        return forests;
    }

}
