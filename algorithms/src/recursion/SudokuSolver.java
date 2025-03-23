package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SudokuSolver {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(8, 4, 9, 0, 0, 3, 5, 7, 0)),
                new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0)),
                new ArrayList<>(Arrays.asList(7, 0, 0, 0, 9, 0, 0, 8, 3)),
                new ArrayList<>(Arrays.asList(0, 0, 0, 9, 4, 6, 7, 0, 0)),
                new ArrayList<>(Arrays.asList(0, 8, 0, 0, 5, 0, 0, 4, 0)),
                new ArrayList<>(Arrays.asList(0, 0, 6, 8, 7, 2, 0, 0, 0)),
                new ArrayList<>(Arrays.asList(5, 7, 0, 0, 1, 0, 0, 0, 4)),
                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 0)),
                new ArrayList<>(Arrays.asList(0, 2, 1, 7, 0, 0, 8, 6, 5))
        ));

        int[][] arr = board.stream()
                .map(row-> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);


        boolean ans = solve(arr);
        board = Arrays.stream(arr)
                .map(row-> Arrays.stream(row).boxed()
                                .collect(Collectors.toCollection(ArrayList::new)))
                        .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Solved;" +ans);
        board.forEach(System.out::println);
    }

    static boolean isValid(int[][] board, int i, int j, int c){
        System.out.println("Check Valid");
        for(int k=0;k<9;k++){
            if(board[i][k] == c) return false;
            if(board[k][j] == c) return false;
            if(board[3*(i/3)+k/3][3*(j/3)+k%3] == c) return false;
        }
        System.out.println("Checked Valid");
        return true;
    }

    static boolean solve(int[][] board){
        System.out.println("Board start");
        for(int i=0;i<9;i++){
            System.out.println("First for");
            for(int j=0;j<9;j++){
                System.out.println("2nd for");
                if(board[i][j]==0){
                    for(int k=1;k<=9;k++){
                        System.out.println("3rd for");
                        if(isValid(board, i ,j ,k)){
                            System.out.println("Yes Valid");
                            board[i][j] = k;
                            if(solve(board)) return true;
                            else board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
