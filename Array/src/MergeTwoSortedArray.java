import java.util.*;


public class MergeTwoSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        int[] c = new int[n+m];

        int i=0,j=0,k=0;
        while(i<n && j<m){
            if (a[i]<b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j++];
            }
        }
        while(i<n) {
            c[k++] = a[i++];
        }
        while(j<m) {
            c[k++] = b[j++];
        }

        for (i = 0; i < n+m; i++) {
            System.out.print(c[i] +" ");
        }
        System.out.println();
    }
}
