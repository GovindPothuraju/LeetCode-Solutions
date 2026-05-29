class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat=new int[n][n];
        // 1.matrix creation
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) mat[i][j]=0;
                else mat[i][j]=Integer.MAX_VALUE;
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
                    if(mat[i][k]==Integer.MAX_VALUE || mat[k][j]==Integer.MAX_VALUE) continue;
                    //apply formula
                    mat[i][j]=Math.min(mat[i][j] , mat[i][k]+mat[k][j]);
                }
            }
        }
        // 3. i need to find how many values from each node are less than threshold and also i find the lessNodes
        int[] mini=new int[n];
        int lessNodes=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]!=0 && mat[i][j]<=distanceThreshold){
                    sum++;
                }
            }
            mini[i]=sum;
            lessNodes=Math.min(sum,lessNodes);
        }
        // 4 i traverse the array if any value is equal to lessNodes then i update res;
        int res=0;
        for(int i=0;i<n;i++){
            if(mini[i]==lessNodes)res=i;
        } 
        return res;
    }
}