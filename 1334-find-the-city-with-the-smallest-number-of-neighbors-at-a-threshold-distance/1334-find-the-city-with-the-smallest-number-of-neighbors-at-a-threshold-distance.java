class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat=new int[n][n];
        int INF = (int)1e9;
        // 1.matrix creation
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) mat[i][j]=0;
                else mat[i][j]=INF;
            }
        }
        for(int[] temp:edges){
            int u=temp[0];
            int v=temp[1];
            int wt=temp[2];
            mat[u][v]=wt;
            mat[v][u]=wt;
        }
        // 2. apply floyd warshall
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k]==INF || mat[k][j]==INF) continue;
                    //apply formula
                    mat[i][j]=Math.min(mat[i][j] , mat[i][k]+mat[k][j]);
                }
            }
        }
        // 3. i need to find how many values from each node are less than threshold and also i find the ans
        int ans=-1;
        int minCount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]!=0 && mat[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=minCount){
                minCount=count;
                ans=i;
            }
        }
        return ans;
    }
}