class Solution {
    int[] parent;
    int[] size;
    private int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node] =find(parent[node]);
    }
    private boolean findu(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv)return true;
        if(size[pu] < size[pu]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] res=new int[2];
        
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int[] temp : edges){
            int u=temp[0];
            int v=temp[1];
            if(findu(u,v)){
                res=new int[]{u,v};
            }
        }
        return res;
    }
}