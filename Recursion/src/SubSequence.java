//print all the subsequences whose sum is equals to the given sum k
import java.util.*;

public class SubSequence {
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

    public static void printSum(int ind, List<Integer> ds, int s, int k, int[] arr,int n){
        if (ind==n){
            if (s==k){
                for(int a: ds){
                    System.out.print(a+ " ");
                }
                System.out.println();
            }
            return;
        }

        //pick the element
        ds.add(arr[ind]);
        printSum(ind+1,ds,s+arr[ind],k,arr,n);

        //backtrack
        ds.remove(ds.size()-1);

        //not pick
        printSum(ind+1,ds,s,k,arr,n);
    }
}
