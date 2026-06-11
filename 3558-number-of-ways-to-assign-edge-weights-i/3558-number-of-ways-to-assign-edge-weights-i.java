class Solution {
    private long depth = 0;
    int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length;
        int nodes = n+1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=nodes;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp:edges){
            int u = temp[0];
            int v = temp[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[nodes+1];
        for(int i=0;i<=nodes;i++){
            if(!visited[i]){
                dfs(i,adj,0l,visited);
            }
        }
        return (int) modPow(2, depth-1);
    }
    private void dfs(int node ,ArrayList<ArrayList<Integer>> adj , long d,boolean[] visited){
        visited[node] = true;
        depth = Math.max(depth,d);
        for(int v:adj.get(node)){
            if(!visited[v]){
                dfs(v,adj,d+1,visited);
            }
        }
    }

    private long modPow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}