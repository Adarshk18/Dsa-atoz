import java.util.Scanner;

public class func1 {

    public static void func1(int n){
        if (n>0){
            System.out.print(n + " ");
            func1(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        while(t-->0){
            int x = in.nextInt();
            func1(x);
        }
    }
}
