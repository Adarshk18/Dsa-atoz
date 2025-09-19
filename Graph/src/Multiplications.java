import java.util.*;

public class Multiplications {
    static class Pair{
        int first; int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));

        int[] dist = new int[100000];
        Arrays.fill(dist, (int)(1e9));
        dist[start] = 0;
        int mod = 100000;
        int n = arr.length;

        while (!q.isEmpty()){
            Pair p = q.poll();
            int node = p.first;
            int steps = p.second;

            for (int i = 0; i < n; i++) {
                int num = (arr[i]*node) % mod;

                if (steps+1 < dist[num]){
                    dist[num] = steps+1;

                    if (num == end) return steps+1;
                    q.add(new Pair(num,steps+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int start = in.nextInt();
            int end = in.nextInt();

            int ans = minimumMultiplications(arr,start,end);
            System.out.println(ans);
        }
    }
}
