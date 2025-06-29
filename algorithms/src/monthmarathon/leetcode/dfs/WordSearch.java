package monthmarathon.leetcode.dfs;

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
