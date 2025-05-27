import java.io.*;
import java.util.*;

public class NaturalNumbers {

    //using recursion
    public static int sum(int n){
        if (n==0) return 0;            //TC : O(N), SC: O(N)
        else return sum(n-1)+n;
    }

    //using loop
    public static int sum1(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;                   //TC : O(N), SC: O(1)
        }
        return sum;
    }

    //using direct formula
    public static int sum2(int n){
        return n*(n+1)/2;       //TC : O(1), SC: O(1)
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            System.out.println(sum2(n));;
        }
    }
}
