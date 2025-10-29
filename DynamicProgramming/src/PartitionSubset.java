import java.util.*;

public class PartitionSubset {

    public static boolean subsetSum(int n, int k, int[] arr){
        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];
        prev[0] = curr[0] = true;

        if (arr[0]<=k) prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[ind]<=target) take = prev[target-arr[ind]];
                curr[target] = notTake || take;
            }
            prev = curr;
        }
        return prev[k];
    }
    public static boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        if (totalSum%2==1) return false;

        int k = totalSum/2;
        return subsetSum(n,k,nums);
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
             if (canPartition(arr)){
                 System.out.println("true");
             }else{
                 System.out.println("false");
             }
        }
    }
}
