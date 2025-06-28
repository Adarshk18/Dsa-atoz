//print all the subsequences whose sum is equals to the given sum k

// so the logic for this one would be if the base condition inside the function satisfied then return 1 else return 0
// and call the left and right function.
// return left+right.
//remove the ds

import java.util.*;

public class countSubsequences {
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

//            List<Integer> ds = new ArrayList<>();
//            System.out.println(k);
            System.out.println(printSum(0,0,k,arr,n));
        }
    }

    public static int printSum(int ind, int s, int k, int[] arr,int n){
        if (ind==n){
            //base condition satisfied
            if (s==k){
                return 1;
            }
            return 0;
        }

        //pick the element

      int l = printSum(ind+1,s+arr[ind],k,arr,n);
//
        //not pick
        int r = printSum(ind+1,s,k,arr,n);

        return l+r;
    }
}
