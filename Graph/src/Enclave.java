import java.util.*;

public class Enclave {

    static class Pair{
        int first; int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0 || j==0 || i==n-1 || j==m-1){
                    if (grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while (!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if (nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = 1;
                }
            }
        }
        int cnt =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }


            int cnt = numEnclaves(grid);
            System.out.println(cnt);
        }
    }
}
