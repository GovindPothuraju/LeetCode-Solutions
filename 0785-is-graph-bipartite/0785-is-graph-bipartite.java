class Solution {
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int[] colored = new int[v];

        for(int i=0;i<v;i++)colored[i]=-1;

        for(int i=0;i<v;i++){
            if(colored[i]==-1){
                if(!backtrack(i,0,graph,colored)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean backtrack(int v,int color,int[][] graph,int[] colored){
        colored[v]=color;
        for(int nei:graph[v]){
            if(colored[nei]==-1){
                if(!backtrack(nei,1-colored[v],graph,colored)){
                    return false;
                }
            }else if(colored[nei]==colored[v]){
                return false;
            }
        }
        return true;
    }
}