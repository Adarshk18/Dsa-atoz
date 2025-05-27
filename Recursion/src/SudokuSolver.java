import java.util.*;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board){
        int[] cell = findEmptyCell(board);
        if (cell == null){
            return true;
        }

        int row = cell[0];
        int col = cell[1];

        for (char c = '1'; c < '9'; c++) {
            if (isValid(board,row,col,c)){
                board[row][col] = c;
                if (solve(board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    private static int[] findEmptyCell(char[][] board){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col]=='.') return new int[]{row,col};
            }
        }
        return null;
    }

    private static boolean isValid(char[][] board, int row , int col, char c){
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c || board[row][i] == c || board[3*(row/3) + i/3][3*(col/3) + i%3] == c){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while(t-->0){
            char[][] board = new char[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int num = in.nextInt();
                    board[i][j] = (num==0) ? '.' : (char)(num+'0');
                }
            }
            solveSudoku(board);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
