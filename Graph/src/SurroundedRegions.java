import java.util.*;

public class SurroundedRegions {

    public static void dfs(int row, int col, int[][] vis, char[][] mat, int[] delRow, int[] delCol){
        vis[row][col] = 1;
        int n= mat.length;
        int m = mat[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if (nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && mat[nr][nc]=='0'){
                dfs(nr,nc,vis,mat,delRow,delCol);
            }
        }
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int[][] vis = new int[n][m];

        //first row and last row
        for (int j = 0; j < m; j++) {
            //first row
            if (vis[0][j]==0 && board[0][j]=='0'){
                dfs(0,j,vis,board,delRow,delCol);
            }

            //last row
            if (vis[n-1][j]==0 && board[n-1][j]=='0'){
                dfs(n-1,j,vis,board,delRow,delCol);
            }
        }

        //first col and last col
        for (int i = 0; i < n; i++) {
            //first col
            if (vis[i][0]==0 && board[i][0]=='0'){
                dfs(i,0,vis,board,delRow,delCol);
            }

            //last col
            if (vis[i][m-1]==0 && board[i][m-1]=='0'){
                dfs(i,m-1,vis,board,delRow,delCol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && board[i][j]=='0'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.next().charAt(0);
                }
            }

            solve(grid);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
