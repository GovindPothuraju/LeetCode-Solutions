// using df

/*class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp : connections){
            int u=temp[0];
            int v=temp[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                backtrack(i,adj,visited);
            }
        }
        return count-1;
    }
    public void backtrack(int node ,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int nei : adj.get(node)){
            if(!visited[nei]){
                backtrack(nei,adj,visited);
            }
        }
    }
}*/

class Solution {
    int[] parent;
    int[] size;
    public int find(int node){
        if(node == parent[node])return node;
        return parent[node]=find(parent[node]);
    }
    public boolean unionFind(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv)return true;
        if(size[pu] < size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
        return false;
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        parent =new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        int count=0;
        for(int[] temp : connections){
            int u=temp[0];
            int v=temp[1];
            unionFind(u,v);
        }
        System.out.println(Arrays.toString(parent));
        for(int i=0;i<n;i++){
            if(parent[i] == i)count++;
        }
        return count-1;
    }
}