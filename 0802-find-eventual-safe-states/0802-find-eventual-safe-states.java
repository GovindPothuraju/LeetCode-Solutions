class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res=new ArrayList<>();
        int v=graph.length;
        // i check all vertices one by one if any cycle exists i skip otherwise i add to my res but it take smore time
        // i take a cycle array if no cycle i add to res otherwise i skip 
        boolean[] cycle=new boolean[v];
        boolean[] path=new boolean[v];
        boolean[] visited=new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                backtrack(i,graph,visited,path,cycle);
            }
        }

        System.out.println(Arrays.toString(cycle));
        // add which node have no cycle to res
        for(int i=0;i<v;i++){
            if(!cycle[i])res.add(i);
        }
        return res;
    }
    private boolean backtrack(int node,int[][] graph,boolean[] visited, boolean[] path,boolean[] cycle){
        visited[node]=true;
        path[node]=true;
        for(int nei : graph[node]){
            if(!visited[nei]){
                if(backtrack(nei,graph,visited,path,cycle)){
                    cycle[nei]=true;
                    cycle[node]=true;
                    System.out.println(nei+" "+node);
                    return true;
                }
            }else if(path[nei]){
                cycle[nei]=true;
                cycle[node]=true;
                System.out.println(nei+" "+node);
                return true;
            }
        }
        path[node]=false;
        return false;
    }
}