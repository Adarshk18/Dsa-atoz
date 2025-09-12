import java.util.*;

public class CourseScheduleII {

    private static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis)) return true;
            } else if (pathVis[it] == 1) {
                return true; // cycle found
            }
        }

        pathVis[node] = 0; // backtrack
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int V = in.nextInt();
            int E = in.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

            for (int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj.get(u).add(v);
            }

            if (isCycle(V, adj)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        in.close();
    }
}
