class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q=new LinkedList<>();
        boolean visited[] = new boolean[n];

        q.add(source);
        visited[source]=true;
        
        while(!q.isEmpty()){
            int curr=q.poll();
            if(visited[destination]){
                return true;
            }
            for(int nei:adj.get(curr)){
                if(!visited[nei]){
                    q.add(nei);
                    visited[nei]=true;
                }
            }
        }
        return false;
    }
}