package monthmarathon.leetcode.dfs;

/**
 * Problem: Word Search (LeetCode 79)
 * Goal: Check if a given word exists in the 2D grid by sequentially connecting adjacent cells (horizontally or vertically).
 * Each cell can be used only once in a path.
 *
 * Approach: DFS + Backtracking
 * 1. Iterate through every cell in the grid
 * 2. If the first character matches, start DFS search
 * 3. DFS:
 *    - Base case: if index == word length → word found → return true
 *    - If out of bounds, visited, or character mismatch → return false
 *    - Mark cell as visited
 *    - Explore 4 directions (up, down, left, right)
 *    - Backtrack: unmark visited before returning (important to reuse for other paths)
 * 4. If any DFS returns true → word exists
 *
 * Time Complexity: O(m * n * 4^L)
 * - m × n grid cells; at each step up to 4 directions
 * - L = length of the word (worst case explores 4^L paths)
 *
 * Space Complexity: O(L)
 * - Recursion depth proportional to word length
 * - visited[][] can be reused, so O(m * n) auxiliary space but not increasing with recursion depth
 *
 * Alternative Approach:
 * - Modify the grid in-place (mark as ‘#’ instead of using visited array) → O(1) extra space apart from recursion stack
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String s = "SEE";
        boolean res = wordSearch(arr, s);

        System.out.println("Word existence: "+res);

    }

    private static boolean wordSearch(char[][] arr, String s) {
        int m = arr.length;
        int n = arr[0].length;
        int index = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == s.charAt(0)){
                     if(dfs(i,j,visited,arr,s, index)) return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, boolean[][] visited, char[][] arr, String s, int index){
        if(index == s.length()) return true;
        int[][] dirs = new int[][]{{0,1}, {1,0},{0,-1},{-1,0}};
        int m = arr.length;
        int n = arr[0].length;
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || arr[i][j]!=s.charAt(index)){
            return false;
        }

        visited[i][j]=true;

        for(int[] d:dirs){
            int di = i+d[0];
            int dj = j+d[1];
            if(dfs(di,dj,visited,arr,s, index+1)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }


}
