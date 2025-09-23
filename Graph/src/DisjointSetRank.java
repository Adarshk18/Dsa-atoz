import java.util.*;

public class DisjointSetRank {
    private int[] rank;
    private int[] parent;
    private int[] size;

    public void DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    private int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }


    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u==ulp_v) return;

        if (rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }else if (rank[ulp_v] < rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u==ulp_v) return;

        if (size[ulp_u]<size[ulp_v]){
           parent[ulp_u] = ulp_v;
           size[ulp_v] += size[ulp_u];

        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int q = in.nextInt();


        }
    }
}
