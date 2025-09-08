import java.util.*;

public class CycleDetectionBFS {

    static class Node{
        int first;
        int second;

        Node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static boolean checkCycle(int src, int V, List<List<Integer>> adj, boolean[] vis){
        vis[src] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src,-1));
        while (!q.isEmpty()){

            int node = q.poll().first;
            int parent = q.poll().second;

            for(Integer adjNode: adj.get(node)){
                if (!vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(new Node(adjNode,node));
                }else if (parent!=adjNode){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];


        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                if (checkCycle(i,V,adj,vis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            boolean res = isCycle(n,adj);
            if (res){
                System.out.println("true");
            }else{
                System.out.println("false");
            }

        }
    }
}
