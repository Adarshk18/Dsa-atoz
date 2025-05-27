import java.util.*;


public class CombinationsSum {

    private static void backtrack(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if (ind==arr.length){
            if (target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[ind]<=target){
            ds.add(arr[ind]);
            backtrack(ind, arr, target-arr[ind],ans, ds);
            ds.remove(ds.size()-1);
        }
        backtrack(ind+1,arr,target,ans,ds);
    }

    public static List<List<Integer>> combinations(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
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

            CombinationsSum ob = new CombinationsSum();
            List<List<Integer>> ls = ob.combinations(arr,target);
            for (int i = 0; i < ls.size(); i++) {
                for (int j = 0; j < ls.get(i).size(); j++) {
                    System.out.print(ls.get(i).get(j)+ " ");
                }
                System.out.println();
            }
        }
    }
}
