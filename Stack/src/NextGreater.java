import java.util.*;

public class NextGreater {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int num: nums2){
            while (!stack.isEmpty() && stack.peek()<num){
                nge.put(stack.pop(),num);
            }
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nge.getOrDefault(nums1[i],-1);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        
        int n1 = in.nextInt();
        int[] nums1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            nums1[i] = in.nextInt();
        }

        int n2 = in.nextInt();
        int[] nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2[i] = in.nextInt();
        }

        int[] res = nextGreaterElement(nums1,nums2);
        for(int val : res){
            System.out.print(val + " ");
        }
    }
}
