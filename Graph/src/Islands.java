import java.util.*;

public class Islands {

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void bfs(int ro, int co, int[][] vis, char[][] grid){
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nr = row + delRow;
                    int nc = col + delCol;

                    if (nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]=='1'){
                        vis[nr][nc] = 1;
                        q.add(new Pair(nr,nc));

                    }
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int cnt =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,vis,grid);
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

            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String row = in.next();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = row.charAt(j);
                }
            }

            int cnt = numIslands(grid);
            System.out.println(cnt);

        }
    }
}
