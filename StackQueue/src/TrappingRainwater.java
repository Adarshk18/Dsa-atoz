import java.util.*;

public class TrappingRainwater {
    public static  int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax=0, total=0;
        int l =0,r =n-1;

        while (l<r){
            if (height[l]<height[r]){
                if (leftMax <= height[l])
                    leftMax = height[l];
                else
                    total += leftMax - height[l];

                l++;
            }else{
                if (rightMax<=height[r])
                    rightMax = height[r];

                else
                    total += rightMax-height[r];

                r--;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();

            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = in.nextInt();
            }

            System.out.println(trap(height));
        }
    }
}
