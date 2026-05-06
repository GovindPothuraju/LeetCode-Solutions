class Solution {
    /* using khan's algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edges : prerequisites){
            int u=edges[0];
            int v=edges[1];
            //If I take this edge direction, will indegree=0 mean ‘ready to take’?
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
        // every time the popped value is added to q
        int[] res= new int[numCourses];
        int k=0;
        while(!q.isEmpty()){
            int node=q.poll();
            res[k++]=node;
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if(k != numCourses) return new int[0];
        return res;
    }*/
    
    // using topological sort by using dfs (bottom-up approach) + topological sort
    int[] res;
    int k=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edges : prerequisites){
            int u=edges[0];
            int v=edges[1];
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] path=new boolean[numCourses];
        res=new int[numCourses];
        k=0;
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(backtrack(i,visited,adj,path)){
                    return new int[0];
                }
            }
        }
        reverse(res);
        return res;
    }
    private boolean backtrack(int node,boolean[] visited,List<List<Integer>> adj,boolean[] path){
        visited[node]=true;
        path[node]=true;
        for(int nei:adj.get(node)){
            if(!visited[nei]){
                if(backtrack(nei,visited,adj,path)){
                    return true;
                }
            }else if(path[nei]){
                return true;
            }
        }
        path[node]=false;
        res[k++]=node;
        return false;
    }
    private void reverse(int[] res){
        int l=0;
        int r=res.length-1;
        while(l<r){
            int temp=res[l];
            res[l]=res[r];
            res[r]=temp;
            l++;
            r--;
        }
    }

}