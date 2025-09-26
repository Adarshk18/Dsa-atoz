import java.util.*;

class Disjoint3 {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint3(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int root = findParent(parent.get(node));
        parent.set(node, root); // path compression
        return root;
    }

    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class AccountMerge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint3 ds = new Disjoint3(n);
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)){
                    map.put(mail,i);
                }else{
                    ds.unionBySize(i,map.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String,Integer> it: map.entrySet()){
            String mail = it.getKey();
            int node = ds.findParent(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); in.nextLine();
        while (t-->0){
            int n = in.nextInt(); in.nextLine();
            
            List<List<String>> accounts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                String[] parts = line.split(" ");
                accounts.add(Arrays.asList(parts));
            }

            List<List<String>> ans = accountsMerge(accounts);
            for(List<String> acc: ans){
                System.out.println(acc);
            }

        }
    }
}
