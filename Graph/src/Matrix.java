import java.util.*;

public class Matrix {
    static class Pair{
        int first;
        int second;
        int third;

        Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

//        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0){
                    dist[i][j] = 0;
                    q.add(new Pair(i,j,0));
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while (!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
//            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nr = row + delRow[i];
                int nc = col + delCol[i];

                if (nr>=0 && nr<n && nc>=0 && nc<m && dist[nr][nc]>steps+1){
                    dist[nr][nc] = steps+1;
                    q.add(new Pair(nr,nc,steps+1));
                }
            }
        }
        return dist;
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

            int[][] res = updateMatrix(grid);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
