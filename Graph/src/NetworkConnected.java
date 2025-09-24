import java.util.*;

class Disjoint1 {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint1(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    private int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int root = findParent(parent.get(node));
        parent.set(node, root); // path compression
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

public class NetworkConnected {

    public static int makeConnected(int n, int[][] connections) {
        Disjoint1 ds = new Disjoint1(n);
        int cntExtra = 0;

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            if (ds.find(u, v)) {
                cntExtra++; // this edge is redundant
            } else {
                ds.unionBySize(u, v);
            }
        }

        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) cntC++;
        }

        int ans = cntC - 1; // number of operations needed
        if (cntExtra >= ans) return ans;
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int V = in.nextInt(); // number of nodes
            int E = in.nextInt(); // number of edges

            int[][] connections = new int[E][2];
            for (int i = 0; i < E; i++) {
                connections[i][0] = in.nextInt();
                connections[i][1] = in.nextInt();
            }

            int result = makeConnected(V, connections);
            System.out.println(result);
        }
    }
}
