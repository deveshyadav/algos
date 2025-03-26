package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(arr[i],'-');
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        solve(arr, res, 0);
        for(ArrayList<String> s:res){
            s.forEach(System.out::println);
            System.out.println();
        }
    }

    static void solve(char[][] arr, ArrayList<ArrayList<String>> res, int row){
        int n = arr.length;
        if(row == n){
           ArrayList<String> temp = new ArrayList<>();
           for(char[] cr:arr){
               temp.add(Arrays.toString(cr));
           }
           res.add(temp);
           return;
        }
        for(int col=0;col<n;col++){
            if(isValid(arr, row ,col, n)){
                arr[row][col] = 'q';
                solve(arr, res, row+1);
                arr[row][col] = '-';
            }
        }

    }

    static boolean isValid(char[][] arr, int row, int col, int n){
        for(int k=0;k<n;k++){
            if(arr[row][k] == 'q') return false;
            if(arr[k][col] == 'q') return false;
        }
        for(int i = row ,j = col;i>=0 && j>=0;i--,j--){
            if(arr[i][j] == 'q') return false;
        }
        for(int i = row ,j=col;i>=0 && j<n;i--,j++){
            if(arr[i][j] == 'q') return false;
        }
        for(int i = row ,j=col;i<n && j>=0;i++,j--){
            if(arr[i][j] == 'q') return false;
        }
        for(int i = row ,j=col;i<n && j<n;i++,j++){
            if(arr[i][j] == 'q') return false;
        }
        return true;
    }
    //2,4
    //1,3 -> 3,5
}


