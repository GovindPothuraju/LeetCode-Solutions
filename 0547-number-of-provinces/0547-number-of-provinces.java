class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int st,int[][] isConnected,boolean[] visited){
        visited[st]=true;
        for(int j=0;j<isConnected.length;j++){
            if(!visited[j] && isConnected[st][j]==1){
                dfs(j,isConnected,visited);
            }
        }
    }
}