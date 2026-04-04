class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int des=graph.length-1;
        List<Integer> path=new ArrayList<>();
        path.add(0);
        backtrack(path,0,des,graph);
        return res;
    }
    private void backtrack(List<Integer> path,int s,int d,int[][] graph){
        if(s==d){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int node:graph[s]){
            path.add(node);
            backtrack(path,node,d,graph);
            path.remove(path.size()-1);
        }
    }
}