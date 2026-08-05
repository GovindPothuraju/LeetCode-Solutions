class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp:invocations){
            int u = temp[0];
            int v = temp[1];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n];
        dfs(k,adj,visited);

        System.out.println(Arrays.toString(visited));
        
        for(int[] temp:invocations){
            int u = temp[0];
            int v = temp[1];
            if(!visited[u] && visited[v]){
                List<Integer> res = new ArrayList<>();
                for(int i=0;i<n;i++)res.add(i);
                return res;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i])res.add(i);
        }
        return res;
    }
    private void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int nei : adj.get(node)){
            if(!visited[nei]){
                dfs(nei,adj,visited);
            }
        }
    }
}