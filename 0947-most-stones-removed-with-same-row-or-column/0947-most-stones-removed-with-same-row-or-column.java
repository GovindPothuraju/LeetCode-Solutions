class Solution {
    int[] parent;
    int[] size;
    private int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=find(parent[node]);
    }
    private void unionf(int u,int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv)return ;
        if(size[pu] < size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;

        parent = new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int row=stones[i][0];
                int col=stones[i][1];

                int otherRow=stones[j][0];
                int otherCol=stones[j][1];

                if(row==otherRow || col==otherCol){
                    unionf(i,j);
                }
            }
        }

        int components=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                components++;
            }
        }
        return n-components;
    }
}



/*class Solution {
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
}*/