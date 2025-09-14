import java.util.*;

public class SafeStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : graph[i]) {
                reverseGraph.get(it).add(i);
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        boolean[] isSafe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            isSafe[node] = true;

            for (int it : reverseGraph.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        List<Integer> safeNode = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                safeNode.add(i);
            }
        }
        return safeNode;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int V = in.nextInt();


            int[][] prereq = new int[V][];
            for (int i = 0; i < V; i++) {
                int k = in.nextInt();
                prereq[i] = new int[k];
                for (int j = 0; j < V; j++) {
                    prereq[i][j] = in.nextInt();
                }
            }

            List<Integer> safe = eventualSafeNodes(prereq);
            System.out.println(safe);
        }
        in.close();
    }
}
