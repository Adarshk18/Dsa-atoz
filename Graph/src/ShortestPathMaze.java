import java.util.*;

public class ShortestPathMaze {

    private static final int[][] directions = {
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}
    };
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        grid[0][0] =1;
        while (!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c=cell[1], dist=cell[2];

            if (r==n-1 && c==n-1) return dist;

            for(int[] d: ShortestPathMaze.directions){
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0){
                    q.add(new int[]{nr,nc,dist+1});
                    grid[nr][nc] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();

            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            int res = shortestPathBinaryMatrix(grid);
            System.out.println(res);
        }
    }
}
