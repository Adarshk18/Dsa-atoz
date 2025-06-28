//print all the subsequences whose sum is equals to the given sum k

// so the logic for this one would be if the base condition inside the function satisfied then return true else return false and call the function.
// as it will never print the next subsequence if the above one is met.


import java.util.*;

public class SubSequence2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            List<Integer> ds = new ArrayList<>();
//            System.out.println(k);
            printSum(0,ds,0,k,arr,n);
        }
    }

    public static boolean printSum(int ind, List<Integer> ds, int s, int k, int[] arr,int n){
        if (ind==n){
            //base condition satisfied
            if (s==k){
                for(int a: ds){
                    System.out.print(a+ " ");
                }
                System.out.println();
                return true;
            }
            return false;

        }

        //pick the element
        ds.add(arr[ind]);
        if (printSum(ind+1,ds,s+arr[ind],k,arr,n)){
            return true;
        }

        //backtrack
        ds.remove(ds.size()-1);
//
        //not pick
        if (printSum(ind+1,ds,s,k,arr,n)){
            return true;
        }

        return false;
    }
}
