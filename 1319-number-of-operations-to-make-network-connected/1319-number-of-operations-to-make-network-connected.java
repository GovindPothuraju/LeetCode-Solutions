class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp : connections){
            int u=temp[0];
            int v=temp[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                backtrack(i,adj,visited);
            }
        }
        return count-1;
    }
    public void backtrack(int node ,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int nei : adj.get(node)){
            if(!visited[nei]){
                backtrack(nei,adj,visited);
            }
        }
    }
}