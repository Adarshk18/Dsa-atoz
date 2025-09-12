import java.util.*;

public class Bipartite {
    private static boolean DFS(int node, int col, int[] color, int[][] adj){
        color[node] = col;
        for (int it = 0; it < adj[node].length; it++) {
            if (adj[node][it] == 1) { // edge exists
                if (color[it] == -1) {
                    if(!DFS(it,1-col,color,adj)) return false;
                } else if (color[it] == col) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!DFS(i,0,color,graph)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            if (isBipartite(grid)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
