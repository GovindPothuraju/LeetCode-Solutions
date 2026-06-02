class Solution {
    int[] parent;
    int[] size;

    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    private void unionFind(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // this takes o(n^2 ) time complexity
        /*for (int i = 0; i < n; i++) {
            // add all mails of i to hasset
            HashSet<String> hs = new HashSet();
            List<String> nameList = accounts.get(i);
            for (int k = 1; k < nameList.size(); k++)
                hs.add(nameList.get(k));
            String name = nameList.get(0);

            for (int j = i + 1; j < n; j++) {
                List<String> OtherNameList = accounts.get(j);
                String otherName = OtherNameList.get(0);
                boolean isUnion = false;
                if (name.equals(otherName)) {
                    for (int k = 1; k < OtherNameList.size(); k++) {
                        if (hs.contains(OtherNameList.get(k))){
                            isUnion = true;
                            break;
                        }
                    }
                }
                if (isUnion) {
                    unionFind(i, j);
                }
            }
        } */

        // can i store this privously in hashmap
        HashMap<String , Integer> emailOwner = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String>  account =accounts.get(i);
            for(int j=1;j<account.size();j++){
                String email = account.get(j);
                if(emailOwner.containsKey(email)){
                    unionFind(i , emailOwner.get(email));
                }else{
                    emailOwner.put(email,i);
                }
            }
        }

        HashMap<Integer , Set<String>> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            int root= find(i);
            hm.putIfAbsent(root,new TreeSet<>());
            List<String> account=accounts.get(i);
            for(int k=1;k<account.size();k++){
                hm.get(root).add(account.get(k));
            }
        }

        List<List<String>> res = new ArrayList<>();

        for(int key : hm.keySet()){
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(key).get(0));

            for(String email : hm.get(key)){
                temp.add(email);
            }

            res.add(temp);
        }

        return res;

    }
}