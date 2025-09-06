import java.util.*;

public class Provinces {

    public static void dfs(int node, int[][] adj, boolean[] vis){
        vis[node] = true;
        for(int i=0; i<adj.length; i++){
            if(adj[node][i] == 1 && !vis[i]){
                dfs(i,adj,vis);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
       int V = isConnected.length;
       boolean[] vis = new boolean[V];
       int cnt=0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                cnt++;
                dfs(i,isConnected,vis);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0) {
            int n = in.nextInt();
            int m = in.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();

                adj.get(u).add(v);
                adj.get(v).add(u);
            }


        }
    }
}
