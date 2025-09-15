import java.util.*;

public class ShortestPathDAG {

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void topoSort(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        vis[node] = 1;
        for (Pair p : adj.get(node)) {
            if (vis[p.first] == 0) {
                topoSort(p.first, vis, st, adj);
            }
        }
        st.push(node);
    }

    public static int[] shortestPath(int N, int M, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 1: Topo sort
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, vis, st, adj);
            }
        }

        // Step 2: Distances
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // Step 3: Relax in topo order
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != (int) 1e9) {
                for (Pair p : adj.get(node)) {
                    int v = p.first, wt = p.second;
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Step 4: Convert unreachable → -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();

            int[][] edges = new int[M][3];   // ✅ fixed
            for (int i = 0; i < M; i++) {
                edges[i][0] = in.nextInt();
                edges[i][1] = in.nextInt();
                edges[i][2] = in.nextInt();
            }

            int src = in.nextInt();
            int[] res = shortestPath(N, M, edges, src);
            for (int x : res) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
