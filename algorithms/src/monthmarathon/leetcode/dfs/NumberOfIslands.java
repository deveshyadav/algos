package monthmarathon.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };

        //List<TreeNode> forest = buildForest(grid);
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        List<TreeNode> forests = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    TreeNode root = dfs(i,j,grid, visited);
                    forests.add(root);
                }
            }
        }
        return forests.size();
    }

    private static void printTree(TreeNode node, String indent) {
        if (node == null) return;
        System.out.println(indent + "(" + node.x + "," + node.y + ")");
        for (TreeNode child : node.children) {
            printTree(child, indent + "  ");
        }
    }

    private static List<TreeNode> buildForest(char[][] grid) {
        List<TreeNode> forests = new ArrayList<>();
        int m = grid.length;;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    TreeNode root = dfs(i,j,grid, visited);
                    forests.add(root);
                }
            }
        }
        return forests;
    }

    private static TreeNode dfs(int i, int j, char[][] grid, boolean[][] visited) {
        TreeNode root = new TreeNode(i,j);
        visited[i][j]=true;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m=grid.length;
        int n=grid[0].length;

        for(int[] d:dirs){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj] && grid[ni][nj]==1){
                root.children.add(dfs(ni,nj,grid,visited));
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


}
