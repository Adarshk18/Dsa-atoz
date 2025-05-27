import java.util.*;

public class CombinationSum3 {

    private static void backtrack(int k, int n, int start, List<Integer> curr, List<List<Integer>> ans){
        if (k==0 && n==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (k==0 ||n<=0 || start>9){
            return;
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(k-1,n-i,i+1,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k,n,1,new ArrayList<>(),ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0){
            int k = in.nextInt();
            int n = in.nextInt();

            List<List<Integer>> ans = combinationSum3(k,n);
            System.out.println(ans);
        }
    }
}
