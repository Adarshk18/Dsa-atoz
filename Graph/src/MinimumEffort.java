import java.util.*;

public class MinimumEffort {
    static class Tuple{
        int diff; int row; int col;

        Tuple(int diff, int row , int col){
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
    public static int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.diff-y.diff);
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while (!pq.isEmpty()){
            Tuple it = pq.poll();
            int diff = it.diff;
            int row = it.row;
            int col = it.col;

            if (row==n-1 && col==n-1) return diff;
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr>=0 && nc>=0 && nr<n && nc<m){
                    int newEffort = Math.max(Math.abs(heights[row][col]-heights[nr][nc]),diff);
                    if (newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.add(new Tuple(newEffort,nr,nc));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();

            int[][] heights = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    heights[i][j] = in.nextInt();
                }
            }

            int res = minimumEffortPath(heights);
            System.out.println(res);
        }
    }
}
