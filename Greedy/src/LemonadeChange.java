import java.util.*;

public class LemonadeChange {
    public static boolean lemonadeChange(List<Integer> bills) {
        int five =0;
        int ten = 0;

        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i)==5){
                five++;
            }else if (bills.get(i)==10){
                if (five>0){
                    five--;
                    ten++;
                }else {
                    return false;
                }
            }else{
                //for $20
                if (five>0 && ten>0){
                    five--;
                    ten--;
                }else if (five>=3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            List<Integer> bills = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                bills.add(in.nextInt());
            }

           boolean res = lemonadeChange(bills);
            System.out.println( res ? "TRUE": "FALSE");
        }
    }
}
