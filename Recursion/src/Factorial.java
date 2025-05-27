import java.io.*;
import java.util.*;

public class Factorial {

    //using recursion
    public static int fact(int n){
        if (n==0) return 1;            //TC : O(N), SC: O(N)
        else return fact(n-1)*n;
    }

    //using loop
    public static long fact1(long n){
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;                   //TC : O(N), SC: O(1)
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            long n = in.nextLong();
            System.out.println(fact1(n));;
        }
    }
}
