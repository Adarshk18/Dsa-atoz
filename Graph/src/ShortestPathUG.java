import java.util.*;

public class ShortestPathUG {
    public static int[] shortestPath(int[][] edges, int N, int M, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            int node = q.poll();

            for (int it: adj.get(node)) {
                if (dist[node]+1 < dist[it]){
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i]==(int) 1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int N = in.nextInt();
            int M = in.nextInt();

            int[][] edges = new int[M][2];
            for (int i = 0; i < M; i++) {
                edges[i][0] = in.nextInt();
                edges[i][1] = in.nextInt();
            }

            int src = in.nextInt();

            int[] dist = shortestPath(edges,N,M,src);
            for (int i = 0; i < N; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println();
        }
    }
}
