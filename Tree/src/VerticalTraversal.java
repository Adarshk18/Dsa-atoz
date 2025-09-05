import com.sun.source.tree.Tree;

import java.util.*;

public class VerticalTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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

    static class Tuple{
        Node node;
        int row;
        int col;

        Tuple(Node _node, int _row, int _col){
            node= _node;
            row = _row;
            col = _col;
        }
    }

    public static List<List<Integer>> verticalTraversal(Node root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));

        while (!q.isEmpty()){
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }

            if (!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left!=null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }

            if (node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while (!nodes.isEmpty()){
                    System.out.println(nodes.peek());
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();;

        while (t-->0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Node root = buildTreeFromArray(arr);
            List<List<Integer>> ans = verticalTraversal(root);
            System.out.println(ans);
        }
    }
}
