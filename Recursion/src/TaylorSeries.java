import java.util.Scanner;

public class TaylorSeries {

//    public static double Taylor(int x, int n) {
//        double sum = 0;
//        for (int i = 0; i <= n; i++) {
//            sum +=  pow(x, i) / fact(i);
//        }
//        return sum;
//    }
//
//    public static int fact(int n){
//        if (n==0) return 1;
//
//        int fact = 1;
//        for (int i = 1; i <= n; i++) {
//            fact *= i;
//        }
//        return fact;
//    }
//
//    public static double pow(int x, int n){
//        if (n==0) return 1;
//
//        return (int) Math.pow(x,n);
//    }

    //optimal
    public static double Taylors(int x, int n){
        double sum =0;
        double power = 1;
        double fact = 1;


        for (int i = 0; i <= n; i++) {
            if (i>0){
                power *= x;
                fact *= i;
            }
            sum += power/fact;
        }
        return sum;
    }

    public static double Taylor3(int x, int n){
        double s =1;
        for (int i = n; i > 0; i--) {
            s = 1+(x/(double)i)*s;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            int x = in.nextInt();
            int n = in.nextInt();
            System.out.println(Taylor3(x,n));;
        }
    }
}
