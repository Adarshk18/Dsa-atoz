import java.io.*;
import java.util.*;

public class Exponential {

    //using recursion
    public static int pow(int m, int n){
        if (n==0) return 1;
        else return pow(m,n-1)*m;
    }

    //using even odd
    public static int pow1(int m, int n){
        if (n==0) return 1;

        if (n%2==0){
            return pow(m*m,n/2);
        }else{
            return m*pow(m*m,(n-1)/2);
        }
    }

    //using formula
    public static int pow2(int m, int n){
        if (n==0) return 1;

        return (int) Math.pow(m,n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            int m = in.nextInt();
            int n = in.nextInt();
            System.out.println(pow2(m,n));;
        }
    }
}
