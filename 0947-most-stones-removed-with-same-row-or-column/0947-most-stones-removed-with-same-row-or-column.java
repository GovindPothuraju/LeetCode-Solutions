class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int components = 0;

        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                components++;
                backtrack(i,stones,visited);
            }
        }
        return n-components;
    }
    private void backtrack(int node,int[][] stones,boolean[] visited){
        visited[node] = true;
        for(int next=0 ; next<stones.length;next++){
            if(!visited[next] &&  (
                stones[node][0]==stones[next][0] ||
                stones[node][1]==stones[next][1]
            )){
                backtrack(next,stones,visited);
            }
        }
    }
}