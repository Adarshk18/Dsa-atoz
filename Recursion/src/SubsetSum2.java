import java.util.*;

public class SubsetSum2 {

    private static void sub(int ind, int[] arr, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < arr.length; i++) {
            if (i!=ind && arr[i]==arr[i-1]){
                continue;
            }
            ds.add(arr[i]);
            sub(i+1,arr,ds,ans);
            ds.remove(ds.size()-1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        sub(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            List<List<Integer>> ans = subsetsWithDup(arr);
            System.out.println(ans);
        }
    }
}
