import java.util.*;

public class CombinationSum2 {

    private static void backtrack(int ind, int[] arr, int target, List<List<Integer>> ans , List<Integer> ds){
        if (target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i-1]) continue;
            if (arr[i]>target) break;

            ds.add(arr[i]);
            backtrack(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0){
            int n = in.nextInt();
            int target = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

//            CombinationSum2 cbs = new CombinationSum2();
            List<List<Integer>> comb = combinationSum2(arr,target);
            System.out.println(comb.toString().replace(","," "));
        }
    }
}
