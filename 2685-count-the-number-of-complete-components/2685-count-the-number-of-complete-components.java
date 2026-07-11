class Solution {
    int[] parent;
    int[] size;
    private int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    private boolean findUnion(int u,int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv)return true;
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return false;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            findUnion(u,v);
        }
        
        // build vertices
        int[] vertices = new int[n];
        for(int i=0;i<n;i++){
            int root = find(i);
            vertices[root]++;
        }
        // build edges
        int[] noOfEdges = new int[n];
        for(int[] edge : edges){
            int root = find(edge[0]);
            noOfEdges[root]++;
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(vertices[i]==0)continue;
            int temp = (vertices[i]*(vertices[i]-1)) / 2;
            if(temp == noOfEdges[i])count++;
        }
        
        return count;
    }
}