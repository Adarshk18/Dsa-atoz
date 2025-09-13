import java.util.*;

public class KahnAlgo {
    public static int[] topoSort(int V, List<List<Integer>> adj) {
        int[]  indegree = new int[V];
        for (int i = 0; i < V; i++) {
           for(int it: adj.get(i)){
               indegree[it]++;
           }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i]==0) q.add(i);
        }

        int[] topo = new int[V];
        int i=0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();

            topo[i++] = node;

            for(int it: adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0) q.add(it);
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int V = in.nextInt();
            int E = in.nextInt();

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

            for (int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj.get(u).add(v);
            }

            int[] topo = topoSort(V,adj);
            System.out.println(Arrays.toString(topo));
        }
        in.close();
    }
}
