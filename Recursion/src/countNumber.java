import java.io.*;
import java.util.*;

public class countNumber {
    static final long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n){
        long evenPos = (n+1)/2;
        long oddPos = n/2;

        long evenWays = power(5,evenPos);
        long oddWays = power(4,oddPos);

        return (int)((evenWays*oddWays)%MOD);
    }

    private static long power(long base, long exp){
        long result = 1;
        base %= MOD;
        while (exp>0){
            if ((exp&1)==1){
                result = (result*base)%MOD;
            }
            base = (base*base)%MOD;
            exp>>=1;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            long n = in.nextLong();
            System.out.println(countGoodNumbers(n));
        }
    }
}
