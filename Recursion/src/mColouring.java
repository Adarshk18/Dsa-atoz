import java.util.*;

public class mColouring {

    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C){
        int n = G.length;
        if (solve(i,G,color,n,C)) return true;
        return false;
    }

    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col){
        for(int it: G[node]){
            if (color[it]==col) return false;
        }
        return true;
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m){
        if (node==n){
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(node,G,color,n,i)){
                color[node] = i;
                if(solve(node+1,G,color,n,m)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while(t-->0){
            int N = in.nextInt();
            int M = in.nextInt();
            int C = in.nextInt();

            List<Integer>[] G = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                G[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                G[u].add(v);
                G[v].add(u);
            }

            int[] color = new int[N];
            boolean ans = graphColoring(G,color,0,C);
            System.out.println(ans ? "1": "0");
        }
    }
}
