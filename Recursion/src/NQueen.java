import java.util.*;


public class NQueen {
    
    public static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerD, int[] upperD){
        if (col == board.length){
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row]==0 && lowerD[row+col]==0 && upperD[board.length-1+col-row]==0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerD[row+col] = 1;
                upperD[board.length-1+col-row] = 1;
                solve(col+1,board,res,leftRow,lowerD,upperD);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerD[row+col] = 0;
                upperD[board.length-1+col-row] = 0;
            }
        }
    }
    
    
    public static List<String> construct(char[][] board){
        List<String> res= new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();
        int[] leftRow = new int[n];
        int[] lowerD = new int[2*n-1];
        int[] upperD = new int[2*n-1];
        solve(0,board,res,leftRow,lowerD,upperD);
        return res;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0){
            int N = in.nextInt();
            List<List<String>> queens = solveNQueens(N);
            int i=1;
            for(List<String> it: queens){
                System.out.println(i);
                for(String s: it){
                    System.out.print(s);
                }
                System.out.println();
                i += 1;
            }
        }
        in.close();
    }
}
