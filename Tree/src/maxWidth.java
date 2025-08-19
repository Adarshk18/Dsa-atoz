import java.util.*;



public class maxWidth {
    static class Node {
        int data;
      Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class Pair{
        Node node;
        int index;

        Pair(Node _node, int _index){
            node = _node;
            index = _index;
        }
    }

    public static Node buildTreeFromArray(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            // Left child
            if (arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public int widthOfBinaryTree(Node root) {
        if (root==null) return 0;

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while (!q.isEmpty()){
            int n = q.size();
            int mmin = q.peek().index;

            int first=0,last=0;

            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                int curr_id = p.index-mmin;
                Node node = p.node;


                if (i==0){
                    first = curr_id;
                }

                if (i==n-1){
                    last = curr_id;
                }

                if (node.left!=null){
                    q.add(new Pair(node.left,curr_id*2+1));
                }

                if (node.right!=null){
                    q.add(new Pair(node.right,curr_id*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Node root = buildTreeFromArray(arr);

            maxWidth mw = new maxWidth();
            System.out.println(mw.widthOfBinaryTree(root));

        }
    }
}
