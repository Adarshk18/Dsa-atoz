import java.util.*;


public class MinPathSum2 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] front = new int[n]; // to store the next rows
        int[] curr = new int[n]; //to store the current rows
        for (int j = 0; j < n; j++) {
            front[j]= triangle.get(n-1).get(j);
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j+1];

                curr[j] = Math.min(down,diagonal);
            }
            front = curr.clone();
        }
        return front[0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            List<List<Integer>> triangle = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                triangle.add(new ArrayList<>());
            }
            System.out.println(minimumTotal(triangle));
        }
    }
}
