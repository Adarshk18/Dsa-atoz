import java.util.*;

public class Expression {
    private void backtrack(String num, int target, int index, String expression, long currentVal, long prevNum, List<String> res){
        if (index==num.length()){
            if (currentVal==target){
                res.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i!=index && num.charAt(i)=='0'){
                break;
            }

            long currentNum = Long.parseLong(num.substring(index,i+1));
            if (index==0){
                backtrack(num,target,i+1,currentNum+"",currentVal,currentNum,res);
            }else{
                backtrack(num,target,i+1,expression + "+" + currentNum,currentVal+currentNum,currentNum,res);
                backtrack(num,target,i+1,expression + "-"+currentNum,currentVal-currentNum,-currentNum,res);
                backtrack(num,target,i+1,expression + "*"+currentNum,currentVal-prevNum+prevNum*currentNum,prevNum*currentNum,res);
            }
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine()); // Read full line to avoid newline issues

        while (t-- > 0) {
            String num = in.nextLine();           // Read numeric string
            int target = Integer.parseInt(in.nextLine()); // Read target as integer

            List<String> res = new ArrayList<>();
            new Expression().backtrack(num, target, 0, "", 0, 0, res);

            System.out.println("Expressions that evaluate to " + target + ":");
            for (String expr : res) {
                System.out.println(expr);
            }
        }

        in.close();
    }

}
