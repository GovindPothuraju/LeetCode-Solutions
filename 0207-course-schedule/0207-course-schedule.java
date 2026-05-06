class Solution {
    /* using BFS OR khan's algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edges : prerequisites){
            int u=edges[0];
            int v=edges[1];
            adj.get(v).add(u);
        }
        // find all the indegrees
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int nei:adj.get(i)){
                indegree[nei]++;
            }
        }
        // take q and push all nodes with indegree == 0
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }
        // pop each element from q until empty and reduce 1 to all its neightbours and if any indegree[nei]==0 add to q
        int k=0;
        while(!q.isEmpty()){
            int node=q.poll();
            k++;
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        // the k value represents the no of nodes are visited linearly u must visited before v 
        // if k==n that mean all nodes are visited topologically and no cyclye exists
        return k==numCourses;
    }*/

    // using dfs
    public boolean canFinish(int numCourses, int[][] prerequisites){

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp : prerequisites){
            int u=temp[0];
            int v=temp[1];
            adj.get(v).add(u);
        }
        
        boolean[] visited=new boolean[numCourses];
        boolean[] path=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(backtrack(i,adj,visited,path)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean backtrack(int node,List<List<Integer>> adj,boolean[] visited,boolean[] path){
        visited[node]=true;
        path[node]=true;
        for(int nei:adj.get(node)){
            if(!visited[nei]){
                if(backtrack(nei,adj,visited,path)){
                    return true;
                }
            }else if(path[nei]){
                return true;
            }
        }
        path[node]=false;
        return false;
    }
}