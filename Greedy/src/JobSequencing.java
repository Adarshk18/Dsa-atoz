import java.util.*;

public class JobSequencing {

    static class Jobs{
        int id, profit, deadline;
        Jobs(int id, int profit, int deadline){
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    public static int[] JobScheduling(int[][] Jobs) {
        // your code goes here
        int n = Jobs.length;
        Arrays.sort(Jobs,(a,b)-> (b[2] - a[2]));

        int maxi =0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi,Jobs[i][1]);
        }

        int[] res = new int[maxi+1];
        Arrays.fill(res,-1);

        int cnt=0,profit=0;
        for (int i = 0; i < n; i++) {
            for (int j = Jobs[i][1]; j > 0; j--) {
                if (res[j]==-1){
                    res[j] = i;
                    cnt++;
                    profit += Jobs[i][2];
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = cnt;
        ans[1] = profit;
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[][] Jobs = new int[n][3];
            for (int i = 0; i < n; i++) {
                Jobs[i][0] = in.nextInt();
                Jobs[i][1] = in.nextInt();
                Jobs[i][2] = in.nextInt();
            }
            int[] ans = JobScheduling(Jobs);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
