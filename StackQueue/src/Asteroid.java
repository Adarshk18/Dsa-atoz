import java.util.*;

public class Asteroid {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int asteroid: asteroids){
            if (asteroid>0){
                st.push(asteroid);
            }else{
                while (!st.isEmpty() && st.peek() >0 && st.peek() < Math.abs(asteroid)){
                    st.pop();
                }
                if (st.isEmpty() || st.peek()<0){
                    st.push(asteroid);
                }else if (st.peek() == Math.abs(asteroid)){
                    st.pop();
                }
            }
        }
        int[] res = new int[st.size()];
        for (int i = st.size()-1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(Arrays.toString(asteroidCollision(arr)));
        }
    }
}
