import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int target = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
             List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(arr);

            for (int i = 0; i < n-3; i++) {
                if (i>0 && arr[i]==arr[i-1]) continue;

                for (int j = i+1; j < n-2; j++) {
                    if (j>i+1 && arr[j]==arr[j-1]) continue;

                    int k = j+1;
                    int l = n-1;
                    while (k<l){
                        long sum = arr[i];
                        sum += arr[j];
                        sum += arr[k];
                        sum += arr[l];

                        if (sum==target){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[k]);
                            temp.add(arr[l]);
                            ans.add(temp);
                            k++;
                            l--;

                            while (k<l && arr[k]==arr[k-1]) k++;
                            while (k<l && arr[l]==arr[l+1]) l--;
                        }else if (sum<target){
                            k++;
                        }else{
                            l--;
                        }
                    }
                }
            }

            System.out.print("[");
            for (List<Integer> ss: ans){
                System.out.print("[");
                for(int it: ss){
                    System.out.print(it + " ");
                }
                System.out.print("]");
                System.out.print(",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
