import java.util.*;

public class DAGCycleDetectBFS {
    public static boolean checkCycle(int V, List<List<Integer>> adj) {
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

        int cnt=0;
        int i=0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();

            cnt++;

            for(int it: adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0) q.add(it);
            }
        }
        if (cnt==V) return false;
        return true;
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

            if (checkCycle(V,adj)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }

        }
        in.close();
    }
}
