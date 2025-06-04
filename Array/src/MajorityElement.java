import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int cnt1=0,cnt2=0;
            int el1 = Integer.MIN_VALUE;
            int el2 = Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                if (cnt1==0 && el2!=arr[i]){
                    cnt1 =1;
                    el1 = arr[i];
                }else if(cnt2==0 && el1!=arr[i]){
                    cnt2 = 1;
                    el2 = arr[i];
                }else if(arr[i]==el1) cnt1++;
                else if(arr[i]==el2) cnt2++;
                else{
                    cnt1--;
                    cnt2--;
                }

            }
            List<Integer> ls = new ArrayList<>();

            cnt1 =0;cnt2=0;
            for(int i=0; i<n; i++){
                if (arr[i]==el1) cnt1++;
                if (arr[i]==el2) cnt2++;
            }

            int mini = (int)(n/3)+1;
            if (cnt1>=mini) ls.add(el1);
            if (cnt2>=mini) ls.add(el2);

            System.out.println(ls);

        }
    }
}
