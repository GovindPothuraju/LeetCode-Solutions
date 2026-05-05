class Solution {
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
    }
}