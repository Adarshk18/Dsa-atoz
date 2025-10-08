import java.util.*;

public class ShortestRoutesII {
    static final long INF = (long)1e15;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();

            long[][] dist = new long[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(dist[i],INF);
                dist[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                int a = in.nextInt(), b = in.nextInt();
                long c = in.nextLong();

                dist[a][b] = Math.min(dist[a][b],c);
                dist[b][a] = Math.min(dist[b][a],c);

            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (dist[i][k]+ dist[k][j] < dist[i][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; i++) {
                int a = in.nextInt(), b= in.nextInt();
                long ans = dist[a][b];
                sb.append(ans ==INF ? -1: ans).append("\n");
            }
            System.out.print(sb);
        }
    }
}
