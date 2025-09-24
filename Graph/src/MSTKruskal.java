import java.util.*;

class Disjoint {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    private int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int root = findParent(parent.get(node));
        parent.set(node,root);
        return root;
    }

    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge implements Comparable<Edge> {

    int src, dest, wt;

    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    public int compareTo(Edge compareEdge) {
        return this.wt - compareEdge.wt;
    }
}

public class MSTKruskal {

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);

                if (i < adjNode) {
                    edges.add(new Edge(i, adjNode, wt));
                }
            }
        }

        Disjoint ds = new Disjoint(V);
        Collections.sort(edges);
        int wtsum =0;

        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).wt;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if (!ds.find(u,v)){
                wtsum += wt;
                ds.unionBySize(u,v);
            }
        }
        return wtsum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int V =in.nextInt();
            int E = in.nextInt();

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int wt = in.nextInt();

                adj.get(u).add(new ArrayList<>(Arrays.asList(v,wt)));
                adj.get(v).add(new ArrayList<>(Arrays.asList(u,wt)));
            }

            int sum = spanningTree(V,adj);
            System.out.println(sum);

        }
    }
}
