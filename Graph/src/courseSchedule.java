import java.util.*;

public class courseSchedule {
    public static boolean checkCycle(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[]  indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i]==0) q.add(i);
        }


        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()){
            int node = q.poll();

           topo.add(node);

            for(int it: adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0) q.add(it);
            }
        }
        return topo.size() == numCourses;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int V = in.nextInt();

            int E = in.nextInt();

            int[][] prereq = new int[E][2];
            for (int i = 0; i < E; i++) {
                prereq[i][0] = in.nextInt();
                prereq[i][1] = in.nextInt();
            }

            if (checkCycle(V,prereq)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }

        }
        in.close();
    }
}
