import java.util.*;

public class RottenOranges {

    static class Pair {
        int row, col, time;
        Pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }

    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }


        int time = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int rottenCount = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            time = Math.max(time, p.time);

            for (int k = 0; k < 4; k++) {
                int nr = p.row + dRow[k];
                int nc = p.col + dCol[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    q.add(new Pair(nr, nc, p.time + 1));
                    rottenCount++;
                }
            }
        }


        if (rottenCount != fresh) return -1;
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int result = orangesRotting(grid);
            System.out.println(result);
        }
        sc.close();
    }
}
