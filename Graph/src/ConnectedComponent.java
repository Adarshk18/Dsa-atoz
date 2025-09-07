import java.util.*;

public class ConnectedComponent {

    public static void dfs(int nodes, List<List<Integer>> adj, boolean[] vis){
        vis[nodes] = true;
        for(Integer it: adj.get(nodes)){
            if (!vis[nodes]){
                dfs(nodes,adj,vis);
            }
        }
    }

    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        boolean[] vis = new boolean[V];
        int cmp =0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                cmp++;
                dfs(i,edges,vis);
            }
        }
        return cmp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            int V = in.nextInt();
            int E = in.nextInt();

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int res = findNumberOfComponent(V,adj);
            System.out.println(res);
        }
    }
}
