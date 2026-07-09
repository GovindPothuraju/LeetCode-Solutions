class Solution {
    int n;
    int[] parent ;
    int[] size;
    private int find(int node){
        if(parent[node] == node)return node;
        return parent[node] = find(parent[node]);
    }
    private boolean unionFind(int u,int v){
        int pu = find(u);
        int pv = find(v);
        if(pu==pv) return true;
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return false;
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        int par = 0;
        int maxSoFar = nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]-maxSoFar <= maxDiff){
                unionFind(par,i);
                maxSoFar = Math.max(maxSoFar,nums[i]);
            }else{
                par = i;
                maxSoFar = nums[i];
            }
        }
        boolean[] res = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(parent[l] == parent[r]){
                res[i]=true;
            }else{
                res[i] = false;
            }
        }
        return res;
    }
}